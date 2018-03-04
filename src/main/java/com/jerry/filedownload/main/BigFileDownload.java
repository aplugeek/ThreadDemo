package com.jerry.filedownload.main;

import com.jerry.cn.filedownload.entity.Storage;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Date: 17/9/6 13:29
 *
 * @author jerry.R
 */

public class BigFileDownload implements Closeable {

    private final long fileSize;
    private final String fileName;
    private final URL requestURL;
    private final Storage storage;
    private final AtomicBoolean atomicBoolean = new AtomicBoolean(false);


    public BigFileDownload(String url) throws MalformedURLException, FileNotFoundException {
        requestURL = new URL(url);
        fileName = url.substring(url.lastIndexOf("/") + 1);
        fileSize = getFileSize(requestURL);
        storage = new Storage(fileSize, fileName);

    }

    public void download(int taskNum, long reportInterval) {
        long perThreadSize = fileSize / taskNum;
        long lowerBounds = 0;
        long upperBounds = 0;
        DownloadTask downloadTask = null;
        for (int i = taskNum; i >= 1; i--) {
            if (i == taskNum) {
                upperBounds = fileSize;
            } else {
                upperBounds = lowerBounds + perThreadSize - 1;
            }
            lowerBounds = i * perThreadSize;
            downloadTask = new DownloadTask(lowerBounds, upperBounds, requestURL, storage, atomicBoolean);
            dispatchWork(downloadTask, i);

        }
    }

    public void cancleDownload() throws IOException {
        if (atomicBoolean.compareAndSet(false, true)) {
            close();

        }
    }

    public void dispatchWork(final DownloadTask dt, int workerIndex) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    dt.run();
                } catch (Exception e) {
                    try {
                        cancleDownload();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    e.printStackTrace();
                }
            }
        });
        thread.setName("download thread-" + workerIndex);
        thread.start();
    }


    public void reportInterval(long reportInterval) throws InterruptedException {
        float lastComplete;
        int complete = 0;
        lastComplete = complete;
        while (!atomicBoolean.compareAndSet(false, true)) {
            complete = (int) (storage.getTotalWrites() * 100 / fileSize);
            if (complete == 100) {
                break;
            } else if (complete - lastComplete >= 1) {
                System.out.println("cpmplete:" + complete);

            }
            Thread.sleep(reportInterval);
        }


    }

    private long getFileSize(URL requestURL) {
        long fileSize = -1;
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) requestURL.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setRequestProperty("Connection", "Keep-alive");
            connection.connect();
            int statuCode = connection.getResponseCode();
            if (HttpURLConnection.HTTP_OK == statuCode) {
                fileSize = Long.parseLong(connection.getHeaderField("Content-Length"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fileSize;
    }


    @Override
    public void close() throws IOException {
        storage.close();

    }
}
