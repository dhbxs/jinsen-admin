package top.dhbxs.jinsen.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.dhbxs.jinsen.admin.entity.UserEntity;

import java.util.List;

/**
 * 用户表持久层接口
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    List<UserEntity> findPage(Integer pageNum, Integer pageSize);

}
