public class Card {
    private String name;
    private int value;
    private String suit;
    private int suitRank;
    private int realValue;

    public Card(String name, int value, String suit, int suitRank, int realValue){
        this.name = name;
        this.value = value;
        this.suit = suit;
        this.suitRank = suitRank;
        this.realValue = realValue;

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

    public int getSuitRank() {
        return this.suitRank;
    }

    public void setSuitRank(int suitRank) {
        this.suitRank = suitRank;
    }

    public int getRealValue() {
        return this.realValue;
    }

    public void setRealValue(int realValue) {
        this.realValue = realValue;
    }

    public String toString() {
        return "<" + this.suit + " " +  this.name + ">";
    }




    



}


