package com.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        System.out.println("This program will calculate the next date after a given date.");
        System.out.println("Please enter the day, month and year in the format dd mm yyyy");

        Scanner input = new Scanner(System.in);

        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        System.out.println("The next date is: " + NextDate(day, month, year));

    }

    public static String NextDate(int day, int month, int year) {

        boolean leapYear = false;

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            leapYear = true;

        if (year < 1812 || year > 2212) {
            System.out.println("Error: Dates can only be between 1812 and 2212");
            return "Error: Dates can only be between 1812 and 2212";
        }

        else if (day == 29 && month == 2 && !leapYear) {
            System.out.println("Error: Date is incorrect ");
            return "Error: Date is incorrect ";
        }

        else if ((day == 30 || day == 31) && month == 2) {
            System.out.println("Error: Date is incorrect ");
            return "Error: Date is incorrect ";
        }

        else if (month == 12 && day == 31 && (year + 1 == 2213)) {
            System.out.println("Error: Date is incorrect ");
            return "Error: Date is incorrect ";
        }

        else if (day == 31 && (month == 4 || month == 6 || month == 9 || month == 11)) {
            System.out.println("Error: Date is incorrect ");
            return "Error: Date is incorrect ";
        }

        else if (day >= 32 || month > 12 || month <= 0 || day <= 0) {
            System.out.println("Error: Date is incorrect ");
            return "Error: Date is incorrect ";

        }

        if (day == 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
            day = 1;
            month += 1;
        } else if (day == 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10)) {
            day = 1;
            month += 1;
        } else if (day == 28 && month == 2 && leapYear)
            day += 1;

        else if (day == 28 && month == 2 && !leapYear) {
            day = 1;
            month += 1;
        } else if (day == 29 && month == 2 && leapYear) {
            day = 1;
            month += 1;
        } else if (month == 12 && day == 31) {
            year += 1;
            day = 1;
            month = 1;
        } else
            day += 1;

        return (day + " " + month + " " + year);
    }
}
