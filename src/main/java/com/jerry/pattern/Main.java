package com.jerry.pattern;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Date: 2017/10/20 11:48
 *
 * @author jerry.R
 */

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(new DeepCopyObject());
        ByteArrayInputStream byteInputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream inputStream = new ObjectInputStream(byteInputStream);
        inputStream.readObject();

    }
}
