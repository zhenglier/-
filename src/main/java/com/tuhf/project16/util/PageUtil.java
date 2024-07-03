package com.tuhf.project16.util;

public class PageUtil {
    public static int calOffset(int pageNumber, int pageSize) {
        return (pageNumber - 1) * pageSize;
    }
}
