package edu.neu.csye6200.utils;

public enum StringRes {
    TITLE("Vimaan Airways"),
    BACK("Back"),
    PASSENGERS,
    INTERNATIONAL,
    DOMESTIC,
    BOOKING;

    private final String value;

    StringRes() {
        this.value="";
    }
    StringRes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

