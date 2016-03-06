package com.teleportcall.util;

import java.util.List;

public class UserException extends Exception {


    private String shortMessage;
    private String detailMessage;
    private String languageCode;
    private String errorCode;
    private List<String> fieldErrors;

    public UserException() {

    }

    public UserException(String shortMessage, String detailMessage, String languageCode,
                           String errorCode, List<String> fieldErrors) {
        this.detailMessage = detailMessage;
        this.shortMessage = shortMessage;
        this.languageCode = languageCode;
        this.fieldErrors = fieldErrors;
        this.errorCode = errorCode;
    }

    public UserException(String shortMessage, String detailMessage, String languageCode,
                           List<String> fieldErrors) {
        this.detailMessage = detailMessage;
        this.shortMessage = shortMessage;
        this.languageCode = languageCode;
        this.fieldErrors = fieldErrors;
    }
    public String getShortMessage() {
        return shortMessage;
    }

    public void setShortMessage(String shortMessage) {
        this.shortMessage = shortMessage;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public List<String> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
