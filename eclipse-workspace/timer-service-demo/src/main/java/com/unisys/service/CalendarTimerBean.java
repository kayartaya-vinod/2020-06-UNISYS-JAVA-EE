package com.unisys.service;

import java.util.Date;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

//@LocalBean
//@Singleton
//@Startup
public class CalendarTimerBean {

	private static final Logger log = Logger.getLogger("SchedulerTimerBean");
	
	@Resource
	TimerService ts;

	@PostConstruct
	public void setup() {
		ts.getAllTimers().stream().forEach(t -> t.cancel());

		TimerConfig tc = new TimerConfig();
		tc.setInfo("CalendarTimer demo");
		ScheduleExpression schedule = new ScheduleExpression();
		schedule.hour("*").minute("*").second("10,15,25");
		ts.createCalendarTimer(schedule, tc);
	}

	@Timeout
	public void execute() {
		log.info(">>>> CalendarTimer under execution...." + new Date());
	}
}
