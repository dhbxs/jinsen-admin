package top.dhbxs.jinsen.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import top.dhbxs.jinsen.admin.entity.UserEntity;
import top.dhbxs.jinsen.admin.mapper.UserMapper;
import top.dhbxs.jinsen.admin.service.IUserService;
import top.dhbxs.jinsen.admin.service.ex.InsertException;
import top.dhbxs.jinsen.admin.service.ex.UsernameDuplicatedException;

import java.util.Date;
import java.util.UUID;

/**
 * 用户模块业务层实现类
 */
@Service // 将当前类的对象交给Spring来管理，自动创建对象以及对象的维护
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(UserEntity user) {
        // 通过user参数来获取传递过来的username
        String username = user.getUsername();
        // 调用findByUsrname 判断用户名是否被注册过
        UserEntity result = userMapper.findByUsername(username);
        // 判断结果是否不为null，否则抛出用户名被占用异常
        if (result != null) {
            // 抛出异常
            throw new UsernameDuplicatedException("用户名被占用");
        }

        // 密码加密处理 MD5算法加密
        // 盐值 + password + 盐值 盐值是随机字符串
        String oldPassword = user.getPassword();
        // 获取盐值（随机生成）
        String salt = UUID.randomUUID().toString().toUpperCase();
        // 将密码和盐值作为整体做加密处理

        String md5Password = getMD5Password(oldPassword, salt);

        // 将加密后的密码重新补全到设置的user对象中，忽略密码的强度，提升安全性
        user.setPassword(md5Password);
        // 将盐值记录补全
        user.setSalt(salt);

        // 补全数据 isDelete 0 还有2条日志字段信息
        Date date = new Date();
        user.setIsDelete(0);
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        // 执行注册业务逻辑功能
        Integer rows = userMapper.insert(user);
        if (rows != 1) {
            throw new InsertException("在用户注册过程中产生了未知的异常");
        }
    }

    /**
     *
     * @param password 明文密码
     * @param salt 随机盐值
     * @return 加密后的密码（密文）
     */
    private String getMD5Password(String password, String salt) {
        for (int i = 0; i < 3; i++) {
            // MD5加密算法调用
            password = DigestUtils.md5DigestAsHex((salt + password +salt).getBytes()).toUpperCase();
        }
        // 返回加密之后的密码
        return password;
    }
}
