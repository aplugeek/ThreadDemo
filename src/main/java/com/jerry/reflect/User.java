package com.jerry.reflect;

/**
 * Date: 2018/3/10 19:40
 *
 * @author jerry.R
 */

public class User {
    private  Long id ;
    private  String name;
    private  Byte sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
