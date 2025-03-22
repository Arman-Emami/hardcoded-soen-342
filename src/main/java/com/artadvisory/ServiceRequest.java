package com.artadvisory;

import java.util.Date;

public class ServiceRequest {
    private int requestId;
    private String requestType;
    private Date requestDate;
    private String requestTime;  // or use a more precise type

    // Constructors
    public ServiceRequest() {}

    public ServiceRequest(int requestId, String requestType, Date requestDate, String requestTime) {
        this.requestId = requestId;
        this.requestType = requestType;
        this.requestDate = requestDate;
        this.requestTime = requestTime;
    }

    // Getters and Setters
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    // UML method
    public void displayRequestInfo() {
        // TODO implement
    }
}
