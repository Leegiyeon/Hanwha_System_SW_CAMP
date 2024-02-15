package com.ohgiraffers.section02.reflection;

import java.lang.reflect.*;

public class Application {
    public static void main(String[] args) {

        /* 설명.
         *  리플렉션
         *   컴파일 된 자바코드에서 역으로 클래스를 불러 메소드 및 필드 정보를 구해오는 방법
         *   스프링 프레임워크, 마이바티스, 하이버네이트, jackson 등의 라이브러리에서 사용됨
         *   스프링에서 런타임 시, 개발자가 등록한 빈을 애플리케이션 내에서 사용할 수 있게 하는 기술
         *
         * 필기.
         *  reflection은 강력하지만 무분별한 사용은 금한다.
         *  1. 오버헤드 발생: 성능 저하
         *  2. 캐슐화 저해
        * */


        /* 설명. 1. Class 타입의 Class 메타정보 추출 */
        Class class1 = Account.class;
        System.out.println("class1 = " + class1);

        Class class2 = Account.class;
        System.out.println("class2 = " + class2);

        try {
            Class class3 = Class.forName("com.ohgiraffers.section02.reflection.Account");
            System.out.println("class3 = " + class3);

            Class class4 = Class.forName("[D");
            Class class5 = double[].class;

            System.out.println("class4 = " + class4);
            System.out.println("class5 = " + class5);

            Class class6 = Class.forName("[Ljava.lang.String;");
            Class class7 = String[].class;

            System.out.println("class6 = " + class6);
            System.out.println("class7 = " + class7);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        /* 설명. 2. 필드정보 추출 */
        Field[] fields = Account.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Modifier.toString(field.getModifiers()) = " + Modifier.toString(field.getModifiers())
            + ", type = " + field.getType()
            + ", name = " + field.getName());
        }

        /* 설명. 3. 생성자 정보 추출 */
        Constructor[] constructors = Account.class.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("constructor1.getName() = " + constructor.getName());

            Class[] parms = constructor.getParameterTypes();
            for (Class parm : parms) {
                System.out.println("parm.getTypeName() = " + parm.getTypeName());

            }
        }

        try {
            Account acc = (Account) constructors[0].newInstance("20","110-223-123456", "1234", 10000);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        /* 설명. 4. 메소드 정보 추출 */
        Method[] methods = Account.class.getMethods();
        Method getBalanceMethod = null;
        for (Method method : methods) {
            System.out.println(Modifier.toString(method.getModifiers()) + " "
            + method.getReturnType().getSimpleName() + " "
            + method.getName());

            if ("getBalance".equals(method.getName())){
                getBalanceMethod = method;
            }
        }


        try {
            System.out.println(getBalanceMethod.invoke((Account)constructors[2].newInstance()));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
