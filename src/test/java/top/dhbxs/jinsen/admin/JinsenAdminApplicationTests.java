package top.dhbxs.jinsen.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class JinsenAdminApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    // 数据库连接测试类
    void contextLoads() throws Exception{
        System.out.println("获取的数据库链接为：" + dataSource.getConnection());
    }

}
