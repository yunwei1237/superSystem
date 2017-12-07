package com.tcf.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.tcf.entity.SmbmsUser;
import com.tcf.service.RoleService;
import com.tcf.service.UserService;

@SessionAttributes("roles")
@Scope("prototype")
@Controller
public class UserController {
	@Autowired
	private UserService us;
	@Autowired
	private RoleService rs;
	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		System.out.println("initBinder:222222222222222222=================================");
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	@RequestMapping(value="/login.do")
	public String login(SmbmsUser user,HttpSession session){
		SmbmsUser logined = us.login(user);
		if(logined != null){
			session.setAttribute("user", logined);
		}
		return "redirect:user.do";
	}
	private int pageSize = 3;
	@RequestMapping("user.do")
	public String userList(String queryname,Integer queryUserRole,@RequestParam(defaultValue="1") Integer pageIndex, Model model){
		queryname = queryname != null && queryname.trim().length() == 0?null:queryname;
		queryUserRole = queryUserRole != null && queryUserRole == 0?null:queryUserRole;
		
		model.addAttribute("roleList", rs.getAllRoles());
		model.addAttribute("userList", us.getUsers(queryname,queryUserRole,pageIndex,pageSize));
		int rows = us.getRows(queryname,queryUserRole);
		model.addAttribute("totalCount", rows);
		model.addAttribute("currentPageNo", pageIndex);
		model.addAttribute("totalPageCount", rows%pageSize==0?rows/pageSize:rows/pageSize+1);
		
		model.addAttribute("queryUserRole", queryUserRole);
		model.addAttribute("queryname", queryname);
		return "userlist";
	}
	
	
	/*@RequestMapping("add.do")
	public String add(@ModelAttribute("user") SmbmsUser user,Model model){
		HashMap<Integer, String> roles = new HashMap<Integer, String>();
		roles.put(1, "管理员");
		roles.put(2, "经理");
		roles.put(3, "员工");
		model.addAttribute("roles", roles);
		System.out.println("aaaaaa222222222222222222222222");
		return "add";
	}*/
	/*@RequestMapping("add.do")
	public String add(@ModelAttribute("user") SmbmsUser user,@ModelAttribute("roles") HashMap<Integer, String> roles,HttpSession session){
		roles.put(1, "管理员");
		roles.put(2, "经理");
		roles.put(3, "员工");
		session.setAttribute("roles", roles);
		System.out.println("aaaaaa444444444444444444444");
		return "add";
	}*/
	@RequestMapping("add.do")
	public String add(@ModelAttribute("user") SmbmsUser user,Model model){
		HashMap<Integer, String> roles = new HashMap<Integer, String>();
		roles.put(1, "管理员");
		roles.put(2, "经理");
		roles.put(3, "员工");
		model.addAttribute("roles", roles);
		System.out.println("aaaaaa6666666666666666666666");
		return "add";
	}
	@RequestMapping("userSave.do")
	public String userAdd(@ModelAttribute("user") @Valid SmbmsUser user,BindingResult bindingResult){
		System.out.println(user);
		System.out.println("bbbbbbbbbbbbbb44444444444444444");
		return "add";
	}
	
	
	@RequestMapping("userAdd.do")
	public String userAdd(){
		return "useradd";
	}
	
	@RequestMapping("userAddSave.do")
	public String userAddSave(SmbmsUser user,HttpSession session){
		SmbmsUser logined = (SmbmsUser) session.getAttribute("user");
		user.setCreatedBy(logined.getId());
		user.setCreationDate(new Timestamp(System.currentTimeMillis()));
		if(us.addSmbmsUser(user)>0){
			return "redirect:user.do";
		}
		return "redirect:userAdd.do";
	}
	
	@ResponseBody
	@RequestMapping("ucexist.do")
	public String ucexist(String userCode){
		return JSONObject.toJSONString(us.UserCodeExist(userCode)); 
	}
	
	
	//修改
	/*@RequestMapping("getUserById.do")*/
	@RequestMapping("modifyUser/{id}")
	public String getUserById(@PathVariable Integer id,Model model){
		model.addAttribute("user", us.getUserById(id));
		return "usermodify";
	}
	@RequestMapping("viewUser/{id}")
	public String viewUser(@PathVariable("id") Integer id,Model model){
		model.addAttribute("user", us.getUserById(id));
		return "userview";
	}
	/*@ResponseBody
	@RequestMapping("viewUser/json/{id}")
	public String viewJsonUser(@PathVariable("id") Integer id){
		return JSONObject.toJSONString(us.getUserById(id));
	}*/
	@ResponseBody
	@RequestMapping("viewUser/json/{id}")
	public Object viewJsonUser(@PathVariable("id") Integer id){
		return us.getUserById(id);
	}
	@RequestMapping("updateUser.do")
	public String updateUser(@ModelAttribute("user") SmbmsUser user,HttpSession session){
		SmbmsUser logined = (SmbmsUser) session.getAttribute("user");
		user.setModifyBy(logined.getId());
		user.setModifyDate(new Timestamp(System.currentTimeMillis()));
		if(us.updateSmbmsUser(user)>0){
			return "redirect:user.do";
		}
		return "usermodify";
	}
	@RequestMapping("upload.do")
	public String upload(@RequestParam("file") MultipartFile file,Model model,HttpSession session,HttpServletRequest request){
		String err = canUpload(file);
		if(err != null){
			model.addAttribute("errors", err);
			return "upload";
		}
		String path = session.getServletContext().getRealPath("uploads");
		String info = uploadFile(file,path);
		session.setAttribute("infos", info);
		return "uploadSuccess";
	}
	
	@RequestMapping("uploads.do")
	public String uploads(@RequestParam("files") MultipartFile[] files,Model model,HttpSession session,HttpServletRequest request){
		List<String> errors = new ArrayList<String>();
		List<String> infos = new ArrayList<String>();
		String path = session.getServletContext().getRealPath("uploads");
		for(MultipartFile file:files){
			//检测是否可以上传
			String err = canUpload(file);
			if(err != null){
				errors.add(err);
			}else{//上传文件
				String info = uploadFile(file,path);
				infos.add(info);
			}
		}
		model.addAttribute("errors", errors);
		session.setAttribute("infos", infos);
		if(infos.size()==0){
			return "upload";
		}
		return "uploadSuccess";
	}
	
	public String uploadFile(MultipartFile file,String path){
		String filename = file.getOriginalFilename();
		File targetFile = new File(path+File.separator+filename);
		try {
			file.transferTo(targetFile);
			return  String.format("%s:上传文件成功", filename);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String canUpload(MultipartFile file){
		List<String> formats = new ArrayList<String>();
		formats.add("jpg");
		formats.add("png");
		formats.add("jpeg");
		formats.add("pneg");
		formats.add("bmp");
		formats.add("bmp");
		String filename = file.getOriginalFilename();
		String subfix = FilenameUtils.getExtension(filename);
		if(file.isEmpty()){
			return String.format("%s:上传文件为空", filename);
		}else{
			if(file.getSize()>500000){
				return String.format("%s:上传文件大小不得超过500KB", filename);
			}else if(!formats.contains(subfix.toLowerCase())){
				return String.format("%s:上传图片格式不正确", filename);
			}
		}
		return null;
	}
}
