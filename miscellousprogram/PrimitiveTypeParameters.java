package miscellousprogram;

public class PrimitiveTypeParameters {

    public static void main(String[] args) {
        int number = 6;
        String name = "John";
        System.out.println("The number is: " + number);
        System.out.println("The name is: " + name);
        name = "A" + name;
        System.out.println("The name is: " + name);
        primFormalParameter(number);
    }

    private static void primFormalParameter(int number) {
        System.out.println("The number is: " + number);
        number = 10;
        System.out.println("The number is: " + number);
    }
}
