public class Main {

    public static void main(String[] args) {
        /* class variable */
        /*
         * Syntax: static Class varName = something
         * when we make a variable static
         * the variable becomes same for all the instances of a class
         * it is called class variable or static variable
         */

        StaticVarExample first_static = new StaticVarExample();
        StaticVarExample second_static = new StaticVarExample();

        print(first_static,second_static);
        first_static.myClassVar = "Changed static var content";
        print(first_static,second_static);

        System.out.println("************************");
        /* Instance Variable */

        InstanceVarExample first_instance = new InstanceVarExample();
        InstanceVarExample second_instance = new InstanceVarExample();

        print(first_instance,second_instance);
        second_instance.instanceClassVar = "lets change this one and see the change just in this instance";
        print(first_instance,second_instance);

    }

    public static void print(StaticVarExample first, StaticVarExample second){
        System.out.println("Print Starting....");
        try{
            System.out.println(first.myClassVar);
            System.out.println(second.myClassVar);
            System.out.println("Print Successfully ended....");
        }catch(Exception e){
            System.out.println("Print operation has interrupted, unpredicted Exception...");
        }
    }

    public static void print(InstanceVarExample first, InstanceVarExample second){
        System.out.println("Print Starting....");
        try{
            System.out.println(first.instanceClassVar);
            System.out.println(second.instanceClassVar);
            System.out.println("Print Successfully ended....");
        }catch(Exception e){
            System.out.println("Print operation has interrupted, unpredicted Exception...");
        }
    }

}
