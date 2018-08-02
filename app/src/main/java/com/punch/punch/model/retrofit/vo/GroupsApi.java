package com.punch.punch.model.retrofit.vo;

/**
 * url : /groups/
 *
 */
public class GroupsApi {

    /**
     * uid : 그룹 생성자 uid
     * name : 그룹 이름
     */
    public static class PostRequestBody{
        public final int uid;
        public final String name;

        public PostRequestBody(int uid, String name) {
            this.uid = uid;
            this.name = name;
        }
    }

    /**
     * gid : 생성된 그룹 id
     * groupcode : 활성화된 그룹 코드
     */
    public static class PostResponseVO{
        public final int gid;
        public final String groupcode;

        public PostResponseVO(int gid, String groupcode) {
            this.gid = gid;
            this.groupcode = groupcode;
        }
    }

}
