package com.driver;

import java.util.List;

public class HydroInfoService {
    private WaterLevelDataRepository waterLevelDataRepository;

    public HydroInfoService(WaterLevelDataRepository waterLevelDataRepository) {
        this.waterLevelDataRepository = waterLevelDataRepository;
    }

    public void storeWaterLevelData(WaterLevelDTO waterLevelDTO) {
        WaterLevel waterLevel = new WaterLevelDataConverter().convertToEntity(waterLevelDTO);
        waterLevelDataRepository.storeWaterLevel(waterLevel);
    }

    public List<WaterLevel> getAllWaterLevels() {
        return waterLevelDataRepository.getAllWaterLevels();
    }
}
