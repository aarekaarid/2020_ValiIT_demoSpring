package com.example.demoSpring.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.Scanner;

// Enne kui seda tegema hakkad tee ära Lesson 2 (välja arvatud ülesanded 6, 8, 9)
@RestController
public class Lesson3Hard {
    public static void main(String[] args) {

    }
    @GetMapping("evenfibo")
    public static int evenFibonacci(@RequestParam("nr") int n){
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        // copied fibonacci
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
        // Exercise begins here
        int sum = 0;
        for (int j = 0; j < a.length; j++){
            if (a[j] % 2 == 0){
                sum += a[j];
            }
        }

        return sum;
    }

    public static void randomGame(){
        // TODO kirjuta mäng mis võtab suvalise numbri 0-100, mille kasutaja peab ära arvama
        // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
        // ja kasutaja peab saama uuesti arvata
        // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
        Random random = new Random();
        int i = random.nextInt(100);
        System.out.println(i);

        Scanner scanner = new Scanner(System.in);
        int j = scanner.nextInt();

        if (i < j){
            System.out.println("Suurem!!!");
        } else if (i > j){
            System.out.println("V@iksem");
        }
    }

    //    Scanner scanner = new Scanner(System.in);
//        System.out.println("Palun numbreid " + a.length + "tükki");
//                for (int i = 0; i < a.length; i++) {
//        int j = scanner.nextInt();
//        a[i] = j;
//        }


    public static String morseCode(String text){
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja -
        return "";
    }
}


