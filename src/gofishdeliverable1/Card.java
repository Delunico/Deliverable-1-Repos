package gofishdeliverable1;

public class Card {

    private Rank value;
    private Suit suit;
    
    //public static final String[]SUITS={"Hearts","Diamonds","Spades","Clubs"};

    public Card() {
    }
    
    public Card(Rank value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }
    
    public Rank getValue() {
        return this.value;
    }

    /**
     * 
     * @param value
     */
    public void setValue(Rank value) {
        this.value = value;
    }
    public Suit getSuit() {
        return this.suit;
    }

    /**
     * 
     * @param suit
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return value +" " + suit;
    }

}