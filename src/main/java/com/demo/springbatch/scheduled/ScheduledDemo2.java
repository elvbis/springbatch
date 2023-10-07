package com.demo.springbatch.scheduled;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduledDemo2 {
	
	private static final Logger LOGGER = Logger.getLogger(ScheduledDemo2.class);



    
    @Scheduled(fixedRate = 10*60000)
    public void demo2(){
		LOGGER.info("Inicia [job] ");
		try {

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		LOGGER.info("Finaliza [job] ");

    }
}
