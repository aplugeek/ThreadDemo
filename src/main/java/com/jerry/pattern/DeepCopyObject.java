package com.jerry.pattern;

import com.alibaba.fastjson.JSON;
import com.jerry.designMode.builder.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Date: 2018/7/8 16:39
 *
 * @author jerry.R
 */

public class DeepCopyObject  implements  Cloneable ,Serializable{

    private User user;

    private String description;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public  Object deepCLone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream objectOut = new ObjectOutputStream(bout);
        objectOut.writeObject(this);
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(bin);
        return  objectInputStream.readObject();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DeepCopyObject object = new DeepCopyObject();
        object.setUser(new User("jtest", 19));
        object.setDescription("test deep copy");
        DeepCopyObject object1 = (DeepCopyObject) object.deepCLone();
        object.getUser().setFlag((byte)1);
        System.out.println(object);
        System.out.println(object1);
    }
}
