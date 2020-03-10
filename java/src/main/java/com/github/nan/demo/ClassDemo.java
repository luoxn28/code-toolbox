package com.github.nan.demo;

import lombok.Data;

import java.lang.annotation.*;
import java.util.Arrays;

/**
 * Class类demo
 *
 * @author luoxiangnan
 * @date 2020-03-11
 */
public class ClassDemo {

    @Data
    @ParentAnnotation
    class ParentClass {
        public int a1;
        private int a2;
    }

    @Data
    @SubAnnotation
    class SubClass extends ParentClass {
        public int b1;
        private int b2;
    }

    public static void main(String[] args) throws Exception {

        // 获取类名称
        System.out.println(ParentClass.class.getName());
        System.out.println(ParentClass.class.getSimpleName());
        System.out.println(ParentClass.class.getCanonicalName());

        // 获取类注解
        System.out.println(Arrays.toString(SubClass.class.getAnnotations()));
        System.out.println(SubClass.class.getAnnotation(ParentAnnotation.class));
        System.out.println(Arrays.toString(SubClass.class.getAnnotationsByType(ParentAnnotation.class)));
        System.out.println(Arrays.toString(SubClass.class.getDeclaredAnnotations()));
        System.out.println(SubClass.class.getDeclaredAnnotation(SubAnnotation.class));
        System.out.println(Arrays.toString(SubClass.class.getDeclaredAnnotationsByType(SubAnnotation.class)));

        // 获取注解类名称
        System.out.println(SubAnnotation.class.getName());
        System.out.println(SubClass.class.getAnnotation(ParentAnnotation.class).annotationType().getName());

        // 获取数组中元素class类型
        System.out.println(Integer[].class.getComponentType());

        // 获取field属性
        // 所有公共的filed列表（包括父类中的）
        System.out.println(Arrays.toString(SubClass.class.getFields()));
        // 当前类声明的field列表（包括当前类中private属性）
        System.out.println(Arrays.toString(SubClass.class.getDeclaredFields()));

        // 获取method属性
        System.out.println(Arrays.toString(SubClass.class.getMethods()));
        System.out.println(Arrays.toString(SubClass.class.getDeclaredMethods()));
        System.out.println(SubClass.class.getMethod("getB1"));
        System.out.println(SubClass.class.getMethod("setB1", int.class));
        System.out.println(SubClass.class.getMethod("wait"));
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(value = {ElementType.TYPE})
    @Documented
    @Inherited
    @interface ParentAnnotation {
    }

    @Target(value = {ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface SubAnnotation {
    }
}
