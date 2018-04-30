package com.company.Logic;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Nadya's shitty program!\n");
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println(deck);

        BlackJackLogic game =new BlackJackLogic();

        int random1=game.randomCardValue(11,2);
        int random2=game.randomCardValue(11,2);
        game.playerTotal=random1+random2;

        if (game.playerTotal>21) {
            System.out.println("Your total score is over 21. YOU ARE LOOSER!!");
            return;
        }
        System.out.println("You get a " + random1+ " and a "+random2);
        System.out.println("You total is "+game.playerTotal+"\n");

        int random3=game.randomCardValue(11,2);
        int random4=game.randomCardValue(11,2);
        game.dealerTotal=random3+random4;
        System.out.println("The dealer has a " +random3+" and a hidden card. His total is hidden\n" );
        System.out.println("Would you like to \"hit\" or \"stay\"?");
        action(choice(),game,random4);

    }

    public static String choice(){

        Scanner scanner = new Scanner(System.in);
        String myString = scanner.nextLine();
        //scanner.close();
        return myString;
    }

    public static void action(String input,BlackJackLogic game,int r4){

        switch (input){
            case "hit":

                int random=game.randomCardValue(11,2);
                System.out.println("You drew a "+random);
                game.playerTotal=game.playerTotal+random;
                if (game.playerTotal>21) {
                  System.out.println("Your total score is over 21. YOU ARE LOOSER!!");
                    break;
                }
                System.out.println("Your total is "+game.playerTotal);
                System.out.println("Would you like to \"hit\" or \"stay\"?");
                action(choice(),game,r4);
                break;
            case "stay":

                System.out.println("Ok, dealer's turn.\n");
                System.out.println("His hidden card was a " +r4+". His total was "+ game.dealerTotal+".");
                if(game.dealerTotal>21){
                    System.out.println("Delear got over 21. YOU WIN!!");
                    break;
                }
                dealerAction(game);
                break;

            default:
                System.out.println("Invalid input. Please type \"hit\" or \"stay\"");
                action(choice(),game,r4);
                break;

        }

    }

    public static void dealerAction(BlackJackLogic game){

        String input=game.randomDealerAction();

        switch (input){
            case "hit":
                int newValue=game.randomCardValue(11,2);
                game.dealerTotal=game.dealerTotal+newValue;
                System.out.println("Dealer chooses to hit. \nHe draws a " +newValue+ ". His total is "+ game.dealerTotal+"\n");
                if (game.dealerTotal>21){
                    System.out.println("Delear got over 21. YOU WIN!!");
                    break;
                }
                dealerAction(game);
                break;
            case "stay":
                System.out.println("Dealer stays.\n");
                System.out.println("Dealer total is  " +game.dealerTotal+". Your total is  "+ game.playerTotal+".");
                if (game.playerTotal>game.dealerTotal) System.out.println("YOU WIN!!");
                if (game.playerTotal<game.dealerTotal) System.out.println("YOU ARE LOOSER!!");
                if (game.playerTotal==game.dealerTotal) System.out.println("TIE!");
                break;

        }


    }
}
