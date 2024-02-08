package com.openapi.generator.Util;

public enum Role {
    Developer("Developer"),
    DBAdministrator("DBAdministrator"),
    DataEngineer("DataEngineer"),
    DataScientist("DataScientist"),
    CloudEngineer("CloudEngineer");

    String value;
    Role(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
