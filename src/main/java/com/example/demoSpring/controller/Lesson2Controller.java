package com.example.demoSpring.controller;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

//@RequestMapping("Lesson2")      //localhost:8080/Lesson2/...
@RestController     //this class says that go and scan the file structure
public class Lesson2Controller {

    //  HTTP Exercise 'fibonacci()'
    @GetMapping("fibonacci")
    public String Fibo(@RequestParam("nr") int nr){
        return Lesson2Controller.fibonacci(nr);
    }

    //  HTTP Exercise 'exercise5()'
    @GetMapping("exercise5")
    public int Exec5(@RequestParam("nr") int nr){
        return Lesson2Controller.exercise5(nr);
    }

    //  HTTP Exercise 'exercise7()'
    @GetMapping("exercise7")
    public BigDecimal Exec7() { return Lesson2Controller.exercise7();}

    public static void exercise1() {
        // TODO loo 10 elemendile täisarvude massiv
        int[] a = new int [3];

        // TODO loe sisse konsoolist 10 täisarvu
        Scanner scanner = new Scanner(System.in);
        System.out.println("Palun numbreid " + a.length + "tükki");
        for (int i = 0; i < a.length; i++) {
            int j = scanner.nextInt();
            a[i] = j;
        }
        // Numbrid mis sisestati:
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
        // Mugavusfunktsioon printimaks array välja
        System.out.println(Arrays.toString(a));

        // TODO trüki arvud välja vastupidises järjekorras
        for (int i = ((a.length)-1); i >= 0; i--){
            System.out.println(a[i]);
        }
    }



    public static void exercise2(int x) {
        // TODO prindi välja x esimest paaris arvu
        for (int i = 1; i <= x; i++) {
            System.out.println(i*2);
        }
        // Näide:
        // Sisend 5
        // Väljund 2 4 6 8 10
    }

    // vt. mobla pics
    public static void exercise3(int x, int y) {
        // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge

        for (int i = 1; i <= x; i++){
            System.out.println();           //see lisab reavahetuse
            for (int j = 1; j <= y; j++){
                System.out.print(j*i +" "); //i on rea kordaja
            }
        }

        // TODO näiteks x = 3 y = 3
        // TODO väljund
        // 1 2 3
        // 2 4 6
        // 3 6 9
        // NB! trüki sama rida y korda
    }

    public static String fibonacci(int n) {
        // TODO
        // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
        // 0, 1, 1, 2, 3, 5, 8, 13, 21
        // Tagasta fibonacci jada n element
        int a[] = new int [n];
        if (n <=2) {
            for (int i = 0; i < a.length; i++) {
                a[i] = i;
            }
        } else {
            a[0] = 0;
            a[1] = 1;
            for (int i = 2; i < a.length; i++) {
                a[i] = a[i - 1] + a[i - 2];
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println((i+1) + ": " + a[i] + " ");
        }
        System.out.println("Fibolemenet nr. " + n + ": " + a[n-1]);
        return "Fibolemenet nr. " + n + ": " + a[n-1];
    }


    public static void interviewtask() {
        // TODO
        // vaheta a ja b vaartused ilma lisa muutujat deklareemitata;
        // vihje: kasuta liitmisi lahutamisi
        int a = 6;
        int b = 9;
        b = a+b-b;
        a = a + b;

        System.out.println("a: " + a + "/ b: " + b);
    }

    public static int exercise5(int n) {
        // https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=36
        //todo1 tee alamfunktsioon mis leiab 3n+1 sequenci pikkuse
        // kui on paaris /2 kui on paaritu *3+1
        //todo2 tee tsükkel mis leiab i -> j kõige suurema tsükkli pikkuse

        if (n <= 1) {
            return n;
        } else {
            int counter = 1;
            while (n > 1) {
                if(n % 2 == 0){
                    n = n / 2;
                } else {
                    n = 3 * n + 1;
                }
                counter++;
            }
            System.out.println(counter);
            return counter;
        }
    }





    public static void exercise6() {
        /*
            Kirjutada Java programm, mis loeb failist visits.txt sisse looduspargi külastajad erinevatel jaanuari päevadel ning
            a) sorteerib külastuspäevad külastajate arvu järgi kasvavalt ning prindib tulemuse konsoolile;
            b) prindib konsoolile päeva, mil külastajaid oli kõige rohkem.
            Faili asukoht tuleb programmile ette anda käsurea parameetrina.
         */

        String a = "2018-01-13, 436";   // seda saab splittida
        String[] b = a.split(", ");  // teeb kaheks ',' kohalt
        System.out.println(b[0]);
        System.out.println(b[1].trim());

    }

    public static BigDecimal exercise7() {
        // TODO arvuta kasutades BigDecimali 1.89 * ((394486820340 / 15 ) - 4 )
        BigDecimal a = new BigDecimal("1.89");
        BigDecimal b = new BigDecimal("394486820345");
        BigDecimal c = new BigDecimal("15");
        BigDecimal d = new BigDecimal("4");

        System.out.println(b.divide(c, 4, RoundingMode.HALF_UP));

        BigDecimal y = b.divide(c, 2, RoundingMode.CEILING);
        System.out.println(y);
        return y;
    }


    public static void exercise8() {
        /*
        Failis nums.txt on üksteise all 150 60-kohalist numbrit.

        Kirjuta programm, mis loeks antud numbrid failist sisse ja liidaks need arvud kokku ning kuvaks ekraanil summa.
        Faili nimi tuleb programmile ette anda käsurea parameetrina.

        VASTUS:
        Õige summa: 77378062799264987173249634924670947389130820063105651135266574
         */
    }

    public static void exercise9() {
        /* TODO
        Sama mis eelmises ülesandes aga ära kasuta BigInt ega BigDecimal klassi
         */
    }

}
