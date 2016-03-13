package Euler;

/**
 * Created by edwardwang on 3/4/16.
 */
public class Euler {
    static int testNumber = 12;
    public static void main(String[] args){
        GozintaChains gozintaChains = new GozintaChains(testNumber);
        gozintaChains.printGozintaChains();
        System.out.println("Size of gozintal chain: "+gozintaChains.getGozintaChainSize());
    }
}
