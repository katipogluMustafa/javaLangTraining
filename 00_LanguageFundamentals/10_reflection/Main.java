package com.meshale.Control;

import java.util.*;
import java.lang.reflect.*;

public class Main {

    public static void main(String... args) throws ReflectiveOperationException{

        // Read class name from arg 0 else from cmd
        String name;
        if(args.length > 0 )
            name = args[0];
        else{
            Scanner in = new Scanner(System.in);
            System.out.println("Enter Class Name: (for ex. java.util.Date)");
            name = in.next();
            in.close();
        }

        // Print Class Name And Superclass Name(if != Object)
        Class cl = Class.forName(name);
        Class supercl = cl.getSuperclass();
        String modifiers = Modifier.toString(cl.getModifiers());
        if( modifiers.length() > 0 )
            System.out.println(modifiers + " ");
        System.out.println("class " + name);
        if(supercl != null && supercl != Object.class )
            System.out.println(" extends " + supercl.getName());

        System.out.println("\n{\n");
        printFields(cl);
        System.out.println();
        printConstructors(cl);
        System.out.println();
        printMethods(cl);
        System.out.println("}");
    }

    /**
     * Prints all constructors of a class
     * @param cl a class
     */
    public static void printConstructors(Class cl){
        Constructor[] constructors = cl.getDeclaredConstructors();

        for( Constructor c : constructors){
            String name = c.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString( c.getModifiers() );
            if( modifiers.length() > 0 )
                System.out.print(modifiers + " ");
            System.out.print(name);

            // Print Parameter Types
            printParams(c.getParameterTypes());
        }

    }

    /**
     * Prints all the methods of a class
     * @param cl a class
     */
    public static void printMethods(Class cl){
        Method[] methods = cl.getMethods();

        for(Method m: methods){
            Class retType = m.getReturnType();
            String name = m.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(m.getModifiers());
            if( modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(retType + " " + name);

            // printParamTypes
            printParams(m.getParameterTypes());
        }
    }



    /**
     * Prints all the fields of a class
     * @param cl a class
     */
    public static void printFields(Class cl){
        Field[] fields = cl.getFields();

        for(Field f : fields){
            Class type = f.getType();
            String name = f.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(f.getModifiers());
            if( modifiers.length() > 0)
                System.out.println(modifiers + "  ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }

    /**
     * Prints The parameters
     * @param parameterTypes an array of class
     */
    private static void printParams(Class<?>[] parameterTypes) {
        Class[] paramTypes = parameterTypes;
        System.out.print("(");
        for(int j = 0; j < paramTypes.length;j++){
            if(j > 0)
                System.out.print(", ");
            System.out.print(paramTypes[j].getName());
        }
        System.out.println(");");
    }


}
