package com.tcf.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcf.dao.UserMapper;
import com.tcf.entity.SmbmsUser;
import com.tcf.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper um;
	
	@Override
	public int addSmbmsUser(SmbmsUser user) {
		// TODO Auto-generated method stub
		return um.addSmbmsUser(user);
	}

	@Override
	public int updateSmbmsUser(SmbmsUser user) {
		// TODO Auto-generated method stub
		return um.updateSmbmsUser(user);
	}

	@Override
	public int deleteSmbmsUser(Long userId) {
		// TODO Auto-generated method stub
		return um.deleteSmbmsUser(userId);
	}
	
	@Override
	public SmbmsUser login(SmbmsUser user) {
		// TODO Auto-generated method stub
		return um.login(user);
	}

	@Override
	public List<SmbmsUser> getAllUsers() {
		// TODO Auto-generated method stub
		return um.getSmbmsUsers(null,null,0,-1);
	}

	@Override
	public List<SmbmsUser> getUsers(String userName,Integer userRole,int pageIndex,int pageSize) {
		// TODO Auto-generated method stub
		return um.getSmbmsUsers(userName,userRole,(pageIndex-1)*pageSize,pageSize);
	}

	@Override
	public int getRows(String userName,Integer userRole) {
		// TODO Auto-generated method stub
		return um.getRows(userName,userRole);
	}

	@Override
	public SmbmsUser UserCodeExist(String userCode) {
		// TODO Auto-generated method stub
		int rows = um.UserCodeExist(userCode);
		return new SmbmsUser(rows>0?"exist":"no");
	}

	@Override
	public SmbmsUser getUserById(Integer id) {
		// TODO Auto-generated method stub
		return um.getUserById(id);
	}

}
