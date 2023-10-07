package com.demo.springbatch.document.service.adapter;

import com.demo.springbatch.document.domain.DocumentOut;
import com.demo.springbatch.document.domain.DocumentPostRequest;
import com.demo.springbatch.document.repository.entity.DocumentEntity;

import java.util.List;

public interface DocumentAdapter {

    List<DocumentOut> toListDocumentOut (List<DocumentEntity>  documentEntity);

    DocumentEntity toEntityDocument(DocumentPostRequest documentInt);
}
