package com.punch.punch.model.retrofit.vo;

import retrofit2.http.Body;

/**
 * url : /users/{uid}/taste
 *
 */
public class UserTasteApi {

    /**
     * salty : 짠맛 선호도 (0~10000)
     * sour : 신맛 선호도 (0~10000)
     * sweet : 단맛 선호도 (0~10000)
     * bitter : 쓴맛 선호도 (0~10000)
     * spicy : 매운맛 선호도 (0~10000)
     */
    public static class GetResponseVO{
        public final int salty;
        public final int sour;
        public final int sweet;
        public final int bitter;
        public final int spicy;

        public GetResponseVO(int salty, int sour, int sweet, int bitter, int spicy) {
            this.salty = salty;
            this.sour = sour;
            this.sweet = sweet;
            this.bitter = bitter;
            this.spicy = spicy;
        }
    }

    /**
     * salty : 짠맛 선호도 (0~10000)
     * sour : 신맛 선호도 (0~10000)
     * sweet : 단맛 선호도 (0~10000)
     * bitter : 쓴맛 선호도 (0~10000)
     * spicy : 매운맛 선호도 (0~10000)
     */
    public static class PutRequestBody{
        public final int salty;
        public final int sour;
        public final int sweet;
        public final int bitter;
        public final int spicy;

        public PutRequestBody(int salty, int sour, int sweet, int bitter, int spicy) {
            this.salty = salty;
            this.sour = sour;
            this.sweet = sweet;
            this.bitter = bitter;
            this.spicy = spicy;
        }
    }
}
