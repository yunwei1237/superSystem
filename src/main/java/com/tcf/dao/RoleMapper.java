package com.tcf.dao;

import java.util.List;

import com.tcf.entity.SmbmsRole;

public interface RoleMapper {
	int addSmbmsRole(SmbmsRole user);
	int updateSmbmsRole(SmbmsRole user);
	int deleteSmbmsRole(Long roleId);
	List<SmbmsRole> getRoles();
}
