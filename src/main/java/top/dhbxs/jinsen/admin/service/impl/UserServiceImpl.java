package top.dhbxs.jinsen.admin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import top.dhbxs.jinsen.admin.controller.dto.UserDto;
import top.dhbxs.jinsen.admin.entity.UserEntity;
import top.dhbxs.jinsen.admin.mapper.UserMapper;
import top.dhbxs.jinsen.admin.service.IUserService;
import top.dhbxs.jinsen.admin.service.ex.InsertException;
import top.dhbxs.jinsen.admin.service.ex.UserPasswordNotMatchException;
import top.dhbxs.jinsen.admin.service.ex.UsernameDuplicatedException;
import top.dhbxs.jinsen.admin.service.ex.UsernameNotFoundException;
import top.dhbxs.jinsen.admin.util.TokenUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 用户模块业务层实现类
 */
@Service // 将当前类的对象交给Spring来管理，自动创建对象以及对象的维护
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册业务逻辑
     * @param user 用户实体对象
     */
    @Override
    public void register(UserEntity user) {
        // 通过user参数来获取传递过来的username
        String username = user.getUsername();
        // 调用findByUsrname 判断用户名是否被注册过

        // 创建条件构造器
        QueryWrapper<UserEntity> QueryWrapper = new QueryWrapper<>();
        // 向条件构造器中加入条件
        QueryWrapper.eq("username", username);

        // 用条件构造器查找数据
        UserEntity result = userMapper.selectOne(QueryWrapper);


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
        int rows = userMapper.insert(user);
        if (rows != 1) {
            throw new InsertException("在用户注册过程中产生了未知的异常");
        }
    }

    /**
     * MD5给密码加密
     * @param password 明文密码
     * @param salt     随机盐值
     * @return 加密后的密码（密文）
     */
    private String getMD5Password(String password, String salt) {
        // 循环3次，即加密算法加密三次
        for (int i = 0; i < 3; i++) {
            // MD5加密算法调用 盐值 + 密码 + 盐值 组合
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        // 返回加密之后的密码
        return password;
    }

    /**
     * 用户登录业务逻辑
     * @param user 用户实体对象
     * @return 用户实体
     */
    @Override
    public UserDto login(UserDto user) {
        String username = user.getUsername();
        String password = user.getPassword();
        // 调用Hutool工具类提供的校验字符串是否为空
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            throw new UsernameNotFoundException("用户名为空");
        }

        // 通过用户名查找数据
        QueryWrapper<UserEntity> QueryWrapper = new QueryWrapper<>();
        QueryWrapper.eq("username", username);
        UserEntity result = userMapper.selectOne(QueryWrapper);

        if (result == null) {
            throw new UsernameNotFoundException("该用户尚未注册");
        }

        String oldPassword = result.getPassword();
        String salt = result.getSalt();

        String tempPassword = getMD5Password(password, salt);

        if (!oldPassword.equals(tempPassword)) {
            throw new UserPasswordNotMatchException("用户密码错误");
        }

        String userToken = TokenUtils.genToken(result.getUid().toString(), result.getPassword());
        user.setPassword("");
        user.setToken(userToken);
        return user;
    }

    /**
     * 通过id查找用户
     * @param id 用户id
     * @return 找到的用户实体
     */
    @Override
    public UserEntity getById(Integer id) {
        // 通过用户id查找数据
        QueryWrapper<UserEntity> QueryWrapper = new QueryWrapper<>();
        QueryWrapper.eq("uid", id);
        UserEntity result = userMapper.selectOne(QueryWrapper);
        return result;
    }

    /**
     * 获取所有的用户信息
     * @return 查询结果
     */
    @Override
    public List<UserEntity> getAllUser() {
        return userMapper.selectList(null);
    }
}
