package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Date;

public class Main {
    private static final Date d = new Date();


    public static void main(String[] args) {
        String[] deathM = {"very boring", "boring", "mundane", "cringe", "alright", "epic", "amazing", "litterally the coolest death of all time"};
        String[] deathHVB = {"you die in your sleep", "you got cancer", "im god and even i cant remember thats how boring your death was"};
        String[] deathHB = {"you died in a car crash", "you fell of a ladder", "you die of a heart attack"};
        String[] deathHM = {"you had a stroke", " you died of respiratory infections", "you died of diabetes"};
        String[] deathHC = {"you died like kenneth pinyon", "lmao you died when you bled out after getting a paper clip"};
        String[] deathHA = {"you die laughing at something truly funny", "you die among friends", "you got murdered"};
        String[] deathHE = {"you had a tortoise dropped on your head by an eagle", "you die like micheal warner", "yoe die like king adolf frederick of sweden"};
        String[] deathHAm = {"you die saving the life of another", "i dont know how but you jumped into a black hole", "you suffocated in titties"};
        String deathHL = "you invented time travel and traveled back to kill yourself, there is not cooler death than a paradoxical death";
        String deathhow = "";
        Random rand = new Random();
        int deathR = rand.nextInt(7);
        if (deathR == Arrays.asList(deathM).indexOf("very boring")) {
            deathhow = deathHVB[rand.nextInt(2)];
        } else if (deathR == Arrays.asList(deathM).indexOf("boring")) {
            deathhow = deathHB[rand.nextInt(2)];
        } else if (deathR == Arrays.asList(deathM).indexOf("mundane")) {
            deathhow = deathHM[rand.nextInt(2)];
        } else if (deathR == Arrays.asList(deathM).indexOf("cringe")) {
            deathhow = deathHC[rand.nextInt(1)];
        } else if (deathR == Arrays.asList(deathM).indexOf("alright")) {
            deathhow = deathHA[rand.nextInt(2)];
        } else if (deathR == Arrays.asList(deathM).indexOf("epic")) {
            deathhow = deathHE[rand.nextInt(2)];
        } else if (deathR == Arrays.asList(deathM).indexOf("amazing")) {
            deathhow = deathHAm[rand.nextInt(2)];
        } else if (deathR == Arrays.asList(deathM).indexOf("litterally the coolest death of all time")) {
            deathhow = deathHL;
        }

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
        int days = (30 * monthRaw) - modifier + day;
        int pdays = ((30 * pmonthRaw) + (pmodifier)) + pday + 1;// the plus 1 fixes things but i dont know why or how and now im scared
        int yid = (int) (((year * 365.2422) + days) - 365.2422); //does now account for leap years
        int pYid = (int) (((pyear * 365.2422) + pdays) - 365.2422);
        int dol = yid - pYid;
        int hours = dol * 24;
        int minutes = hours * 60;
        int seconds = minutes * 60;
        String a = "there have been ";
        System.out.println(a + yid + " days since 1 A.D.");
        System.out.println(a + pYid + " days between 1 A.D. and your birth");
        System.out.println(a + dol + " days in your life");
        System.out.println(a + hours + " hours in your life");
        System.out.println(a + minutes + " minutes in your life");
        System.out.println(a + seconds + " seconds in your life");
        int TA = year - pyear;
        int TD;
        if (pday > days) {

            System.out.println("you are " + TA);
            TD = rand.nextInt(110 - 73) + 73 - TA;
            System.out.println(TD);
        } else {
            System.out.println("you are " + (TA - 1));
            TA = TA - 1;
            TD = rand.nextInt(110 - 73) + 73 - TA - 1;
            System.out.println(TD);
        }

        System.out.println("you will die in " + TD + " years, you will be " + (TD + TA) + " and your death will be: " + deathM[deathR] + ", in fact " + deathhow);
    }

    private static int getInput(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
