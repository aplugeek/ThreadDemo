package com.jerry.cn.designMode.archetype;

/**
 * Date: 17/9/1 17:04
 *
 * @author jerry.R
 */

public class ArchetypeDemo {
    public static void main(String[] args) {
        ShapeCache.loadCahche();
        Shape shape = ShapeCache.getShape("3");
        System.out.println(shape.getType());
    }
}
