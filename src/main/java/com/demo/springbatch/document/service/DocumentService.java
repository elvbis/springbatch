package com.demo.springbatch.document.service;

import com.demo.springbatch.document.domain.DocumentOut;
import com.demo.springbatch.document.domain.DocumentPostRequest;

import java.util.List;

public interface DocumentService {
	List<DocumentOut> getAllDocuments();
	void validateDocumentNumber(String type, String document) throws Exception;

    void saveNewDocument(DocumentPostRequest documentInt) throws Exception;
}
