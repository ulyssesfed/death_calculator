package com.company;

import java.util.Scanner;
import java.util.Date;

public class Main {
    private static final Date d = new Date();


    public static void main(String[] args) {
        //noinspection deprecation
        int year = d.getYear() + 1900;
        //noinspection deprecation
        int day = d.getDate();
        //noinspection deprecation
        int monthRaw = d.getMonth();
        int modifier = 0;
        int pyear = getInput("year of birth");
        int pday = getInput("day of birth");
        int pmonthRaw = getInput("month of birth (number)") - 1;
        int pmodifier = 0;
        int i = 1;
        int pi = 1;
        while (i < monthRaw) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10) {
                modifier = modifier + 1;
                i++;
            } else if (i == 4 || i == 6 || i == 9) {
                i++;
            } else if (i == 2) {
                modifier = modifier - 2;
                i++;
            }
        }
        while (pi < pmonthRaw) {
            if (pi == 1 || pi == 3 || pi == 5 || pi == 7 || pi == 8 || pi == 10 || pi == 12) {
                pmodifier = pmodifier + 1;
                pi++;
            } else if (pi == 4 || pi == 6 || pi == 9 || pi == 11) {
                pi++;
            } else if (pi == 2) {
                pmodifier = pmodifier - 2;
                pi++;
            }
        }
        int days = (30 * monthRaw) - (modifier) + day; //this causes issues for some reason
        int pdays = ((30 * pmonthRaw) - (pmodifier)) + pday;
        int yid = (int) (((year * 365.2422) + days) - 365.2422); //does now account for leap years
        int pYid = (int) (((pyear * 365.2422) + pdays) - 365.2422);
        System.out.println(yid);
        System.out.println(pYid);
        System.out.println(yid - pYid);

        int TA = year - pyear;
        System.out.println(TA);

    }

    private static int getInput(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
