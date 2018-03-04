package com.jerry.designMode.builder;

/**
 * Date: 17/9/7 13:12
 *
 * @author jerry.R
 */

public class User {
    private String name;
    private String address;
    private int age;


    private User(UserBuilder userBuilder) {
        this.name = userBuilder.name;
        this.address = userBuilder.address;
        this.age = userBuilder.age;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    public static class UserBuilder {

        private String name;
        private String address;
        private int age;

        public UserBuilder(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public UserBuilder() {

        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }


        public User builder() {
            return new User(this);
        }

    }
}
