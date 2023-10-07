package com.demo.springbatch.document.web;

import com.demo.springbatch.document.domain.DocumentOut;
import com.demo.springbatch.document.domain.DocumentPostRequest;
import com.demo.springbatch.document.service.DocumentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/document")
@RequiredArgsConstructor
public class DocumentResources  {

	private static final Logger LOGGER = Logger.getLogger(DocumentResources.class);

	private final DocumentService documentService;

	@GetMapping
	public ResponseEntity<List<DocumentOut>> list(@RequestHeader("channelCode") String channelCode,
												  HttpServletRequest request){
		LOGGER.info("Inicia [listTipoDocumento]");
		LOGGER.info("Header channelCode ["+channelCode+"]");
		try {
			List<DocumentOut> respuesta = documentService.getAllDocuments();

			

			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		}catch(Exception e) {

		}finally {
			LOGGER.info("Termina [listTipoDocumento]");
		}

		return null;
	}

	@PostMapping
	public ResponseEntity<DocumentPostRequest>  saveNewDocument(@Valid @RequestBody DocumentPostRequest documentInt,
																Errors errors, HttpServletRequest request){
		LOGGER.info("Inicia [saveNewDocument]");
		try {
			documentService.saveNewDocument(documentInt);
		}catch(Exception e) {
		}finally {
			LOGGER.info("Termina [saveNewDocument]");
		}
		return new ResponseEntity<>(documentInt, HttpStatus.OK);
	}
}
