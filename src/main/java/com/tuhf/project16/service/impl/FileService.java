package com.tuhf.project16.service.impl;

import com.tuhf.project16.mapper.FileMapper;
import com.tuhf.project16.model.File;
import com.tuhf.project16.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

@Service
public class FileService implements IFileService {

    @Autowired
    FileMapper fileMapper;

    @Override
    public int upload(MultipartFile file) {
        try {
            String hash = DigestUtils.md5DigestAsHex(file.getBytes());
            return fileMapper.add(new File(
                    file.getName(),
                    hash,
                    file.getBytes()
            ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public File download(long id, String hash) {
        return fileMapper.get(id, hash);
    }
}
