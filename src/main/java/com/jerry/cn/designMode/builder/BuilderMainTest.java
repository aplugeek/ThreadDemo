package com.jerry.cn.designMode.builder;

/**
 * Date: 17/9/7 13:23
 *
 * @author jerry.R
 */

public class BuilderMainTest {
    public static void main(String[] args) {
        User user = new User.UserBuilder("jerry", "ah")
                .age(22)
                .builder();
        System.out.println(user.toString());

    }

}
