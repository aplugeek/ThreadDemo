package com.jerry.cn.filedownload.entity;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Date: 17/9/6 08:58
 *
 * @author jerry.R
 * storage file  for downloaded
 */

public class Storage implements Closeable, AutoCloseable {
    private final RandomAccessFile storeFile;
    private final FileChannel storeChannel;
    private final AtomicLong totalWrites = new AtomicLong(0);


    public Storage(long fileSize, String fileName) throws FileNotFoundException {
        String fullFileName = System.getProperty("java.io.tmpdir") + "/" + fileName;
        String localFileName = createStoreFile(fullFileName, fileSize);
        storeFile = new RandomAccessFile(localFileName, "rw");
        storeChannel = storeFile.getChannel();
    }

    /**
     * Write Data To Spec File
     *
     * @param offset offset
     * @param buffer NIO
     * @return writer length
     */
    public int store(long offset, ByteBuffer buffer) throws IOException {
        storeChannel.write(buffer, offset);
        int length = buffer.limit();
        totalWrites.addAndGet(length);
        return length;
    }

    /**
     * init StoreFile RandomAccessFile
     *
     * @param fullFileName fullFileName
     * @param fileSize     fileSize
     * @return localFileName
     * @throws FileNotFoundException exceptions
     */
    private String createStoreFile(String fullFileName, long fileSize) throws FileNotFoundException {
        File file = new File(fullFileName);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            randomAccessFile.setLength(fileSize);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //Tools.silentClose(randomAccessFile);
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return fullFileName;

    }

    public long getTotalWrites() {
        return totalWrites.get();
    }


    public void close() throws IOException {
        if (storeChannel.isOpen()) {
            storeChannel.close();
        }

    }
}
