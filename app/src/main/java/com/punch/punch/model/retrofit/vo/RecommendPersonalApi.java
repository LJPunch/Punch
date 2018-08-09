package com.punch.punch.model.retrofit.vo;

/**
 * url : /recommend/personal/{uid}
 *
 */
public class RecommendPersonalApi {
    /**
     * foodname : 음식 이름
     * foodpicture : 음식 사진 ( base64 encoded string )
     */
    public static class GetResponseVO{
        public final String foodname;
        public final String foodpicture;

        public GetResponseVO(String foodname, String foodpicture) {
            this.foodname = foodname;
            this.foodpicture = foodpicture;
        }
    }

}
