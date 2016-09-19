package com.vasu.fairshare.account.dao;

import com.vasu.fairshare.account.model.User;

public interface UserDAO {
	
	User findByUserName(String userName);
}
