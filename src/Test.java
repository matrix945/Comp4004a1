public class Test {


    public static int convert(String a) {
        if (a.length() == 3) {
            return 10;
        } else {
            if (a.charAt(1) == 74) {
                return 11;
            }
            else if (a.charAt(1) == 81) {
                return 12;
            }
            else if (a.charAt(1) == 75) {
                return 13;
            }
            else if (a.charAt(1) == 65) {
                return 1;
            }
            else{
                int k = a.charAt(1) - 48;
                return  k;
            }
        }
    }


    public static void main(String[] args) {
        String a = "A10";
        String b = "AJ";
        String c = "AQ";
        String d = "AK";
        String e = "AA";


        System.out.println(convert(a));
        System.out.println(convert(b));
        System.out.println(convert(c));
        System.out.println(convert(d));
        System.out.println(convert(e));


    }




}
