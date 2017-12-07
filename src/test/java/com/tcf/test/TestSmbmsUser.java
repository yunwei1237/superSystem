package com.tcf.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;

import com.tcf.util.MyUtil;

public class TestSmbmsUser {
	private SqlSession session;
	@Before
	public void before(){
		session = MyUtil.getSession();
	}
	/*@Test
	public void testGetAllSmbmsUsers(){
		//List<SmbmsUser> smbmsUsers = session.selectList("com.tcf.dao.SmbmsUserDao.getAllSmbmsUsers");
		SmbmsUserDao dao = session.getMapper(SmbmsUserDao.class);
		List<SmbmsUser> smbmsUsers = dao.getAllSmbmsUsers();
		System.out.println(smbmsUsers.get(0));
		System.out.println(smbmsUsers.get(0).getAddresses());
		Assert.assertEquals(true, smbmsUsers.size()>0);
	}*/
	/*@Test
	public void testGetAllSmbmsUsers2(){
		//List<SmbmsUser> smbmsUsers = session.selectList("com.tcf.dao.SmbmsUserDao.getAllSmbmsUsers");
		SmbmsUserDao dao = session.getMapper(SmbmsUserDao.class);
		List<SmbmsUser> smbmsUsers = dao.getAllSmbmsUsers2(1,10);
		System.out.println(smbmsUsers.size());
		Assert.assertEquals(true, smbmsUsers.size()>0);
	}*/
	/*@Test
	public void testGetAllSmbmsUsersByBean(){
		//List<SmbmsUser> smbmsUsers = session.selectList("com.tcf.dao.SmbmsUserDao.getAllSmbmsUsers");
		SmbmsUserDao dao = session.getMapper(SmbmsUserDao.class);
		SmbmsUser user = new SmbmsUser();
		user.setId(1L);
		user.setUserCode("a");
		List<SmbmsUser> smbmsUsers = dao.getAllSmbmsUsersByBean(user);
		System.out.println(smbmsUsers.size());
		Assert.assertEquals(true, smbmsUsers.size()>0);
	}*/
	/*@Test
	public void testGetAllSmbmsUsersByBean(){
		//List<SmbmsUser> smbmsUsers = session.selectList("com.tcf.dao.SmbmsUserDao.getAllSmbmsUsers");
		SmbmsUserDao dao = session.getMapper(SmbmsUserDao.class);
		SmbmsUser user = new SmbmsUser();
		//user.setUserName("��");
		//user.setUserCode("a");
		user.setCreationDate(new Timestamp(System.currentTimeMillis()));
		List<SmbmsUser> smbmsUsers = dao.getAllSmbmsUsersByBean2(user);
		System.out.println(smbmsUsers.size());
		Assert.assertEquals(true, smbmsUsers.size()>0);
	}*/
	/*@Test
	public void testAddSmbmsUser(){
		//List<SmbmsUser> smbmsUsers = session.selectList("com.tcf.dao.SmbmsUserDao.getAllSmbmsUsers");
		SmbmsUserDao dao = session.getMapper(SmbmsUserDao.class);
		SmbmsUser user = new SmbmsUser("archer", "����", "wan", 1, new Date() , "135����", "�㶫ʡ������", 1, 1L, new Timestamp(System.currentTimeMillis()), 1L, new Timestamp(System.currentTimeMillis()));
		int result = dao.addSmbmsUser(user);
		session.commit();
		System.out.println(result);
		Assert.assertEquals(1, result);
	}*/
	/*@Test
	public void testUpdateSmbmsUser(){
		//List<SmbmsUser> smbmsUsers = session.selectList("com.tcf.dao.SmbmsUserDao.getAllSmbmsUsers");
		SmbmsUserDao dao = session.getMapper(SmbmsUserDao.class);
		SmbmsUser user = new SmbmsUser();
		user.setId(16L);
		user.setPhone("13537795777");
		int result = dao.updateSmbmsUser(user);
		session.commit();
		System.out.println(result);
		Assert.assertEquals(1, result);
	}*/
	/*@Test
	public void testGetAllSmbmsUsersByRoles(){
		//List<SmbmsUser> smbmsUsers = session.selectList("com.tcf.dao.SmbmsUserDao.getAllSmbmsUsers");
		SmbmsUserDao dao = session.getMapper(SmbmsUserDao.class);
		List<SmbmsUser> smbmsUsers = dao.getAllSmbmsUsersByRoles(new Integer[]{1,2,3});
		System.out.println(smbmsUsers.size());
		Assert.assertEquals(true, smbmsUsers.size()>0);
	}*/
	/*@Test
	public void testGetAllSmbmsUsersByRoles2(){
		//List<SmbmsUser> smbmsUsers = session.selectList("com.tcf.dao.SmbmsUserDao.getAllSmbmsUsers");
		SmbmsUserDao dao = session.getMapper(SmbmsUserDao.class);
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		List<SmbmsUser> smbmsUsers = dao.getAllSmbmsUsersByRoles2(list);
		System.out.println(smbmsUsers.size());
		Assert.assertEquals(true, smbmsUsers.size()>0);
	}*/
	/*@Test
	public void testGetAllSmbmsUsersByRoles2(){
		//List<SmbmsUser> smbmsUsers = session.selectList("com.tcf.dao.SmbmsUserDao.getAllSmbmsUsers");
		SmbmsUserDao dao = session.getMapper(SmbmsUserDao.class);
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roles", list);
		List<SmbmsUser> smbmsUsers = dao.getAllSmbmsUsersByRoles3(map);
		System.out.println(smbmsUsers.size());
		Assert.assertEquals(true, smbmsUsers.size()>0);
	}*/
/*	@Test
	public void testGetSmbmsUserById(){
		SmbmsUserDao dao = session.getMapper(SmbmsUserDao.class);
		SmbmsUser smbmsUser = dao.getSmbmsUserById(new Long(1));
		System.out.println(smbmsUser);
		Assert.assertEquals(new Long(1), smbmsUser.getId());
	}
	@Test
	public void testLogin(){
		SmbmsUserDao dao = session.getMapper(SmbmsUserDao.class);
		SmbmsUser smbmsUser = dao.login(new Long(1), "1234567");
		System.out.println(smbmsUser);
		Assert.assertEquals(new Long(1), smbmsUser.getId());
	}
	
	@Test
	public void testChangePwd(){
		SmbmsUserDao dao = session.getMapper(SmbmsUserDao.class);
		int result = dao.changePwd(new Long(1), "1234567","1234567");
		System.out.println(result);
		Assert.assertEquals(1, result);
	}*/
	@After
	public void after(){
		MyUtil.closeSession(session);
	}
}
