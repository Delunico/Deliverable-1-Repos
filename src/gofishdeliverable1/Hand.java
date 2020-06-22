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
public class Hand {

    private ArrayList<Card> hand = new ArrayList();
    private int handSize;

    public Hand() {
    }
    
    public Hand(int handSize) {
        setHandSize(handSize);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
    
    public void setHandSize(int handSize){
        if(handSize>0){
            this.handSize = handSize;
        }else{
            throw new IllegalArgumentException("Hand Size must be positive");
        }
    }
    
    public int getHandSize(){
        return handSize;
    }
    //returns true or false if remove was successful(i.e. if the player has the card or not)
    public boolean removeFromHand(Card card){
        for (Card c : hand) {
           
            if(c.getSuit().equalsIgnoreCase(card.getSuit()) && c.getValue()==card.getValue()){
                hand.remove(c);
                return true;
            }
        }
        return false;
    }
    //adds a card to the player's hand instance var object
    //returns true if you can add a card
    //returns false if the hand is full
    //u can change the return to void if needed, i just thought it might be useful.
    public boolean addToHand(Card card){
        if(hand.size() <= handSize){
            hand.add(card);
        }else{
            return false;
        }
        return true;
        
    }

    @Override
    public String toString() {
        return "Hand: " + "hand=" + hand;
    }
    
    
}
