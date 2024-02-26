package com.driver;

public class WaterLevel {
    private String siteName;
    private double waterLevel;

    public WaterLevel(String siteName, double waterLevel) {
        this.siteName = siteName;
        this.waterLevel = waterLevel;
    }

    public String getSiteName() {
        return siteName;
    }

    public double getWaterLevel() {
        return waterLevel;
    }
}
