package top.dhbxs.jinsen.admin.util;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;


public class TokenUtils {
    /**
     * 生成Token字符串工具
     * @param userId 用户id作为JWT载荷
     * @param sign 用户密码作为签名
     * @return 返回生成的Token字符串
     */
    public static String genToken (String userId, String sign) {
        String token = JWT.create().withAudience(userId) // 将userid保存到token里面，作为载荷
                .withExpiresAt(DateUtil.offsetHour(new Date(), 2)) // 2小时后token过期
                .sign(Algorithm.HMAC256(sign));// 用password作为签名sign
        return token;
    }
}
