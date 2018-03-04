package com.jerry.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Date: 17/9/8 14:51
 *
 * @author jerry.R
 */

public class NioMain {
    public static void main(String[] args) {
        try {
            String sourceFile = "/Users/ruijia/Desktop/test.sh";
            String tartgetFile = "/Users/ruijia/Desktop/testCopy.sh";
            fileCopyWithNIO(sourceFile, tartgetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //copy file with nio
    private static void fileCopyWithNIO(String sourceFile, String tartgetFile) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(sourceFile);
        FileOutputStream fileOutputStream = new FileOutputStream(tartgetFile);
        FileChannel sourceChannel = fileInputStream.getChannel();
        FileChannel targetChannel = fileOutputStream.getChannel();
        //buffer
        ByteBuffer buffer = ByteBuffer.allocate(2048);
        //start copy file
        while (sourceChannel.read(buffer) != -1) {
            buffer.flip();
            targetChannel.write(buffer);
            buffer.clear();
        }

    }
}
