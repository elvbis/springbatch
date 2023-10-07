package com.demo.springbatch.document.repository;

import com.demo.springbatch.document.repository.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<DocumentEntity, String>{

}
