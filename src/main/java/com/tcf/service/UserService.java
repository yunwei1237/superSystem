package com.tcf.service;

import java.util.List;

import com.tcf.entity.SmbmsUser;

public interface UserService {
	int addSmbmsUser(SmbmsUser user);
	int updateSmbmsUser(SmbmsUser user);
	int deleteSmbmsUser(Long userId);
	SmbmsUser login(SmbmsUser user);
	SmbmsUser getUserById(Integer id);
	List<SmbmsUser> getAllUsers();
	List<SmbmsUser> getUsers(String userName,Integer userRole,int pageIndex,int pageSize);
	int getRows(String userName,Integer userRole);
	SmbmsUser UserCodeExist(String userCode);
}
