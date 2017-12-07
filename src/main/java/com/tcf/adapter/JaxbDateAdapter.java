package com.tcf.adapter;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class JaxbDateAdapter extends XmlAdapter<String, Timestamp> {

	static final String STANDARM_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	@Override
	public Timestamp unmarshal(String v) throws Exception {
		if (v == null) {
			return null;
		}

		DateFormat format = new SimpleDateFormat(STANDARM_DATE_FORMAT);
		return new Timestamp(format.parse(v).getTime());
	}

	@Override
	public String marshal(Timestamp v) throws Exception {
		DateFormat format = new SimpleDateFormat(STANDARM_DATE_FORMAT);
		return format.format(v);
	}
}
