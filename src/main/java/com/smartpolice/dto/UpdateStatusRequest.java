package com.smartpolice.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.smartpolice.constants.CaseStatus;

public class UpdateStatusRequest {
    private String caseId;
    @JsonProperty
    private CaseStatus status;
    
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public CaseStatus getStatus() {
		return status;
	}
	public void setStatus(CaseStatus status) {
		this.status = status;
	}
	public UpdateStatusRequest(String caseId, CaseStatus status) {
		super();
		this.caseId = caseId;
		this.status = status;
	}
	public UpdateStatusRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
    
}
