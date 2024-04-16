package miscellousprogram;

public class StringBufferObjectAsParameters {

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("Hello");
        System.out.println("The string is: " + str);

        strFormalParameter(str);
        System.out.println("The string is: " + str);
    }

    private static void strFormalParameter(StringBuffer str) {
        System.out.println("The string is: " + str);
        str.append(" there!");
        System.out.println("The string is: " + str);
    }

}
