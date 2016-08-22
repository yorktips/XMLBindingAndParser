package com.york.api.utils;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement( name = "PlaceSearchResponse" )
@XmlType(propOrder={"status", "result", "nextPageToken"})
public class PlaceSearchResponse {
	private String status;
	private List<Result> result;
	private String nextPageToken;

	public PlaceSearchResponse() {
		super();
	}	
	
	public PlaceSearchResponse(String status, List<Result> result,
			String nextPageToken) {
		super();
		this.status = status;
		this.result = result;
		this.nextPageToken = nextPageToken;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<Result> getResult() {
		return this.result;
	}

	public void setResult(List<Result> result) {
		this.result = result;
	}
	
	@XmlElement( name = "next_page_token" )
	public String getNextPageToken() {
		return nextPageToken;
	}
	public void setNextPageToken(String nextPageToken) {
		this.nextPageToken = nextPageToken;
	}	
	
}
