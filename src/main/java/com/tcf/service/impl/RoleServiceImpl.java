package com.tcf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcf.dao.RoleMapper;
import com.tcf.entity.SmbmsRole;
import com.tcf.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<SmbmsRole> getAllRoles() {
		// TODO Auto-generated method stub
		return roleMapper.getRoles();
	}
}
