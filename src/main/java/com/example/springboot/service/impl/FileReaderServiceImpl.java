package com.example.springboot.service.impl;

import com.example.springboot.service.FileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public List<String> read(String fileName) {
        List<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("File has not been found", e);
        }
        return records;
    }
}
