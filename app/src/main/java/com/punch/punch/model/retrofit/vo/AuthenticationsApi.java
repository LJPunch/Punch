package com.punch.punch.model.retrofit.vo;

/**
 * url : /authentication/
 */
public class AuthenticationsApi {

    /**
     * email : base64 encoded email
     */
    public static class PostRequestBody{
        public final String email;

        public PostRequestBody(String email) {
            this.email = email;
        }
    }

    /**
     * uid : 서버에 등록된 유저 ID
     * expiredtime : uid 만료 시간 (second)
     */
    public static class PostResponseVO{
        public final int uid;
        public final int expiredtime;

        public PostResponseVO(int uid, int expiredtime) {
            this.uid = uid;
            this.expiredtime = expiredtime;
        }
    }
}
