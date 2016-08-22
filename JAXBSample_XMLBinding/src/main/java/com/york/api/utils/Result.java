package com.york.api.utils;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"name", "vicinity", "type","geometry","icon","reference","id","photo","placeId","scope"})
public class Result {
	private String name;
	private String vicinity;
	private List<String> type;
	private Geometry geometry;
	private String icon;
	private String reference;
	private String id;
	private Photo photo;
	private String placeId;
	private String scope;
	
	public Result() {
		super();
	}
	
	public Result(String name, String vicinity, List<String> type,
			Geometry geometry, String icon, String reference, String id,
			Photo photo, String place_id, String scope) {
		super();
		this.name = name;
		this.vicinity = vicinity;
		this.type = type;
		this.geometry = geometry;
		this.icon = icon;
		this.reference = reference;
		this.id = id;
		this.photo = photo;
		this.placeId = placeId;
		this.scope = scope;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public String getVicinity() {
		return vicinity;
	}
	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}
	
	@XmlElement (name="type")
	public List<String> getType() {
		return type;
	}
	public void setType(List<String> type) {
		this.type = type;
	}
	
	@XmlElement(name="geometry")
	public Geometry getGeometry() {
		return geometry;
	}
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	
	@XmlElement
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	@XmlElement
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	@XmlElement
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlElement
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	
	@XmlElement(name="place_id")
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	
	@XmlElement(name="scope")
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	
}
