package com.punch.punch.model.retrofit.vo;

/**
 * url : /users/{uid}/groups/{gid}
 *
 */
public class UserGroupApi {

    /**
     * name : 그룹 이름
     * entry : 그룹 참가자들
     * gcount : 참가자 인원수
     */
    public static class GetResponseVO{
        public final String name;
        public final int[] entry;
        public final int gcount;

        public GetResponseVO(String name, int[] entry, int gcount) {
            this.name = name;
            this.entry = entry;
            this.gcount = gcount;
        }
    }

}
