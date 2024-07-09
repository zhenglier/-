package com.tuhf.project16.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carrier {
    private Long id;

    private String name;

    private Long governmentId;
}
