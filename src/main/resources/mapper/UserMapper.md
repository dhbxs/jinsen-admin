```xml

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--  namespace属性：用于指定当前的映射文件和哪个接口进行映射，需要指定接口文件路径，需要标注包的完整路径接口  -->
<mapper namespace="top.dhbxs.jinsen.admin.mapper.UserMapper">
    <!--  自定义映射规则：resultmap 标签完成映射关系  -->
    <!--  id属性：标签给这个映射分配一个唯一的id值，对应的就是resultMap=“id属性的值”  -->
    <!--  type属性：取值是一个类，表示的是数据库中的查询结果与java实体类的对应关系，即映射关系-->
    <resultMap id="UserEntityMap" type="top.dhbxs.jinsen.admin.entity.UserEntity">
        <!--  在定义映射规则时，主键是不能省略的(id)  -->
        <!--  column 表的字段名 property 实体类字段  -->
        <id column="uid" property="uid"/>
        <result column="is_delete" property="isDelete"/>
        <result column="created_time" property="createdTime"/>
        <result column="modified_time" property="modifiedTime"/>
    </resultMap>

    <!--  插入用户操作  -->
    <!--  id属性：表示映射的接口中方法的名称，直接在标签的内部来编写SQL语句  -->
    <!--  useGeneratedKeys: 表示开启某个字段的值递增（主键递增）  -->
    <!--  keyProperty：表示将表中的哪个字段作为主键进行递增  -->
    <insert id="insert" useGeneratedKeys="true" keyProperty="uid">
        INSERT INTO user (username, password, salt, phone, email, gender, avatar, is_delete, created_time,
                          modified_time)
        VALUES (#{username}, #{password}, #{salt}, #{phone}, #{email}, #{gender}, #{avatar}, #{isDelete},
                #{createdTime}, #{modifiedTime})
    </insert>

    <!--  select语句在执行的过程中，查询结果是一个对象或多个对象  -->
    <!--  ResultType: 表示的是查询的结果集的类型，只需要指定对应的映射类的类型，并且包含完整的包接口：  -->
    <!--  reaultMap: 标签当表的资源和类的对象(当表字段和entity实体类的字段不完全一致时需要使用)(自定义查询结果集的映射)  -->
    <select id="findByUsername" resultMap="UserEntityMap">
        SELECT *
        FROM user
        WHERE username = #{username}
    </select>
</mapper>

```