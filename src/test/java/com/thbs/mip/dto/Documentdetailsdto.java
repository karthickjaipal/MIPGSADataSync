package com.thbs.mip.dto;

import java.util.List;

public class Documentdetailsdto {
	Integer documentTypeId;
	String documentValue;
	
	public Integer getDocumentTypeId() {
		return documentTypeId;
	}
	
	public void setDocumentTypeId(Integer documentTypeId) {
		this.documentTypeId = documentTypeId;
	}
	public String getDocumentValue() {
		return documentValue;
	}
	public void setDocumentValue(String documentValue) {
		this.documentValue = documentValue;
	}
	
	@Override
	public String toString() {
		return "Documentdetailsdto [documentTypeId=" + documentTypeId + ", documentValue=" + documentValue + "]";
	}
	
	
	
	
	
}
