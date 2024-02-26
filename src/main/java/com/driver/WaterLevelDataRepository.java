package com.driver;

import java.util.ArrayList;
import java.util.List;

public class WaterLevelDataRepository {
    private List<WaterLevel> waterLevels;

    public WaterLevelDataRepository() {
        this.waterLevels = new ArrayList<>();
    }

    public void storeWaterLevel(WaterLevel waterLevel) {
        waterLevels.add(waterLevel);
    }

    public List<WaterLevel> getAllWaterLevels() {
        return new ArrayList<>(waterLevels);
    }
}