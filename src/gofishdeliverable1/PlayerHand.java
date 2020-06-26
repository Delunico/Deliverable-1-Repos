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
public class PlayerHand extends Hand {

    public PlayerHand() {
    }

    public PlayerHand(int handSize) {
        super(handSize);
    }

    public String hideHand(){
        String hideHand = " ";
        for (int i = 0; i < 30; i++) {
            hideHand += ""+"\n";
        }
        return hideHand;
    }   

    @Override
    public String showHand() {
        String showHand = "";
        for (int i = 0; i < this.getHand().size(); i++) {

           showHand += "["+this.getHand().get(i).toString()+"]" + ",   ";
         
       }
        return showHand;
    }

    @Override
    public String toString() {
        return "hand=" + this.getHand();
    }

    public boolean checkHand(Card card) {
        for (Card c : this.getHand()) {
           
            if(c.getValue().getNum()==card.getValue().getNum()){
                return true;
            }
        }
        return false;
       }
}
