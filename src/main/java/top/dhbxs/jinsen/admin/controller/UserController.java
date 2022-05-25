package top.dhbxs.jinsen.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dhbxs.jinsen.admin.controller.dto.UserDto;
import top.dhbxs.jinsen.admin.entity.UserEntity;
import top.dhbxs.jinsen.admin.service.IUserService;
import top.dhbxs.jinsen.admin.util.JsonResult;

import java.util.List;

@RestController // 组合注解， 相当于@Controller + @ResponseBody
@RequestMapping("/users")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    /**
     * url POST: /users
     * Post请求用来注册用户
     *
     * @param user 用户实体对象
     * @return 返回Json对象
     */
    @PostMapping
    public JsonResult<Object> register(@RequestBody UserEntity user) {
        userService.register(user);
        return new JsonResult<Object>(OK);
    }

    /**
     * url GET: /users
     * Get请求用来登录
     *
     * @param userDto 用户简化实体对象
     * @return 返回Json对象
     */
    @GetMapping
    public JsonResult<UserDto> login(UserDto userDto) {
        UserDto user = userService.login(userDto);
        return new JsonResult<UserDto>(OK, user);
    }

    /**
     * url GET : /users/getAll
     * Get请求所有用户信息
     * @return 返回封装好的Json对象
     */
    @GetMapping("/getAll")
    public JsonResult<List<UserEntity>> getAllUser() {
        List<UserEntity> user = userService.getAllUser();
        return new JsonResult<List<UserEntity>>(OK, user);
    }
}
