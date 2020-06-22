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
       
        System.out.println();
        Hand hand = new Hand(5);
        Random random=new Random();
        
        //temporary population of hand (david u can implement later, sometimes it adds identical cards btw)
        for (int i = 0; i < hand.getHandSize(); i++) { //handSize gives 5 cards, the gofish handsize(very temporary-just for testing)
     
            int value=random.nextInt(13)+1;
            String suit=Card.SUITS[random.nextInt(3)];
            Card c = new Card(value,suit);
            hand.addToHand(c);
           
        }
        //make a player
        Player p1 = new Player("Nick",hand);
        //print the player info completely
        System.out.println(p1);
        
        
        //guessing functionality from class exercise
        Card guessCard = pickCard();
        
        
        //check for win
        boolean win = false;
        
        
        if(p1.checkHand(guessCard)){
            win = true;
            //returns true and automatically removes the given card
        }
        
        /*
         if(p1.addToHand(guessCard)){
            //successfully added a card to the hand
        }else{
            //hand is already full because 5 card limit for gofish
        }
        */
        
        System.out.println(p1);
        //Report the results here
        if(win){
            System.out.println("You guessed correct!");
        }else{
              System.out.println("You guessed Wrong :(");
        }

    }
    //pick card method that gets user input, validating its value as a number
    //does not validate the suit
    //basic method for testing (David will add later)
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
