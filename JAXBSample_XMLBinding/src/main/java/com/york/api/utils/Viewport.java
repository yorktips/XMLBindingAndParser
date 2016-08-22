package com.york.api.utils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"southwest", "northeast"})
public class Viewport {
	private Location southwest;
	private Location northeast;

	public Viewport() {
	}
	
	public Viewport(Location southwest, Location northeast) {
		super();
		this.southwest = southwest;
		this.northeast = northeast;
	}
	
	@XmlElement
	public Location getSouthwest() {
		return southwest;
	}
	public void setSouthwest(Location southwest) {
		this.southwest = southwest;
	}
	
	@XmlElement
	public Location getNortheast() {
		return northeast;
	}
	public void setNortheast(Location northeast) {
		this.northeast = northeast;
	}
	
}
