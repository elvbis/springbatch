package com.demo.springbatch.document.domain;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum CodeTypeDocument {

	DNI("001","DNI",8,8),
	CE("002","Carnet de Extranjería",9,11),
	PASAPORTE("003","Pasaporte",9,11);

	private final String id;
	private final String descripcion;
	private final int longitudMaxima;
	private final int longitudMinima;
	private static final Map<String, CodeTypeDocument> lookup = new HashMap<String, CodeTypeDocument>();
	
	static {
		for (CodeTypeDocument e : EnumSet.allOf(CodeTypeDocument.class)){
			lookup.put(e.getId(), e);
		}
	}

	CodeTypeDocument(String id, String descripcion, int longitudMaxima, int longitudMinima) {
		this.id = id;
		this.descripcion = descripcion;
		this.longitudMaxima = longitudMaxima;
		this.longitudMinima = longitudMinima;
	}

	public String getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public int getLongitudMaxima() {
		return longitudMaxima;
	}

	public int getLongitudMinima() {
		return longitudMinima;
	}

	public static CodeTypeDocument obtenerById(String codigo) {
		return lookup.get(codigo);
	}
	
}
