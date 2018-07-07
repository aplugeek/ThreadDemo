package com.jerry.designMode.builder;

import com.alibaba.fastjson.JSON;

/**
 * Date: 17/9/7 13:23
 *
 * @author jerry.R
 */

public class BuilderMainTest {
    public static void main(String[] args) {
        User user = new User.UserBuilder("jerry", null)
                .builder();

        System.out.println(JSON.toJSON(user));



    }

}
