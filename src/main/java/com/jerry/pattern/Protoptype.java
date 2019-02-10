package com.jerry.pattern;

/**
 * Date: 2019/1/20 16:58
 *
 * @author jerry.R
 */

public class Protoptype implements Cloneable {
    private String attribute = "initialization value ";

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @Override
    protected Protoptype clone() throws CloneNotSupportedException {
        Protoptype cloneObject = new Protoptype();
        cloneObject.setAttribute(this.attribute);
        return cloneObject;

    }

    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println(new Protoptype().clone().getAttribute());
    }
}
