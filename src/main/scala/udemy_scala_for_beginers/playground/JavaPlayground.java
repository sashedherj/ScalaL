package playground;

// class which makes the analogies between Scala objects and Java statics
public class JavaPlayground {
    public static void main(String args[]) {
        System.out.println(Person.N_EYES);    // accessing N_EYES from person class is called class level functionality one of the fundamental aspects of oops

    }
}

class Person {
    public static final int N_EYES = 2;
}

