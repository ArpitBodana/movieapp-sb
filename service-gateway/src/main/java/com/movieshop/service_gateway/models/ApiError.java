package com.movieshop.service_gateway.models;



import java.util.Date;


public class ApiError {
    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Integer errorCode;
    private String errorDescription;
    private Date date;

    public ApiError(int i, String noProductFound, Date date) {
        this.errorCode = i;
        this.errorDescription=noProductFound;
        this.date=date;
    }
}
