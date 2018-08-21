package com.jerry.thread;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class DeadLock {
    public static void main(String[] args) throws IOException {
        FileInputStream is = new FileInputStream(new File("/Users/ruijia/Desktop/1"));
        int temp = 0;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        while ((temp = is.read(bytes)) != -1) {
            System.out.println(temp);
            os.write(bytes, 0, temp);
        }
        System.out.println(Arrays.toString(os.toByteArray()));
    }
}

