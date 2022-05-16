package top.dhbxs.jinsen.admin.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenUtilsTest {

    @Test
    void genToken() {
        String tring = TokenUtils.genToken("111", "222");
        System.out.println(tring);
    }
}