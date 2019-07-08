package com.jackrutorial.dao;

import java.util.List;

import com.jackrutorial.model.UserInfo;

public interface LoginDao {

 UserInfo findUserInfo(String username);
 
 List getUserRoles(String username);
}