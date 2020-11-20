package com.lukehatton.reflection;

import java.lang.reflect.*;

/**
 * ClassName: GetInformationFromClass
 * Description:
 * Author: lizhao
 * Date: 2020/11/20 20:46
 * History:
 */
@SuppressWarnings("rawtypes")
public class GetInformationFromClass {

    //使用时直接调用这个方法，可以获得一个类的全部信息
    public static void getClassMessage(Class cla) {
        getField(cla);
        getMethods(cla);
        getConstructors(cla);
    }

    /**
     * 打印类头,获取全部成员变量
     */
    public static void getField(Class cla) {
        // 类头
        String clzMod = Modifier.toString(cla.getModifiers());
        String clzName = cla.getName();
        String superName = cla.getSuperclass().getName();
        Class[] implement = cla.getInterfaces();// 获取实现的接口
        System.out.print(clzMod + " " + clzName + " entends " + superName);
        if (implement.length != 0) {
            System.out.print(" implements ");
            for (int i = 0; i < implement.length; i++) {
                if (i != implement.length - 1) {
                    System.out.print(implement[i].getName() + ",");
                } else {
                    System.out.print(implement[i].getName());
                }
            }
        }
        System.out.println("\r\n{");
        // 输出全部成员变量
        Field[] fields = cla.getDeclaredFields();
        for (Field f : fields) {
            String name = f.getName();// 获取成员变量类名
            String typeName = f.getType().getName();
            String modifier = Modifier.toString(f.getModifiers());// 获取修饰符(全部)
            System.out.println("\t" + modifier + " " + typeName + " " + name);
        }
    }

    /**
     * 输出全部构造方法签名
     */
    public static void getConstructors(Class cla) {
        Constructor[] constructors = cla.getDeclaredConstructors();
        for (Constructor c : constructors) {
            String name = c.getName();
            String modifier = Modifier.toString(c.getModifiers());// 获取修饰符(全部)
            System.out.print("\t" + modifier + " " + name + "(");
            Class[] params = c.getParameterTypes();// 获取参数类型
            for (int i = 0; i < params.length; i++) {
                if (i != params.length - 1) {
                    System.out.print(params[i].getName() + ",");
                } else {
                    System.out.print(params[i]);
                }
            }
            System.out.println(")");
        }
        System.out.println("}");
    }

    /**
     * 输出全部方法签名
     */
    public static void getMethods(Class cla) {
        Method[] methods = cla.getDeclaredMethods();
        for (Method m : methods) {
            String name = m.getName();
            String modifier = Modifier.toString(m.getModifiers());// 获取修饰符(全部)
            String returnType = m.getReturnType().getName();
            System.out.print("\t" + modifier + " " + returnType + " " + name + "(");
            Class[] params = m.getParameterTypes();// 获取参数类型
            for (int i = 0; i < params.length; i++) {
                if (i != params.length - 1) {
                    System.out.print(params[i].getName() + ",");
                } else {
                    System.out.print(params[i]);
                }
            }
            System.out.println(")");
        }
    }
}

