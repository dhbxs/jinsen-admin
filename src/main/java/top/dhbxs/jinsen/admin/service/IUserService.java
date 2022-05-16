package top.dhbxs.jinsen.admin.service;

import top.dhbxs.jinsen.admin.entity.UserEntity;

/**
 * 用户模块业务层接口
 */
public interface IUserService {
    /**
     * 用户注册方法
     * @param user 用户实体对象
     */
    void register(UserEntity user);
}
