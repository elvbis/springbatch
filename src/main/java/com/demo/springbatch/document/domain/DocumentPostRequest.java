package com.demo.springbatch.document.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentPostRequest {
	@NotNull(message="CPE071")
	@NotEmpty(message="CPE071")
	private String description;


}
