package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        /*
        System.out.println("How far to count?");
        Scanner input = new Scanner(System.in);
        int HowFar= input.nextInt();
        while (HowFar < 1){
            System.out.println("Not a valid number, please try again.");
            HowFar= input.nextInt();
        }
        for (int MyLoop = 1; MyLoop == HowFar; MyLoop++) {
            if ((MyLoop%3 ==0 )||(MyLoop%5 == 0) ){
                System.out.println("FizzBuzz");
            }
            else {
                if (MyLoop % 3 == 0) {
                    System.out.println("Fizz");
                } else {
                    if (MyLoop % 5 == 0) {
                        System.out.println("Buzz");
                    }
                }
            }
        }

         */
        Scanner input = new Scanner(System.in);
        System.out.println("player 1 name");
        String player1Name = input.next();
        System.out.println("player 2 name");
        String player2Name = input.next();
        ArrayList<String> dominoSet = new ArrayList<>();
        dominoSet = CreateDominoes();
        for (int i = 0; i < dominoSet.size(); i++) {
            System.out.print(dominoSet.get(i));
        }
        // q13
        ArrayList<String> player1set = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Random random = new Random();
            int randomNum = random.nextInt(dominoSet.size());
            player1set.add(dominoSet.get(randomNum));
            dominoSet.remove(randomNum);
        }
        System.out.println("");
        System.out.println("player 1 hand");
        for (int i = 0; i < player1set.size(); i++) {
            System.out.print(player1set.get(i));
        }

        ArrayList<String> player2set = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Random random = new Random();
            int randomNum = random.nextInt(dominoSet.size());
            player2set.add(dominoSet.get(randomNum));
            dominoSet.remove(randomNum);
        }
        System.out.println("");
        System.out.println("player 2 hand");
        for (int i = 0; i < player2set.size(); i++) {
            System.out.print(player2set.get(i));
        }
        System.out.println("");
        System.out.println("bone yard");

        for (int i = 0; i < dominoSet.size(); i++) {
            System.out.print(dominoSet.get(i));
        }

        // q14
        char HighestDouble = 7;
        String domino;
        int playerToGoFirst =0;
        while(true){
            for (int i = 0; i < player1set.size(); i++) {
                domino = player1set.get(i);
                if (domino.charAt(1)== (domino.charAt(3))){
                    if (HighestDouble<domino.charAt(1)) {
                        HighestDouble = domino.charAt(1);
                        playerToGoFirst = 1;
                    }
                }
            }
            for (int i = 0; i < player2set.size(); i++) {
                domino = player2set.get(i);
                if (domino.charAt(1)== (domino.charAt(3))){
                    if (HighestDouble<domino.charAt(1)) {
                        HighestDouble = domino.charAt(1);
                        playerToGoFirst = 2;
                    }
                }
            }

            if(HighestDouble != 7){
                if (playerToGoFirst == 1) {
                    System.out.println("it is now " + player1Name + " turn");
                }
                if (playerToGoFirst == 2) {
                    System.out.println("it is now " + player2Name + " turn");
                }
                break;
            }
            else{
                Random random = new Random();
                int randomNum = random.nextInt(dominoSet.size());
                player1set.add(dominoSet.get(randomNum));
                dominoSet.remove(randomNum);
                randomNum = random.nextInt(dominoSet.size());
                player2set.add(dominoSet.get(randomNum));
                dominoSet.remove(randomNum);
            }
        }

    }

    public static ArrayList<String> CreateDominoes() {
        ArrayList<String> dominoSet = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < i+1; j++) {
                String domino = "|" + i + ":" + j + "|";
                dominoSet.add(domino);

            }

        }
        return dominoSet;
    }



}
