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
public class Deck extends Hand{

    public Deck() {
    }

    public Deck(int handSize) {
        super(handSize);
    }

    //possible methods to add
    //shuffle
    //deal 
    
    public void buildDeck() {
        super.setHandSizeLimit(52);
        ArrayList<Card> deck = new ArrayList();
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                deck.add(new Card(r, s));
            }
        }
        this.setHand(deck);
    }
    
    public void shuffle() {
            
        Card card = this.getHand().get(0);
        for (int i = 0; i < this.getHand().size(); i++) {

            for (int j = 1; j < this.getHand().size(); j++) {
                int x = (int)(Math.random() * i);
                    card = this.getHand().get(j);
                    this.getHand().remove(j);
                    this.getHand().add(x,card);
            }
        }
    }
    
    //returns the first card in the list and removes it from the deck
    public Card drawCard() {
        Card draw = this.getHand().get(0);
        this.removeFromHand(this.getHand().get(0));
        return draw;
    }

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
           
            if(c.getSuit().getFace().equalsIgnoreCase(card.getSuit().getFace()) 
                    && c.getValue().getNum() == card.getValue().getNum()){
                this.getHand().remove(c);
                return true;
            }
        }
        return false;
    }
    
    
    //toString used mostly for testing funcionality
    @Override
    public String toString() {
        String s = "";
        for (Card c : this.getHand()) {
            s += c.getValue().getName() + " of " + c.getSuit().getFace() + "\n";
        }
        return s;
    }
    
}
