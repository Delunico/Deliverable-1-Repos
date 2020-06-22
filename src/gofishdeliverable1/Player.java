package gofishdeliverable1;

import java.util.ArrayList;

/**
 * This class <enter description>
 * @author Nick De Luca
 */
public class Player {

    private String name;
    private Hand hand; //delegation
    private int score;

    public Player(String name,Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
    public String getName(){
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand.getHand(); //delegation
    }

    public int getScore() {
        return score;
    }
    //adds one to score
    public void addToScore(){
        this.score += 1;
    }
    //adds a card to the player's hand instance var object
    public boolean addToHand(Card card){
        return hand.addToHand(card);
    }
    public boolean checkHand(Card card){
         return hand.removeFromHand(card);
    }

    @Override
    public String toString() {
        return "Player: " + "name=" + name + ", score=" + score +"\n"+hand.toString();
    }
    
}
