package ro.siit.exceplog;

import java.util.Random;

/**
 * Generating random values for all student fields
 */
public class Randomization {
    public static String randStrings(){
        Random random = new Random();
        int upperbound = 10;
        int n = random.nextInt(upperbound);
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "abcdefghijklmnopqrstuvxyz ";
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int)(AlphaNumericString.length() * Math.random());
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));

        }
        return sb.toString();
    }

    public static String randomDate(){
        String[] arr={"04/03.2005", "1996.06.04", "2023.01.04", "2003.01.04", "1980.09.04",
                "04-03-2005", "1976.02.24", "2004.12.04", "2013.01.04", "1989.09.04"};
        Random r=new Random();
        int randomNumber=r.nextInt(arr.length);
        String rdate = arr[randomNumber];
        return rdate;
    }

    public static String randomGender(){
        String[] arr={"male", "Male", "MALE", "female", "Female", "FEMALE",
                "undeclared", "UNDECLARED", "Undeclared"};
        Random r=new Random();
        int randomNumber=r.nextInt(arr.length);
        String rdate = arr[randomNumber];
        return rdate;
    }

    public static long randCNP() {
        Random random = new Random();
        int upperbound = 20;
        long n = random.nextInt(upperbound);
        return n;
    }
}
