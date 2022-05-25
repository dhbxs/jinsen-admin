package top.dhbxs.jinsen.admin.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.dhbxs.jinsen.admin.entity.UserEntity;

// 表示当前是一个测试类，不会随项目一起打包
@SpringBootTest
// 需要手动导包 表示启动这个单元测试类（如果没有，单元测试类是不能运行的），需要传递一个参数，必须是SoringRunner.class类型
@RunWith(SpringRunner.class)
public class UserMapperTest {
    // idea有检测的功能，接口是不能够直接创建Bean对象的（但运行不会报错，原因是动态代理）
    @Autowired
    private UserMapper userMapper;

    /**
     * 单元测试方法：有了单元测试就可以独立运行，不用启动整个项目，可以做单元测试，提升了代码的测试效率
     * 1. 必须被Test注解所修饰
     * 2. 返回值类型必须是void
     * 3. 方法的参数列表不能指定任何类型
     * 4. 方法的返回值和方法的访问修饰符必须是public
     */
    @Test
    public void insert() {
        UserEntity user = new UserEntity();
        user.setUsername("tim");
        user.setPassword("123");

        Integer rows = userMapper.insert(user);

        System.out.println(rows);
    }

//    @Test
//    public void findByUsername() {
//        UserEntity user = userMapper.findByUsername("sunwukong1");
//        System.out.println(user);
//    }
}