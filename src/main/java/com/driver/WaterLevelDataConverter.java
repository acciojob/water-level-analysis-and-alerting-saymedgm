package com.driver;

public class WaterLevelDataConverter {
    public WaterLevel convertToEntity(WaterLevelDTO waterLevelDTO) {
        return new WaterLevel(waterLevelDTO.getSiteName(), waterLevelDTO.getWaterLevel());
    }

    public WaterLevelDTO convertToDTO(WaterLevel waterLevel) {
        return new WaterLevelDTO(waterLevel.getSiteName(), waterLevel.getWaterLevel());
    }
}
