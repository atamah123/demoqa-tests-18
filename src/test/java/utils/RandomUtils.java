package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
//        System.out.println(getRandomString(10));
//        System.out.println(getRandomInt(10, 100));
//        System.out.println(getRandomEmail());
//
//        String[] names = {"a", "b", "c", "d", "e"};
//        System.out.println(getRandomItemFromArray(names));

        System.out.println(getRandomDay());

    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomString(int length) {
//        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);

        return values[index];
    }

    public static String getRandomFirstName() {
        return new Faker().name().firstName();
    }

    public static String getRandomLastName() {
        return new Faker().name().lastName();
    }

    public static String getRandomEmail(String localpart) {
        return new Faker().internet().emailAddress(localpart + getRandomInt(100, 999));
    }

    public static String getRandomGender(){
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }

    public static String getRandomPhoneNumber(int length){
        String AB = "1234567890";

        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String getRandomDay(){
        Integer i1 = getRandomInt(1,28);
        StringBuilder sb = new StringBuilder();
        if(i1 < 10){
            sb.append(0);
        }
        sb.append(i1.toString());
        return sb.toString();
    }

    public static String getRandomMonth(){
        Integer i2 = getRandomInt(1,12);
        String month = null;
        switch (i2){
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
        }
        return month;
    }

    public static String getRandomYear(){
        Integer i3 = 1940 + getRandomInt(0,(2023-1940));
        return i3.toString();
    }

    public static String getRandomSubject(){
        return new Faker().options().option("Accounting", "Maths", "Arts",
                "English", "Physics", "Chemistry",
         "Computer Science", "Economics", "Social Studies", "History",
                "Civics", "Commerce", "Hindi", "Biology");
    }

    public static String getRandomHobbie(){
        String [] array = {"Sports", "Reading", "Music"};
        return getRandomItemFromArray(array);
    }

    public static String getRandomAddress(){
        return new Faker().address().fullAddress();
    }



//    public static String getRandomHobbies(int numberOfHobbies){
//        String [] array = {"Sports", "Reading", "Music"};
//
//        switch(numberOfHobbies){
//            case 1:
//
//                break;
//            case 2:
//
//                break;
//            case 3:
//
//                break;
//            case 4:
//                System.out.println("Неверное число, введите в диапазоне" +
//                        "от одного до трех");
//                break;
//        }
//
//        return "";
//    }
}