package com.demo.springbatch.document.service.impl;

import com.demo.springbatch.common.NumberUtil;
import com.demo.springbatch.document.domain.DocumentOut;
import com.demo.springbatch.document.domain.DocumentPostRequest;
import com.demo.springbatch.document.repository.DocumentRepository;
import com.demo.springbatch.document.repository.entity.DocumentEntity;
import com.demo.springbatch.document.service.DocumentService;
import com.demo.springbatch.document.service.adapter.DocumentAdapter;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

	private static final Logger LOGGER = Logger.getLogger(DocumentServiceImpl.class);

	private final DocumentRepository documentRepository;
	private final DocumentAdapter documentAdapter;
	/**
	 *
	 * @param type
	 * @param document
	 * @throws Exception
	 */
	@Override
	public void validateDocumentNumber(String type, String document) throws Exception{
		LOGGER.info("Documento validado");
	}

	@Override
	public void saveNewDocument(DocumentPostRequest documentInt) throws Exception {
		long cant = documentRepository.count();
		String keyTable = NumberUtil.fullLefthZero(String.valueOf(cant+1),3);
		DocumentEntity entity = documentAdapter.toEntityDocument(documentInt);
		entity.setTipoDocumento(keyTable);
		documentRepository.save(entity);
	}

	@Override
	public List<DocumentOut> getAllDocuments() {
		List<DocumentOut> listReturn = new ArrayList<>();
		List<DocumentEntity> list = documentRepository.findAll();

		return documentAdapter.toListDocumentOut(list);
	}
}
