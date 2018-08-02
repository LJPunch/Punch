package com.punch.punch.model.retrofit.vo;

/**
 * url : /users/{uid}/info/
 *
 */
public class UserInfoApi {

    /**
     * email : base64 encoded email
     */
    public static class GetResponseVO{
        public final String email;

        public GetResponseVO(String email) {
            this.email = email;
        }
    }

}
