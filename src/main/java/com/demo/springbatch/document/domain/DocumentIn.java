package com.demo.springbatch.document.domain;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentIn {
	@NotNull(message="CPE028")
	private String numberDoc;

	@NotNull(message="CPE029")
	private String typeDocument;

}
