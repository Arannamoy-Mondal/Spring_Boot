package com.aranna.java13_spring_jpa.constant;

public enum Vehicle {
    SEDAN("Sedan"),
    SUV("SUV"),
    HATCHBACK("HatchBack"),
    UNKNOWN("Unknown");
    
    private Vehicle(String displayName) {
        this.displayName = displayName;
    }

    private final String displayName;

    public String getDisplayName() {
        return displayName;
    }
}
