package com.punch.punch.model.auth;

/**
 * Created by galid on 2018-06-22.
 */

public class Authentication implements OauthAuthentication{

    private int uid;

    private Authentication(){
        uid = -1;
    }

    private static final class Singleton{
        private static final Authentication instance = new Authentication();
    }

    public static Authentication getInstance(){
        return Singleton.instance;
    }

    @Override
    public boolean signIn(String token) {
        boolean isSuccess = false;

        /**
         * 로그인 처리
         */

        if(isSuccess){

            // uid 세팅
        }else{

        }
        return isSuccess;
    }

    @Override
    public boolean signUp(String token) {
        boolean isSuccess = false;

        /**
         * 회원가입 처리
         */

        if(isSuccess){

            // uid 세팅
        }else{

        }
        return isSuccess;
    }

    @Override
    public boolean signOut() {
        boolean isSuccess = false;

        /**
         * 로그아웃 전 처리
         */

        if(isSuccess){

            uid = -1;
        }else{

        }
        return isSuccess;
    }

    @Override
    public int getUid() {
        return this.uid;
    }
}
