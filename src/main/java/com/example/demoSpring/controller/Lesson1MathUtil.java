package com.example.demoSpring.controller;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Lesson1MathUtil {
    private String test;

    public Lesson1MathUtil(String test) {
        this.test = test;
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Lesson1MathUtil lesson1MathUtil1 = new Lesson1MathUtil("test");
        Lesson1MathUtil lesson1MathUtil2 = new Lesson1MathUtil("test2");
        lesson1MathUtil1.test();
        lesson1MathUtil2.test();

        int[][] twoArray = new int[3][4];

        System.out.println("min: " + min(3, 6));
        System.out.println("max: " + max(3, -6));
        System.out.println("abs: " + abs(-10));
        System.out.println("isEven: " + isEven(13));
        System.out.println("min2: " + min(3, 8, -9));
        System.out.println("max2: " + max(6, 9, 11));

        //lisaylesanne1 lugeda 2 täisarvu konsoolist ja kasutada valitud funktsiooni!!!!
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Trüki: abs, isEven, min2, max2, min3, max3");
        String func = scanner1.nextLine();
        if (func.equals("abs") || func.equals("isEven")){
            System.out.println("Sisesta 1 number:");
            int x = scanner1.nextInt();
            if (func.equals("abs")){
                System.out.println("abs: " + abs(x));
            } else {
                System.out.println("isEven: " + isEven(x));
            }
        } else if (func.equals("min2") || func.equals("max2")) {
            System.out.println("Sisesta 2 numbrit:");
            int x = scanner1.nextInt();
            int y = scanner1.nextInt();
            if (func.equals("min2")){
                System.out.println("min2: " + min(x, y));
            } else {
                System.out.println("max2: " + max(x, y));
            }
        } else {
            System.out.println("Sisesta 3 numbrit:");
            int x = scanner1.nextInt();
            int y = scanner1.nextInt();
            int z = scanner1.nextInt();
            if (func.equals("min3")){
                System.out.println("min3: " + min(x, y, z));
            } else {
                System.out.println("max3: " + max(x, y, z));
            }
        }
    }

    public void test() {
        System.out.println(test);
    }

    public static int min(int a, int b) {
        // TODO tagasta a ja b väikseim väärtus
        if (a < b) {
            return a;
        }
        return b;
    }

    public static int max(int a, int b) {
        // TODO tagasta a ja b suurim väärtus
        return Math.max(a, b);

//        if (a > b) {
//            return a;
//        }
//        return b;
    }

    public static int abs(int a) {
        // TODO tagasta a absoluut arv
        return Math.abs(a);

//        if(a<0){
//            return -a;
//        } else {
//            return a;
//        }
    }

    public static boolean isEven(int a) {
        // TODO tagasta true, kui a on paaris arv
        // tagasta false kui a on paaritu arv
        if (a % 2 == 0) {
            return true;
        }
        return false;
    }

    public static int min(int a, int b, int c) {
        // TODO tagasta a, b ja c väikseim väärtus
        int m = Math.min(a, b);     //Math.min takes only 2 arguments
        return Math.min(m, c);

//        int inner = min(a, b);    //using existing method min()
//        return min(inner,c);
    }

    public static int max(int a, int b, int c) {
        // TODO tagasta a, b ja c suurim väärtus
        int n = Math.max(a, b);
        return Math.max(n, c);
//        return max(max(a, b), c);     //using existing method max()
    }
}
