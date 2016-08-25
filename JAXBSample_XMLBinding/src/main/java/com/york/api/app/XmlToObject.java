package com.york.api.app;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.york.api.sample.BookshopA;
import com.york.api.utils.PlaceSearchResponse;
import com.york.api.utils.Result;

public class XmlToObject {
	
	public static void main(String[] args) {
		//bookshop();
		googleApi();
	}
	
	public static void googleApi() {
		
		try {
			File file = new File("xml_result.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(PlaceSearchResponse.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			PlaceSearchResponse que = (PlaceSearchResponse) jaxbUnmarshaller.unmarshal(file);

			List<Result> results= que.getResult();
			
	        Marshaller marshaller = jaxbContext.createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        
	        StringWriter sw = new StringWriter();
	        //marshaller.marshal(que, System.out);
                marshaller.marshal(que,sw);
                String xmlString = sw.toString();
                System.out(xmlString);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	public static void bookshop() {
		
		try {

			File file = new File("bookshop.xml.txt");
			JAXBContext jaxbContext = JAXBContext.newInstance(BookshopA.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			BookshopA que = (BookshopA) jaxbUnmarshaller.unmarshal(file);
		
	        Marshaller marshaller = jaxbContext.createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        marshaller.marshal(que, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
