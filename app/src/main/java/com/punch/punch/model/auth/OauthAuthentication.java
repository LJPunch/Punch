package com.punch.punch.model.auth;

/**
 * Created by galid on 2018-06-22.
 */

public interface OauthAuthentication {

    /**
     * Oauth를 통해 받아온 토큰을 이용해
     * 사용자 인증을 하고 서버로 부터 Uid를 받아오는 메소드
     * @param token Oauth를 통해 받아온 토큰
     * @return 로그인 성공 여부를 반환
     */
    boolean signIn(String token);

    /**
     * Oauth를 통해 받아온 토큰을 서버에 등록하는 메소드
     * @param token Oauth를 통해 받아온 토큰
     * @return 회원가입 성공 여부를 반환
     */
    boolean signUp(String token);

    /**
     * 로그아웃 메소드
     * @return 로그아웃 성공 여부를 반환
     */
    boolean signOut();

    /**
     * @return 토큰을 통해 서버에서 받아온 Uid를 반환
     */
    int getUid();
}
