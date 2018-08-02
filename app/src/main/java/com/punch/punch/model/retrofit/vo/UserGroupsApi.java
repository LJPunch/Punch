package com.punch.punch.model.retrofit.vo;

/**
 * url : /users/{uid}/groups
 *
 */
public class UserGroupsApi {

    /**
     * gid : 유저가 참가한 group id 들
     */
    public static class GetResponseVO{
        public final int[] gid;

        public GetResponseVO(int[] gid) {
            this.gid = gid;
        }
    }

    /**
     * groupcode : 활성화 되있는 그룹코드
     */
    public static class PostRequestBody{
        public final String groupcode;

        public PostRequestBody(String groupcode) {
            this.groupcode = groupcode;
        }
    }

    /**
     * gid : 참가한 그룹 id
     */
    public static class PostResponseVO{
        public final int gid;

        public PostResponseVO(int gid) {
            this.gid = gid;
        }
    }
}
