package com.example.demoSpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Arrays;

@RestController
public class Lesson3Controller {

    //  HTTP Exercise 'uusSumma()'
    @GetMapping ("uussumma")
    public int Lesson3(@RequestParam("x") int x, @RequestParam("y") int y){

        return Lesson3Controller.uusSumma(x, y);
    }

    // HTTP Exercise 'sum()' DONT DO AT THE MOMENT

    // HTTP Exercise ''


    public static int uusSumma(int x, int y) {
        // TODO tagasta x ja y summa vaartus
        return x+y;
    }

    public static int sum(int[] x){
        // Todo liida kokku kõik numbrid massivis x

        int asum = x[0];
        for (int i = 1; i < x.length; i++) {
            asum = asum + x[i];
        }
        return asum;
    }

    public static int factorial(int x) {
        // TODO tagasta x faktoriaal.
        // Näiteks
        // x = 5
        // return 4*3*2*1 = 24
        int fac = 1;
        for (int i = 2; i < x; i++) {
            fac = fac * i;
        }
        return fac;
    }

    public static int[] sort(int[] a) {
        // TODO sorteeri massiiv suuruse järgi
        // Näiteks {2, 6, 8, 1}
        // Väljund {1, 2, 6, 8}
        System.out.println(Arrays.toString(a));
        // Outer loop changes the number of comparable cells
        for (int i = 0; i < a.length; i++){
            int min = a[i];
            int index = i;
            // Inner loop goes through the current array (array is 1 shorter every outer loop)
            for (int j = i; j < a.length; j++){
                if(a[j] < min) {
                    min = a[j];
                    index = j;
//                    System.out.println(min);
//                    System.out.println(j);
                }
            }
            // Replacing the min and current first value with each other after every outer loop,
            int tmp = a[i];
            a[i] = min;
            a[index] = tmp;
        }
        System.out.println(Arrays.toString(a));
        return a;
    }

    public static String reverseString(String a) {
        // TODO tagasta string tagurpidi
        // Näiteks:
        // a = "Test";
        // return tseT";
        System.out.println(a);
        // Use StringBuilder when manipulating Strings
        StringBuilder word = new StringBuilder();
//        for (int i = ((a.length())-1); i == 0; i--) {
        for (int i = a.length()-1; i >= 0; i--) {
//            System.out.print(a.charAt(i));
//            String b = (a.substring(i-1, i));    //hea meetod mida teada Stringidega manipuleerimiseks!!!
//            word.append(a.charAt(i));
            word.append(a.substring(i, i+1));      //uskumatu aga substring() lubab v]tta viimase t'he out of bounds tingimustes
        }
        String reverse = word.toString();      //casting type StringBuilder to String
//        System.out.println(word);
//        System.out.println(reverse);
//        System.out.println(a.substring(1));

        return reverse;     //NB! main method prints the result
    }

    public static boolean isPrime(int x){
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
        for (int i = 2; i < x; i++){    //loop goes until the test number itself
            if (x % i == 0) {           //condition is that if there is no remaining
                return false;
            }
        }
        return true;
    }

    //Test exercise1:
    // URL result: /company/5/employee/8/contract/5

//    @GetMapping("company/{id1}/employee/{id2}/contract/{id3}")
//    public int exercise1(@PathParam)

    //2020-11-09 TEST

    public static String igaTeine(String string1) {
        String string2 = "";
        for (int i = 0; i <= string1.length(); i++) {
            if (i % 2 == 0) {
                string2 += string1.substring(i, i+1);
            }
        }
        System.out.println(string2);
        return string2;
    }



}
