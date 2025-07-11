package com.rubidium.api.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rubidium.api.service.DataPopulationService;

@Component
public class DataPopulationRunner  implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(DataPopulationRunner.class);
    private final DataPopulationService dataPopulationService;

    public DataPopulationRunner(DataPopulationService dataPopulationService) {
        this.dataPopulationService = dataPopulationService;
    }

    @Override
    public void run(String... args) {
        // Specify the number of fake users to generate and populate the database
        
        logger.info("Starting faker runner...");
        int numberOfDataToGenerate = 0;
        dataPopulationService.populateCategories(numberOfDataToGenerate);

        numberOfDataToGenerate = 0;
        dataPopulationService.populateProducts(numberOfDataToGenerate);
        logger.info("Ended faker runner...");
    }
    
}
