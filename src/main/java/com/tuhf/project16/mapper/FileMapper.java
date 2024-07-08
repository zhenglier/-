package com.tuhf.project16.mapper;

import com.tuhf.project16.model.File;

import java.sql.Blob;

public interface FileMapper {
    public int add(File file);
    public File get(Long id, String hash);
}
