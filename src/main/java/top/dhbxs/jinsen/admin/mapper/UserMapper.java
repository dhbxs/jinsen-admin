package top.dhbxs.jinsen.admin.mapper;

import top.dhbxs.jinsen.admin.entity.UserEntity;

/**
 * 用户模块的持久层接口
 */
public interface UserMapper {
    /**
     * 插入用户的数据
     *
     * @param user
     * @return 受影响的行数(Integer)
     */
    Integer insert(UserEntity user);

    /**
     * 根据用户名查询用户数据
     *
     * @param username
     * @return 如果存在返回用户数据，如果不存在则返回null
     */
    UserEntity findByUsername(String username);
}
