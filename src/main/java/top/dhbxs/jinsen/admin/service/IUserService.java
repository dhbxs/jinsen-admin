package top.dhbxs.jinsen.admin.service;

import top.dhbxs.jinsen.admin.controller.dto.UserDto;
import top.dhbxs.jinsen.admin.entity.UserEntity;

import java.util.List;

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
    UserDto login(UserDto user);

    /**
     * 通过用户id查找用户
     * @param id 用户id
     * @return 用户实体
     */
    UserEntity getById(Integer id);

    /**
     * 获取所有的用户信息
     * @return 查询结果
     */
    List<UserEntity> getAllUser();
}
