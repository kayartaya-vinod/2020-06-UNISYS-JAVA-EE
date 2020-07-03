package com.unisys.service;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

//@LocalBean
//@Singleton
//@Startup
public class FixedIntervalLogger {

	@Resource
	private TimerService timerService;

	public FixedIntervalLogger() {
		// at this time, no dependencies have been injected;
		// this.timerService is null
	}

	@PostConstruct
	public void init() {
		// this.timerService is not null, but points an object of some class that
		// implements TimerServer interface
		// this.timerService.createTimer(15000, 5000, "This is a sample timer service");
		TimerConfig cfg = new TimerConfig();
		cfg.setInfo("Trying to cancel all running timers...");
		this.timerService.createSingleActionTimer(0, cfg);
		
		var timers = this.timerService.getAllTimers();
		for(var t: timers) {
			System.out.println("Found this timer : " + t.getInfo());
		}
	}
	
	@Timeout
	public void cancelTimers(Timer timer) {
		System.out.println("Cancelling the timer with info: " + timer.getInfo());
		timer.cancel();
	}

	// @Timeout
	public void execute(Timer timer) {
		System.out.println("[FixedIntervalLogger] execute() called at " + new Date());
		System.out.println("TimerService info = " + timer.getInfo());
		System.out.println("Next timeout      = " + timer.getNextTimeout());
		System.out.println("Time remaining    = " + timer.getTimeRemaining() + " ms");
	}

}
