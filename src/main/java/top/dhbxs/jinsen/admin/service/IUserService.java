package top.dhbxs.jinsen.admin.service;

import top.dhbxs.jinsen.admin.controller.dto.UserDto;
import top.dhbxs.jinsen.admin.entity.UserEntity;

/**
 * 用户模块业务层接口
 */
public interface IUserService {
    /**
     * 用户注册接口
     * @param user 用户实体对象
     */
    void register(UserEntity user);

    /**
     * 用户登录接口
     * @param user 用户实体对象
     * @return token
     */
    String login(UserDto user);
}
