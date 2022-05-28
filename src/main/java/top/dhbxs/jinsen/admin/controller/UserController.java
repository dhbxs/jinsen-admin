package top.dhbxs.jinsen.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dhbxs.jinsen.admin.controller.dto.UserDto;
import top.dhbxs.jinsen.admin.entity.UserEntity;
import top.dhbxs.jinsen.admin.mapper.UserMapper;
import top.dhbxs.jinsen.admin.service.IUserService;
import top.dhbxs.jinsen.admin.util.JsonResult;

import java.util.List;

/**
 * 用户相关控制层类
 */
@RestController // 组合注解， 相当于@Controller + @ResponseBody
@RequestMapping("/users")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

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
     * url GET: /users/getAll
     * Get请求所有用户信息
     * @return 返回封装好的Json对象
     */
    @GetMapping("/getAll")
    public JsonResult<List<UserEntity>> getAllUser() {
        List<UserEntity> user = userService.getAllUser();
        return new JsonResult<List<UserEntity>>(OK, user);
    }

    /**
     * 后去用户信息的分页查询
     * ?pageNum=1$pageSize=10
     * @return
     */
    @GetMapping("/page")
    public JsonResult<List<UserEntity>> getUserInfo(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<UserEntity> userNow = userMapper.findPage(pageNum, pageSize);
//        System.out.println("99d9d9sa9sa9fsafsaf"+ userNow);
        return new JsonResult<List<UserEntity>>(OK, userNow);
    }

    /**
     * url POST: /users/update
     * @param user 用户实体对象
     * @return 返回状态码
     */
    @PostMapping("/update")
    public JsonResult<Void> updateUser(@RequestBody UserEntity user) {
        userService.updateUser(user);
        return new JsonResult<Void>(OK);
    }

    /**
     * url GET: /users/delete
     * @param uid 用户id
     * @return 返回状态码
     */
    @GetMapping("/delete")
    public JsonResult<Void> deleteUser(Integer uid) {
        userService.deleteUserById(uid);
        return new JsonResult<Void>(OK);
    }
}
