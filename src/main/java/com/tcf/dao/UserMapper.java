package com.tcf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tcf.entity.SmbmsUser;

public interface UserMapper {
	int addSmbmsUser(SmbmsUser user);
	int updateSmbmsUser(SmbmsUser user);
	int deleteSmbmsUser(Long userId);
	SmbmsUser login(SmbmsUser user);
	SmbmsUser getUserById(Integer id);
	List<SmbmsUser> getSmbmsUsers(@Param("userName") String userName,
			@Param("userRole") Integer userRole,
			@Param("begin") int begin,
			@Param("size") int size);
	int getRows(@Param("userName") String userName,
			@Param("userRole") Integer userRole);
	int UserCodeExist(String userCode);
}
