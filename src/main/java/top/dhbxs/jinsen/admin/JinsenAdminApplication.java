package top.dhbxs.jinsen.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 指定当前项目中的mapper接口路径
@MapperScan("top.dhbxs.jinsen.admin.mapper")
public class JinsenAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(JinsenAdminApplication.class, args);
    }

}
