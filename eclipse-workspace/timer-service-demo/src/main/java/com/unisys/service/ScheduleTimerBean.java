package com.unisys.service;

import java.util.Date;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;

@LocalBean
@Singleton
@Startup
public class ScheduleTimerBean {

	private static final Logger log = Logger.getLogger("ScheduleTimerBean");

	@Schedule(second = "*/5", minute = "*", hour = "*")
	public void execute(Timer timer) {
		log.info(">>>> ScheduleTimerBean under execution...." + new Date());
	}
}
