package com.tcf.util;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import com.tcf.entity.SmbmsRole;

@XmlRootElement(name="listBean")
public class ListXmlBean {
	
	private List list;

	public ListXmlBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListXmlBean(List list) {
		super();
		this.list = list;
	}
	@XmlElements({@XmlElement(name="SmbmsRole",type=SmbmsRole.class)})
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
}
