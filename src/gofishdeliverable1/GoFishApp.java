package gofishdeliverable1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects and then asks the user to pick a card and
 * searches the array of cards for the match to the user's card. To be used as starting code in ICE 1
 *
 * @author Nick De Luca
 * @date june 14th 2020
 */
public class GoFishApp {

    public static void main(String[] args) {
        
        Card[] magicHand = new Card[7];
   
        Random random=new Random();
        
        for (int i = 0; i < magicHand.length; i++) {
            
            //c.setValue(insert call to random number generator here)
            //c.setSuit(Card.SUITS[insert call to random number between 0-3 here])
            int value=random.nextInt(13)+1;
            String suit=Card.SUITS[random.nextInt(3)];
            Card c = new Card(value,suit);
            magicHand[i]=c;
        }
       
        for(Card card:magicHand){
            System.out.println(card.getValue()+card.getSuit());
        }
        
        //insert code to ask the user for Card value and suit, create their card
        Card guessCard = pickCard();
        //Card guessCard = luckyCard;
        
        // and search magicHand here
        boolean win = false;
        for(Card card:magicHand){
            if(guessCard.getValue()==card.getValue()&& guessCard.getSuit().equalsIgnoreCase(card.getSuit())){
                win = true;
            }
        }
        //Then report the result here
        if(win){
            System.out.println("You guessed correct!");
        }else{
              System.out.println("You guessed Wrong :(");
        }

    }
    
    public static Card pickCard(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Pick a card, any card!");
        Card guessCard = new Card();
        String suit;
        int value;
        
        try {
            System.out.print("Enter Suit: ");
            suit = sc.nextLine().trim();
            guessCard.setSuit(suit);
            
            System.out.print("Enter value: ");
            value = sc.nextInt();
            if((value<0||value>13)){
                System.out.println("Value must be greater than 0 and less than 14");
                guessCard = pickCard();
            }
            guessCard.setValue(value);
        } catch (InputMismatchException e) {
            System.out.println("The value entered was not a number");
            guessCard = pickCard();
        }
        return guessCard;
    }

}
