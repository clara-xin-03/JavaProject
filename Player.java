import java.util.*;




public class Player extends User {
    private int playerChip;
    protected ArrayList<Card> cardsOnHand;

    public Player(String userName, String userPassword, int playerChip ) {
        super(userName, userPassword);
        this.playerChip = playerChip;
        cardsOnHand = new ArrayList<Card>();
    }

    public void showUserInfo() {
        System.out.println( this.getUserName()+ ", You have " + playerChip + " chips.");


    }

    public void addCardtoHand(Card card){
        cardsOnHand.add(card);

    }

    public void showCardsOnHand(boolean show) {

        System.out.println(getUserName());
        if(show) {
            for(Card card: cardsOnHand) {
                System.out.print(card + " ");   
            }
            System.out.println();
        }else if(!show) {
            System.out.print("<HIDDEN CARD> ");
            for (int i = 1; i < cardsOnHand.size(); i++) {
                System.out.print(cardsOnHand.get(i) + " ") ;
            }
            System.out.println();
            
        }
        

    }

    public int getTotalValue() {
        int total = 0;
        for(Card card: cardsOnHand) {
            total += card.getCardValue();
        }
        return total;

    }

    public void showTotalValue() {
        System.out.println("Value : " + getTotalValue());
    }

    
    public void removeCardFromHand() {
        cardsOnHand.removeAll(cardsOnHand);


    }


    public void bettingGame() {

    }



}