package com.example.woojin.management;

/**
 * Created by DBLAB on 2017-08-04.
 */

public class Member_info {
    private String userId;
    private String password;
    private String userName;
    private String userAge;

    public Member_info(){}

    public Member_info(String id, String pw, String name, String age){
        userId = id;
        password = pw;
        userName = name;
        userAge = age;
    }

    public String getUserId(){
        return userId;
    }

    public String getPassword(){
        return password;
    }

    public String getUserName(){
        return userName;
    }

    public String getUserAge(){
        return userAge;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setUserAge(String userAge){
        this.userAge = userAge;
    }
}
