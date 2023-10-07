package com.demo.springbatch.scheduled;

import com.demo.springbatch.document.domain.DocumentOut;
import com.demo.springbatch.document.service.DocumentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ScheduledDemo1 {
	
	private static final Logger LOGGER = Logger.getLogger(ScheduledDemo1.class);
	@Autowired
	private DocumentService documentService;


	/**
	 * 1 minutos
	 */
	@Scheduled(fixedRate = 1*60000)
    public void demo1() {
		LOGGER.info("Inicia [job] ");
		try {
			List<DocumentOut> result = documentService.getAllDocuments();

			for (DocumentOut document: result) {
				LOGGER.info("codigo : "+document.getId()+"- Description : "+document.getDescription());
			}
		} catch (Exception e) {
			LOGGER.error("Problemas ", e);
		}
        
        
		LOGGER.info("Finaliza ");

    }
}
