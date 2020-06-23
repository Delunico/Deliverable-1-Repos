/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gofishdeliverable1;

import java.util.ArrayList;

/**
 * This class <enter description>
 * @author Nick De Luca
 */
public abstract class Hand{

    private ArrayList<Card> hand = new ArrayList();
    private int handSizeLimit;

    public Hand() {
    }
    
    public Hand(int handSizeLimit) {
        setHandSizeLimit(handSizeLimit);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
     public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    
    public ArrayList<Card> sortHand(){
        Card lowest = hand.get(0);
        for (int i = 0; i < hand.size(); i++) {
            for (int j = 1; j < hand.size(); j++) {
                if(hand.get(j).getValue() < hand.get(j-1).getValue()){
                    lowest = hand.get(j);
                    hand.remove(j);
                    hand.add(0,lowest);
                }
            }
        }
        return hand;
    }
    
    public void setHandSizeLimit(int handSizeLimit){
        if(handSizeLimit>0){
            this.handSizeLimit = handSizeLimit;
        }else{
            throw new IllegalArgumentException("Hand Size must be positive");
        }
    }
    
    public int getHandSizeLimit(){
        return handSizeLimit;
    }
    
    //returns true or false if remove was successful(j.e. if the player has the card or not)
   
    
    //adds a card to the player's hand instance var object
    //returns true if you can add a card
    //returns false if the hand is full
    //u can change the return to void if needed, j just thought it might be useful.
    public boolean addToHand(Card card){
        if(hand.size() < handSizeLimit){
            hand.add(card);
        }else{
            return false;
        }
        return true;
    }
    
     public boolean removeFromHand(Card card) {
        
        return hand.remove(card);
    }
    
    public abstract String showHand();
    
    public abstract boolean checkHand(Card card);
 
}
