package com.york.app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.york.api.utils.*;

public class XpathParserDemo {
	public static void main(String[] args) {
		try {
			String file = "C:\\york\\1.Projects\\47. GooglePlacesApi\\xml_result.xml";
			File inputFile = new File(file);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			XPath xPath = XPathFactory.newInstance().newXPath();
			PlaceSearchResponse placeSearchResponse = new PlaceSearchResponse();

			// 1. status
			String xpath = "/PlaceSearchResponse/status";
			Node node = (Node) xPath.compile(xpath).evaluate(doc,
					XPathConstants.NODE);
			System.out.println(node.getNodeName());
			if (node != null)
				placeSearchResponse.setStatus(node.getTextContent());

			// 2. results
			xpath = "/PlaceSearchResponse/result";
			List<Place> retults = new ArrayList<Place>();

			NodeList nodeList = (NodeList) xPath.compile(xpath).evaluate(doc,XPathConstants.NODESET);
			for (int idx = 0; idx < nodeList.getLength(); idx++) {

				Node wkNode = nodeList.item(idx);
				
				if (wkNode.getNodeType() == Node.ELEMENT_NODE) {
					Place place = new Place();
	
					// 2.1. name
					xpath = "/PlaceSearchResponse/result[" + (idx + 1) + "]/name";
					node = (Node) xPath.compile(xpath).evaluate(doc,
							XPathConstants.NODE);
					if (node != null)
						place.setName(node.getTextContent());
	
					// 2.2. vicinity
					xpath = "/PlaceSearchResponse/result[" + (idx + 1)	+ "]/vicinity";
					node = (Node) xPath.compile(xpath).evaluate(doc,XPathConstants.NODE);
					if (node != null) place.setVicinity(node.getTextContent());
	
					// 2.3. type
					xpath = "/PlaceSearchResponse/result[" + (idx + 1) + "]/type";
					List<String> types = new ArrayList<String>();
					NodeList nodeList2 = (NodeList) xPath.compile(xpath).evaluate(
							doc, XPathConstants.NODESET);
					for (int idx2 = 0; idx2 < nodeList2.getLength(); idx2++) {
						node = nodeList2.item(idx2);
						types.add(node.getTextContent());
					}
	
					// 2.4. geometry/location/lat
					Geometry geometry = new Geometry();
	
					// 2.4.1. geometry/location
					Location location = new Location();
	
					xpath = "/PlaceSearchResponse/result[" + (idx + 1) + "]/geometry/location/lat";
					node = (Node) xPath.compile(xpath).evaluate(doc,
							XPathConstants.NODE);
					if (node != null)
						location.setLat(Double.parseDouble(node.getTextContent()));
					xpath = "/PlaceSearchResponse/result[" + (idx + 1)	+ "]/geometry/location/lng";
					node = (Node) xPath.compile(xpath).evaluate(doc,
							XPathConstants.NODE);
					if (node != null)
						location.setLng(Double.parseDouble(node.getTextContent()));
					geometry.setLocation(location);
	
					// 2.4.2. geometry/viewport
					Viewport viewport = new Viewport();
	
					// 2.4.2.1. geometry/viewport/southwest
					Location southwest = new Location();
					xpath = "/PlaceSearchResponse/result[" + (idx + 1)	+ "]/geometry/viewport/southwest/lat";
					node = (Node) xPath.compile(xpath).evaluate(doc,
							XPathConstants.NODE);
					if (node != null)
						southwest.setLat(Double.parseDouble(node.getTextContent()));
					xpath = "/PlaceSearchResponse/result[" + (idx + 1) + "]/geometry/viewport/southwest/lng";
					node = (Node) xPath.compile(xpath).evaluate(doc,
							XPathConstants.NODE);
					if (node != null)
						southwest.setLng(Double.parseDouble(node.getTextContent()));
					if (node != null)
						viewport.setSouthwest(southwest);
	
					// 2.4.2.2. geometry/viewport/northeast
					Location northeast = new Location();
					xpath = "/PlaceSearchResponse/result[" + (idx + 1)	+ "]/geometry/viewport/northeast/lng";
					node = (Node) xPath.compile(xpath).evaluate(doc,
							XPathConstants.NODE);
					if (node != null)
						northeast.setLat(Double.parseDouble(node.getTextContent()));
					xpath = "/PlaceSearchResponse/result[" + (idx + 1)	+ "]/geometry/viewport/northeast/lng";
					node = (Node) xPath.compile(xpath).evaluate(doc,
							XPathConstants.NODE);
					if (node != null)
						northeast.setLng(Double.parseDouble(node.getTextContent()));
					if (node != null)
						viewport.setSouthwest(northeast);
	
					geometry.setViewport(viewport);
					place.setGeometry(geometry);
	
					retults.add(place);
				}
			}
			placeSearchResponse.setRetults(retults);

			// 3. next_page_token
			xpath = "/PlaceSearchResponse/next_page_token";
			node = (Node) xPath.compile(xpath).evaluate(doc,
					XPathConstants.NODE);
			if (node != null)
				placeSearchResponse.setNext_page_token(node.getTextContent());

			System.out.println(retults.size());

			// NodeList nodeList = (NodeList)
			// xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
			// for (int i = 0; i < nodeList.getLength(); i++) {
			// Node nNode = nodeList.item(i);
			// System.out.println("\nCurrent Element :"
			// + nNode.getNodeName());
			// if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			// Element eElement = (Element) nNode;
			// System.out.println("Student roll no : "
			// + eElement.getAttribute("rollno"));
			// System.out.println("First Name : "
			// + eElement
			// .getElementsByTagName("firstname")
			// .item(0)
			// .getTextContent());
			// System.out.println("Marks : "
			// + eElement
			// .getElementsByTagName("marks")
			// .item(0)
			// .getTextContent());
			// }
			// }
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	}
}
