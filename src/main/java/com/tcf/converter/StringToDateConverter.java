package com.tcf.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String,Date> {
	private SimpleDateFormat sdf;
	public StringToDateConverter(String format) {
		sdf = new SimpleDateFormat(format);
	}

	@Override
	public Date convert(String str) {
		// TODO Auto-generated method stub
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
