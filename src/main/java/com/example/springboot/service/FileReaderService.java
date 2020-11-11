package com.example.springboot.service;

import java.util.List;

public interface FileReaderService {
    List<List<String>> read(String fileName);
}
