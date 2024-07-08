package com.tuhf.project16.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.sql.rowset.serial.SerialBlob;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class File {
    private Long id;

    private String name;

    private String hash;

    private byte[] data;

    public File(String name, String hash, byte[] data) {
        this.name = name;
        this.hash = hash;
        this.data = data;
    }
}
