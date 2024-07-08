package com.tuhf.project16.service;

import com.tuhf.project16.model.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileService {
    public int upload(MultipartFile file);

    public File download(long id, String hash);
}
