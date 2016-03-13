package Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by edwardwang on 3/13/16.
 */
public class Deck {

    private ArrayList<Card> deck;
    private String[] suits = {"Diamond","Heart","Clover","Spade"};
    private String[] values = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};

    public Deck(){
        setupDeck();
        shuffle();
    }

    /**
     * Setup values of all the cards into the deck arraylist.
     */
    private void setupDeck(){
        Card card;
        deck = new ArrayList<Card>();
        for(int i=0;i<suits.length;i++){
            for(int j=0;j<values.length;j++){
                card = new Card(suits[i],values[j]);
                deck.add(card);
            }
        }
    }

    /**
     * Create a new arrayList, where we add random cards from deck to the new array. Once the shuffle is finished,
     * se the deck reference to the new ArrayList.
     */
    private void shuffle(){
        ArrayList<Card> temp = new ArrayList<Card>();
        int card;
        while(!deck.isEmpty()){
            card = (int)(Math.random() * deck.size());
            temp.add(deck.get(card));
            deck.remove(card);
        }
        deck = temp;
    }

    /**
     * Grab a random card from the given deck and shuffles when the card is grabbed.
     * @return Card
     */
    public Card getCard(){
        Card card = deck.get((int)(Math.random()*52));
        shuffle();
        return card;
    }
}
