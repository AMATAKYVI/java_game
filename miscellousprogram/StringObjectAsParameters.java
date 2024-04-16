package miscellousprogram;

public class StringObjectAsParameters {

    public static void main(String[] args) {
        String str = "Hello";
        System.out.println("The string is: " + str);

        strFormalParameter(str);
        System.out.println("The string is: " + str);
    }

    private static void strFormalParameter(String str) {
        System.out.println("The string is: " + str);
        str = "Sunny Day";
        System.out.println("The string is: " + str);
    }

}
