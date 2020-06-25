/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gofishdeliverable1;

/**
 * This class <enter description>
 * @author Nick De Luca
 */
public class Deck extends Hand{

    public Deck() {
    }

    public Deck(int handSize) {
        super(handSize);
    }

    //possible methods to add
    //shuffle
    //deal 

    @Override
    public String showHand() {
        String showHand = "";
        this.sortHand();
        int lineSize = 12;
        for (int i = 0; i < this.getHand().size(); i++) {
            
            showHand += this.getHand().get(i).toString() + ", ";
            if((i+1) == lineSize ){
                showHand += "\n";
                lineSize += 12;
            }
        }
        return showHand;
       }
    
    public boolean checkHand(Card card){
        for (Card c : this.getHand()) {
           
            if(c.getSuit().equalsIgnoreCase(card.getSuit()) && c.getValue()==card.getValue()){
                this.getHand().remove(c);
                return true;
            }
        }
        return false;
    }
    
}
