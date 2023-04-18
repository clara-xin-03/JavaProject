import java.util.*;

public class Deck {
    private ArrayList<Card> cards;



    public Deck() {
        cards = new ArrayList<Card>();
        String[] suits= {"Diamond", "Club", "Heart", "Spade"};
        for(int i = 0; i < suits.length; i++) {

            Card card1 = new Card("Ace", 1, suits[i]);
            cards.add(card1);
            for(int j = 2; j <= 10 ; j++) {
                Card card2 = new Card(""+j, j, suits[i]);
                cards.add(card2);
                
            }
            Card card3 = new Card("Jack", 10, suits[i]);
            cards.add(card3);
            Card card4 = new Card("Queen", 10, suits[i]);
            cards.add(card4);
            Card card5 = new Card("King", 10, suits[i]);
            cards.add(card5);
           

        }
    }

    public void showCards() {
        for(int i = 0; i < cards.size(); i++) {
            System.out.println(cards.get(i));
        }

    }

    public static void main(String[] args) {
        Deck d = new Deck();
        d.showCards();
    }

    
    
    
}
