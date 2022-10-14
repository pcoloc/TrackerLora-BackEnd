package com.trackerlora.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;

import com.trackerlora.backend.entity.TtnMapperData;
import com.trackerlora.backend.repository.TtnMapperDataRepository;


@Service
public class CsvExportService {


    @Autowired
    private TtnMapperDataRepository ttnMapperDataRepository;

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(CsvExportService.class);



    public CsvExportService(TtnMapperDataRepository ttnMapperDataRepository) {
        this.ttnMapperDataRepository = ttnMapperDataRepository;
    }

    public void writeEmployeesToCsv(Writer writer) {
        List<TtnMapperData> ttnMapperData = ttnMapperDataRepository.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (TtnMapperData ttnMapperItem : ttnMapperData) {
                csvPrinter.printRecord(ttnMapperItem.getId());
            }
        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }
    }
}
