package top.dhbxs.jinsen.admin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.dhbxs.jinsen.admin.controller.dto.UserDto;
import top.dhbxs.jinsen.admin.entity.UserEntity;
import top.dhbxs.jinsen.admin.service.ex.ServiceException;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class IUserServiceTest {

    @Autowired
    private IUserService iUserService;

    @Test
    public void register() {
        try {
            UserEntity user = new UserEntity();
            user.setUsername("admin");
            user.setPassword("123456");

            iUserService.register(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            // 先获取类的对象，再获取类的名称
            System.out.println(e.getClass().getSimpleName());
            // 获取异常的具体描述信息
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getById() {
        UserEntity user = iUserService.getById(12);
        System.out.println(user);
    }

    @Test
    public void login() {
        UserDto userDto = new UserDto();
        userDto.setUsername("sunwukong");
        userDto.setPassword("123456");
        UserDto result = iUserService.login(userDto);
        System.out.println("----" + result);
    }

    @Test
    public void getAllUser() {
        List<UserEntity> allUser = iUserService.getAllUser();
        System.out.println(allUser);
    }

    @Test
    public void updateUser() {
        UserEntity user = new UserEntity();
        user.setUid(26);
        user.setEmail("1234@qq.com");
        iUserService.updateUser(user);
    }

    @Test
    public void deleteUserById() {
        iUserService.deleteUserById(18);
    }
}