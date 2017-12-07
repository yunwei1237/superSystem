package com.tcf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcf.service.RoleService;

@Scope("prototype")
@Controller
public class RoleController {
	@Autowired
	private RoleService rs;
	
	/*@ResponseBody
	@RequestMapping(value="getrolelist")
	public Object getrolelist(){
		return JSONArray.toJSONString(rs.getAllRoles());
	}*/
	/*@RequestMapping(value="getrolelist")
	public Object getrolelist(ModelMap model){
		return new ListXmlBean(rs.getAllRoles());
	}*/
	@RequestMapping(value="getrolelist")
	public Object getrolelist(ModelMap model){
		model.addAttribute("list",rs.getAllRoles());
		return "getrolelist";
	}
	@RequestMapping(value="getrole")
	public Object getrole(ModelMap model){
		return rs.getAllRoles().get(0);
	}
}
