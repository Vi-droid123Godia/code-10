import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        String[] daysOfWeek = { "MONDAY" , "TUESDAY" , "WEDNESDAY" , "THURSDAY" , "FRIDAY", "SATURDAY" , "SUNDAY" };
        int numberOfLeapYears = 0;
        for(int i = 2001; i < year; i++){
            if(isLeapYear(i)){
                numberOfLeapYears++;
            }
        }
        int noOfYearDays = ((year - 2001) * 365 ) + numberOfLeapYears;
        int numberOfDaysInSingleMonth = 0;
        int noOfMonthDays = 0 ;
        int temp = month;
        while(--temp > 0){
            switch(temp){
                case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 :
                    numberOfDaysInSingleMonth = 31;
                    break;
                case 4 : case 6 : case 9 : case 11 :
                    numberOfDaysInSingleMonth = 30;
                    break;
                case 2 : if(isLeapYear(year)){
                    numberOfDaysInSingleMonth = 29;
                }else{
                    numberOfDaysInSingleMonth = 28;
                }
                    break;
                default: System.out.println("Invalid Entry");
                    break;
            }
            noOfMonthDays += numberOfDaysInSingleMonth;
        }
        int noOfDays = day - 1;
        String Answer = "";
        switch((noOfYearDays + noOfMonthDays + noOfDays) % 7){
            case 0 :  Answer = daysOfWeek[0];
                break;
            case 1 :  Answer = daysOfWeek[1];
                break;
            case 2 :  Answer = daysOfWeek[2];
                break;
            case 3 :  Answer = daysOfWeek[3];
                break;
            case 4 :  Answer = daysOfWeek[4];
                break;
            case 5 :  Answer = daysOfWeek[5];
                break;
            case 6 :   Answer = daysOfWeek[6];
                break;
            default: System.out.println("Error");
                break;
        }
        return Answer;
    }
    public static boolean isLeapYear(int a) {
        if ((a % 4 == 0 || a % 400 == 0) && a % 100 != 0)
            return true;
        else return false;
    }
}



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}






