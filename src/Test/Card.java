package Test;

/**
 * Created by edwardwang on 3/13/16.
 */
public class Card {
    private String suit;
    private String value;

    public Card(String suit, String value){
        this.suit = suit;
        this.value = value;
    }

    public String getSuit(){return suit;}

    public String getValue(){return value;}

    public void printValue(){
        System.out.println(getSuit() + " " + getValue());
    }
}
