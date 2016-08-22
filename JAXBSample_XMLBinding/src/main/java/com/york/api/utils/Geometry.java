package com.york.api.utils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"location", "viewport"})
public class Geometry {
	private Location location;
	private Viewport viewport;
	
	public Geometry() {
	}
	
	public Geometry(Location location, Viewport viewport) {
		super();
		this.location = location;
		this.viewport = viewport;
	}
	
	@XmlElement
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	@XmlElement
	public Viewport getViewport() {
		return viewport;
	}
	public void setViewport(Viewport viewport) {
		this.viewport = viewport;
	}
	
}
