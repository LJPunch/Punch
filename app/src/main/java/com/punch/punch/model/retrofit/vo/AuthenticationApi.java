package com.punch.punch.model.retrofit.vo;

/**
 * url : /authentication/{identifier}
 * identifier{
 *     GET : email
 *     DELETE : uid
 * }
 */
public class AuthenticationApi {

    /**
     * uid : 서버에 등록된 유저 ID
     * expiredtime : uid 만료 시간 (second)
     */
    public static class GetResponseVO{
        public final int uid;
        public final int expiredtime;

        public GetResponseVO(int uid, int expiredtime) {
            this.uid = uid;
            this.expiredtime = expiredtime;
        }
    }

}
