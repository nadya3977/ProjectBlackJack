package com.company.Logic;



import java.util.*;

public class Deck {

    //Create a List of cards
//    List<Card> deckList = ... //A method to create your 52 cards

    // Collections.shuffle(deckList);
//    Deque<Card> deck = new ArrayDeque<Card>(deckList);





    /*Size of the deck which can handle cards*/
    private int size;

    /*Collections of cards*/
    private List<Card> cards;


    /*Remaining number of cards in the deck*/
    private int currentCount;

    private Suit suits[];

    private Value values[];

    public Deck(){
        size=52;
        currentCount=0;
        suits=Suit.values();
        values=Value.values();

        cards = new ArrayList<Card>();
        for(int i =0 ; i<suits.length;i++){
            for(int j =0 ; j<values.length;j++){
                cards.add(new Card(suits[i],values[j]));
            }

        }
    }

    public void shuffle(){

        Collections.shuffle(cards);
        while (!cards.isEmpty()){
            System.out.println(cards.get(0));
        }

    }


    /*This is to represents the String representation of the current cards inthe deck.*/
    public String toString(){

        StringBuilder sb=new StringBuilder();

        for(int i=0;i < currentCount;i++){
            sb.append(cards.get(i));
            sb.append(" ");
        }

        return sb.toString();
    }

    /*  Sorting the cards based on the suit and then numbers.
        This sorting is using Bucket Sort to sort the cards runtime= O(n) space=O(n);*/
//    public void sort(){
//
//        Card bucketCards[][]= new Card[suits.length][values.length];
//
//        for(int i=0;i<currentCount;i++){
//            bucketCards[cards[i].getSuit().ordinal()][cards[i].getValue().ordinal()]=cards[i];
//        }
//
//        int pointer=0;
//
//        for(int i=0;i<suits.length;i++){
//            for(int j=0;j<values.length;j++){
//                if(bucketCards[i][j]!=null)
//                    cards[pointer++]=bucketCards[i][j];
//            }
//        }
//
//
//    }

    /*This will reset the deck. i.e it will put back all the cards in the deck if it has been dealt.*/
    public void resetdesk(){
        currentCount=52;
    }

    /*Printing the stack of cards in format*/
    public void printStack(){
        int cardPointer=0;
        for(int i=0;i<suits.length;i++){

            for(int j=0;j<values.length;j++){
                System.out.print(cards.get(cardPointer++)+" ");
            }

            System.out.println("\n");
        }

    }

    /*Get size of the deck*/
    public int getSize() {
        return size;
    }

    /*This represents the suit of the card*/
    private enum Suit{
        CLUB,DIAMOND,SPADE,HEART
    }

    /* This represents the number of the card*/
    private enum Value{
        ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING
    }

    /* This class represents the card with specific suit and value.
     * Cannot change the value once instansiated */
    private class Card{

        private final Suit suit;

        private final Value value;

        public Card(Suit suit, Value value){
            this.suit=suit;
            this.value=value;
        }


        public Suit getSuit() {
            return suit;
        }

        public Value getValue() {
            return value;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return suit+"-"+value;
        }
    }
}