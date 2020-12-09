package practice;

public class ShowValue {
    static int x = 5;
    int y = 10;

    void display() {
        System.out.println(this.y);
    }

    public static void main(String args[]) {
//        String testString1 = "Harshal";
//        System.out.println(testString1.substring(3)); //shal
//        System.out.println(testString1.substring(3, 6)); //sha size = 6-3
//
//        String testString2 = "2016";
//        int year = 2020;
//        System.out.println(Integer.parseInt(testString2));
//        System.out.println(Integer.toString(year));

        int[] arrayOfInts = new int[2];
        boolean[] arrayOfbools = new boolean[2];
        char[] arrayOfchars = new char[2];
        String[] arrayOfStrings = new String [2];

        for (Object i : arrayOfInts) {
            System.out.println(i);
        }

        for (Object i : arrayOfbools) {
            System.out.println(i);
        }

        for (Object i : arrayOfchars) {
            System.out.println(i);
        }

        for (Object i : arrayOfStrings) {
            System.out.println(i);
        }


    }
}