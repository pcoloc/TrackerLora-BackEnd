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
    private List<TtnMapperData> ttnMapperDatas;

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(CsvExportService.class);



    public CsvExportService(List<TtnMapperData> ttnMapperDatas) {
        this.ttnMapperDatas = ttnMapperDatas;
    }

    public void writeEmployeesToCsv(Writer writer) {
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (TtnMapperData ttnMapperItem : ttnMapperDatas) {
                csvPrinter.printRecord(ttnMapperItem.getId());
            }
        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }
    }
}
