package com.ygq.jobs.reflection;

import java.lang.reflect.Method;

public class ReflectOperation {
    public void reflectClassInInternalPackage() throws ClassNotFoundException {
        try {
            Class clazz = Class.forName("com.ygq.jobs.property.PropertyOperation");
            Object obj = clazz.newInstance();
            Method write = clazz.getMethod("writePropertiesFile", String.class);
            write.invoke(obj, ReflectOperation.class.getClassLoader().getResource(".").getPath() + "testRef.properties");
            System.out.println("Class is reflected.");
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
