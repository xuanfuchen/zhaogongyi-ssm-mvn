package com.zhaogongyi.timertask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TimerTasks {
	private DateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

	
	public void testQuart() {
		System.out.println(df.format(new java.util.Date()));
	}
}

