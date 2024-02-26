package com.driver;

public class WaterLevelDTO {
    private String siteName;
    private double waterLevel;

    public WaterLevelDTO(String siteName, double waterLevel) {
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
