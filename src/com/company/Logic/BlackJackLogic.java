package com.company.Logic;


import java.util.Random;

public class BlackJackLogic {
    public int playerTotal=0;
    public int dealerTotal=0;

    public int randomCardValue(int max,int min)

    {

        Random rand = new Random();
        return  rand.nextInt((max - min) + 1) + min;

    }

    public String randomDealerAction()

    {

        Random rand = new Random();
        String [] arr = {"hit","stay"};
        int select = rand.nextInt(arr.length);
        return arr[select];

    }
}
