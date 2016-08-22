package com.york.app;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.york.api.utils.Geometry;
import com.york.api.utils.Location;
import com.york.api.utils.Photo;
import com.york.api.utils.Place;
import com.york.api.utils.PlaceSearchResponse;
import com.york.api.utils.Viewport;

public class DOM4JParserDemo {
	
	public static void main(String[] args) {
		try {
			String file="C:\\york\\1.Projects\\47. GooglePlacesApi\\xml_result.xml";
			File inputFile = new File(file);
			SAXReader reader = new SAXReader();
			Document document = reader.read(inputFile);
			
			PlaceSearchResponse placeSearchResponse= new PlaceSearchResponse();

			//1. status
			Node node1=document.selectSingleNode("/PlaceSearchResponse/status");
			if (node1 != null) placeSearchResponse.setStatus(node1.getText());

			//2. result 
			List<Node> results = document.selectNodes("/PlaceSearchResponse/result");
			List<Place> places = new ArrayList<Place>();
			
			for (int cnt=1; cnt <= results.size(); cnt++) {
				Place place= new Place();
				
				//2.1. name
				String xpath="/PlaceSearchResponse/result[" + (cnt) + "]/name";
				node1 = document.selectSingleNode(xpath);
				if (node1!=null) place.setName(node1.getText());
				
				//2.2. vicinity
				xpath="/PlaceSearchResponse/result[" + (cnt) + "]/vicinity";
				node1 = document.selectSingleNode(xpath);
				if (node1!=null) place.setVicinity(node1.getText());

				//2.3. type
				xpath="/PlaceSearchResponse/result[" + (cnt) + "]/type";
				@SuppressWarnings("unchecked")
				List<Node> typeNodes = document.selectNodes(xpath);
				List<String> types = new ArrayList<String>();				
				for (Node typeNode : typeNodes) {
					types.add(typeNode.getText());
				}
				place.setType(types);

				//2.4.geometry
				Geometry geometry = new Geometry();
				
				//2.4.1. geometry/location
				Location location= new Location();
				
				xpath="/PlaceSearchResponse/result[" + (cnt) + "]/geometry/location/lat";
				node1=document.selectSingleNode(xpath);				
				if (node1!=null) location.setLat(Double.parseDouble(node1.getText()));
				xpath="/PlaceSearchResponse/result[" + (cnt) + "]/geometry/location/lng";
				node1=document.selectSingleNode(xpath);				
				if (node1!=null) location.setLng(Double.parseDouble(node1.getText()));
				geometry.setLocation(location);

				//2.4.2. geometry/viewport
				Viewport viewport= new Viewport();

				//2.4.2.1. geometry/viewport/southwest
				Location southwest= new Location();
				xpath="/PlaceSearchResponse/result[" + (cnt) + "]/geometry/viewport/southwest/lat";
				node1=document.selectSingleNode(xpath);				
				if (node1!=null) southwest.setLat(Double.parseDouble(node1.getText()));
				xpath="/PlaceSearchResponse/result[" + (cnt) + "]/geometry/viewport/southwest/lng";
				node1=document.selectSingleNode(xpath);				
				if (node1!=null) southwest.setLng(Double.parseDouble(node1.getText()));
				if (node1!=null) viewport.setSouthwest(southwest);

				//2.4.2.2. geometry/viewport/northeast
				Location northeast= new Location();
				xpath="/PlaceSearchResponse/result[" + (cnt) + "]/geometry/viewport/northeast/lng";
				node1=document.selectSingleNode(xpath);				
				if (node1!=null) northeast.setLat(Double.parseDouble(node1.getText()));
				xpath="/PlaceSearchResponse/result[" + (cnt) + "]/geometry/viewport/northeast/lng";
				node1=document.selectSingleNode(xpath);				
				if (node1!=null) northeast.setLng(Double.parseDouble(node1.getText()));
				if (node1!=null) viewport.setSouthwest(northeast);

				geometry.setViewport(viewport);
				place.setGeometry(geometry);
				
				//2.4.3. icon
				xpath="/PlaceSearchResponse/result[" + (cnt) + "]/icon";
				node1=document.selectSingleNode(xpath);
				if (node1!=null) place.setIcon(node1.getText());

				//2.4.4. reference
				xpath="/PlaceSearchResponse/result[" + (cnt) + "]/reference";
				node1=document.selectSingleNode(xpath);
				if (node1!=null) place.setReference(node1.getText());
				
				//2.4.5. id
				xpath="/PlaceSearchResponse/result[" + (cnt) + "]/id";
				node1=document.selectSingleNode(xpath);
				if (node1!=null) place.setId(node1.getText());

				//2.4.6. photo
				Photo photo = new Photo();
				//2.4.6.1. photo/photo_reference
				xpath="/PlaceSearchResponse/result[" + (cnt) + "]/photo/photo_reference";
				node1=document.selectSingleNode(xpath);
				if (node1!=null) photo.setPhotoReference(node1.getText());

				//2.4.6.2. photo/width
				xpath="/PlaceSearchResponse/result[" + (cnt) + "]/photo/width";
				node1=document.selectSingleNode(xpath);
				if (node1!=null) photo.setWidth(Integer.parseInt(node1.getText()));
				
				//2.4.6.3. photo/height
				xpath="/PlaceSearchResponse/result[" + (cnt) + "]/photo/height";
				node1=document.selectSingleNode(xpath);
				if (node1!=null) photo.setHeight(Integer.parseInt(node1.getText()));
				
				//2.4.6.4. photo/html_attribution
				xpath="/PlaceSearchResponse/result[" + (cnt) + "]/photo/html_attribution/a";
				node1=document.selectSingleNode(xpath);
				if (node1!=null){
					if(node1.getNodeType() == Node.ELEMENT_NODE) {
						Element e1 = (Element) node1;
						System.out.println("a=" + e1.attribute("href").getValue());
						System.out.println(node1.getText());
					}
				}
				
				//2.4.7. place_id
				xpath="/PlaceSearchResponse/result[" + (cnt) + "]/place_id";
				node1=document.selectSingleNode(xpath);
				if (node1!=null) place.setPlace_id(node1.getText());

				//2.4.8. scope
				xpath="/PlaceSearchResponse/result[" + (cnt) + "]/scope";
				node1=document.selectSingleNode(xpath);
				if (node1!=null) place.setScope(node1.getText());

				places.add(place);
				
			}

			placeSearchResponse.setRetults(places);

		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
}
