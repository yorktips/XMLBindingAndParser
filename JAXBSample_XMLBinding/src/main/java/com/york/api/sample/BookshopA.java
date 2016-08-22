package com.york.api.sample;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class BookshopA {

    TestData testData;


    public BookshopA() {
		super();
	}
    
    public BookshopA(TestData testData) {
		super();
		this.testData = testData;
	}

	@XmlElement(name="test-data")
    public TestData getTestData() {
        return testData;
    }

    public void setTestData(TestData testData) {
        this.testData = testData;
    }

}