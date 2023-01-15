package com.poc.exception;

import org.apache.http.HttpStatus;

public enum ErrorsEnum {

    /**
     * ERR_MCS_POC
     */
    ERR_READ_WRITE_CONFIG("Error occurred with the config file READ WRITE option"),
    ERR_MCS_TUTORIAL_TITLE_EMPTY("Error occurred - tutorial title shouldn't be NULL or EMPTY"),
    ERR_MCS_TUTORIAL_OBJECT_EMPTY("Error occurred - tutorial object or id shouldn't be NULL or EMPTY"),
    ERR_MCS_TUTORIAL_NO_UPDATE("Error occurred - tutorial not update"),
    ERR_MCS_TUTORIAL_NOT_FOUND("Error occurred - no tutorial found with this id");

    private final String errorMessage;

    private ErrorsEnum(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return " errorMessage : " + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
