public class Card {
    private String name;
    private int value;
    private String suit;

    public Card(String name, int value, String suit){
        this.name = name;
        this.value = value;
        this.suit = suit;

    }

    public String getCardName() {
        return this.name;
    }

    public void setCardName(String name) {
        this.name = name;
    }

    public int getCardValue() {
        return this.value;
    }

    public void setCardValue(int value) {
        this.value = value;
    }

    public String getCardSuit() {
        return this.suit;
    }

    public void setCardSuit(String suit) {
        this.suit = suit;
    }

    public String toString() {
        return  "<" + this.suit + " " +  this.name +">";

    }

    public static void main(String[] args) {
        Card card1 = new Card("Ace", 1, "Spade");
        System.out.println(card1);

    }

    



}


