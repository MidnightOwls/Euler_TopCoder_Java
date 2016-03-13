package Test;

/**
 * Created by edwardwang on 3/13/16.
 */
public class Main {
    public static void main(String[] args){
        Deck deck = new Deck();
        Card card;
        int diam = 0;
        int heart = 0;
        int clover = 0;
        int spade = 0;
        int cardCount=0;
        while(diam==0 || heart==0 || clover==0 || spade==0){
            card = deck.getCard();
            if(card.getSuit() == "Diamond" && diam==0){
                diam = 1;
                card.printValue();
            }else if(card.getSuit() == "Heart" && heart==0){
                heart = 1;
                card.printValue();
            }else if(card.getSuit() == "Clover" && clover==0){
                clover = 1;
                card.printValue();
            }else if(card.getSuit() == "Spade" && spade==0){
                spade = 1;
                card.printValue();
            }
            cardCount++;
        }
        System.out.println("Total cards: "+cardCount);

    }

}
