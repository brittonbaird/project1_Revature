package com.revature.project1.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
	private static Logger logger = LoggerFactory.getLogger(LoggerUtil.class);
	
	public static Logger getLogger(){
		return logger;
	}
}
