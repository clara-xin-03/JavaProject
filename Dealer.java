import java.util.*;
public class Dealer extends Player{
    private Deck deck;

    public Dealer(String userName, String userPassword, int playerChip) {
        super(userName, userPassword, playerChip);
        this.deck = new Deck();

    }

    public void shuffle() {
        System.out.println("Game starts - Dealer shuffles deck. ");
        deck.shuffleCard();
    }

    public void dealCard(Player player){
        Card card = deck.removeCardFromDeck();
        player.addCardtoHand(card);
    }

    public void dealCardtoAll(Player player, Dealer dealer) {
        dealCard(player);
        dealCard(dealer);

    }

    public void checkWinner(Player player, Dealer dealer) {
        if(player.getTotalValue() > dealer.getTotalValue()) {
            System.out.println(player.getUserName() + " Wins.");
        }else if(player.getTotalValue() == dealer.getTotalValue()) {
            System.out.println("Ties. ");
        }else if(player.getTotalValue() < dealer.getTotalValue()) {
            System.out.println(player.getUserName() + " Loses. ");
        }
    }


    public void resetDeck(Dealer dealer, Player player) {
        deck.appendCard(dealer.cardsOnHand);
        deck.appendCard(player.cardsOnHand);
        dealer.removeCardFromHand();
        player.removeCardFromHand();
        deck.shuffleCard();
        System.out.println("Dealer shuffles used cards and place behind the deck.");
        
    }








}