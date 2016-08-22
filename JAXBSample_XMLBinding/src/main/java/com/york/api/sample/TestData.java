package com.york.api.sample;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlType(propOrder={"title", "book", "count", "type", "testData"})
public class TestData {
    String title;
    String book;
    String count;
    List<TestData> testData;
    List<String> type;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBook() {
        return book;
    }
    public void setBook(String book) {
        this.book = book;
    }
    public String getCount() {
        return count;
    }
    public void setCount(String count) {
        this.count = count;
    }

    @XmlElement(name="type")
    public List<String> getType() {
        return type;
    }
    public void setType(List<String> type) {
        this.type = type;
    }
    
    @XmlElement(name="test-data")
    public List<TestData> getTestData() {
        return testData;
    }
    public void setTestData(List<TestData> testData) {
        this.testData = testData;
    }
}