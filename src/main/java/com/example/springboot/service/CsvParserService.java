package com.example.springboot.service;

public interface CsvParserService<T> {
    T parseLine(String str);
}
