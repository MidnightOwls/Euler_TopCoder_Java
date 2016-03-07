package Euler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edwardwang on 3/4/16.
 *
 * website: https://projecteuler.net/problem=548
 *
 * A gozinta chain for n is a sequence {1,a,b,...,n} where each element properly divides the next.
 There are eight gozinta chains for 12:
 {1,12} ,{1,2,12}, {1,2,4,12}, {1,2,6,12}, {1,3,12}, {1,3,6,12}, {1,4,12} and {1,6,12}.
 Let g(n) be the number of gozinta chains for n, so g(12)=8.
 g(48)=48 and g(120)=132.

 Find the sum of the numbers n not exceeding 1016 for which g(n)=n.
 */
public class GozintaChains {
    private int gozintaNum;
    private List<Integer> links; //links will be each possible item that divides even into gozintaNum
    private List<Integer> chain;
    private List<Integer> tempChain;
    private List<List<Integer>> listOfGozintaChains;

    public GozintaChains(int gozintaNum){
        this.gozintaNum = gozintaNum;
        links = new ArrayList<Integer>();
        chain = new ArrayList<Integer>();
        listOfGozintaChains = new ArrayList<List<Integer>>();
    }

    /**
     * Make sure the input number is a valid input. In the cases of 0 or 1, this method will handle the special case.
     */
    private boolean isGozintaNumValid(){
        if(gozintaNum<=0){
            System.out.println("Cannot input negative numbers or 0");
            return false;
        }else if(gozintaNum==1){
            gozintaNum = 1;
            System.out.println("Gozinta Sum: "+gozintaNum);
            return false;
        }
        return true;
    }

    public void printGozintaChains(){
        if(isGozintaNumValid()){
            getAllLinks();
            findAllChainCombos();
            for(int i=0;i<listOfGozintaChains.size();i++){
                print(listOfGozintaChains.get(i));
            }
        }
    }

    public int getGozintalChainSize(){
        return listOfGozintaChains.size();
    }

    private void getAllLinks(){
        for(int i=1;i<=gozintaNum;i++){
            if(gozintaNum%i==0){
                links.add(i);
            }
        }
    }

    private void findAllChainCombos(){
        for(int i=1;i<links.size();i++){
            chain = new ArrayList<Integer>();
            chain.add(1);
            if((i%chain.get(i-1)==0)){

            }
        }


        for(int i=0;i<links.size()-1;i++){
            for(int j=i+1;j<links.size();j++){
                /**
                 * every time the chain is enlarged, its combination will be recorded down in format
                 * 1, x, gozintaNum
                 * 1, x, x+y, gozintaNum
                 * 1, x, x+y, x+y+z, gozintaNum
                 *
                 * need to exhaust all possible choices
                 * recursive methods!
                 * once the alg reaches end of poss chains for a number i.e. 1 2 4, it can go through 1 2 6 sequence!
                 */
                chain = new ArrayList<Integer>();






                //handle situation where chain does not start with 1
                if(links.get(i) != links.get(0)){
                    chain.add(links.get(0));
                }
                    chain.add(links.get(i));
                //Make sure j%i==0
                if((links.get(j)%links.get(i)==0) && (links.get(j)%chain.get(chain.size()-1)== 0)) {
                    System.out.println(links.get(i) + " " + links.get(j));
                    //handle case when chain does not end in 12
                    if(links.get(j)!=gozintaNum){
                        chain.add(links.get(j));
                        chain.add(gozintaNum);
                    }else if(links.get(j)==gozintaNum && chain.size()==1){
                        chain.add(gozintaNum);
                    }else{
                        continue;
                    }
                    
                    addNewChainPoss(chain);
                }
            }
        }
    }

    /**
     * Add first chain: (1,gozintalNumber)
     */
    private void addFirstChain(){
        chain.add(1);
        chain.add(gozintaNum);
        listOfGozintaChains.add(chain);
    }

    /**
     * When adding adding possible chains, add the gozintaNum to the end
     * of each link, because it has already been established that all links
     * divide into gozintaNum == 0
     * @param chain
     */
    private void addNewChainPoss(List<Integer> chain){
        tempChain = new ArrayList<Integer>();
        tempChain.addAll(chain);
        listOfGozintaChains.add(tempChain);
    }

    private void print(List<Integer> list){
        System.out.print("Chain: ");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }

}
