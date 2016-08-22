package com.york.api.utils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"lat", "lng"})
public class Location {
	private double lat;
	private double lng;

	public Location() {
		this.lat = 0;
		this.lng = 0;		
	}
	
	public Location(double lat, double lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}
	
	@XmlElement
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	@XmlElement
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}	
	
}
