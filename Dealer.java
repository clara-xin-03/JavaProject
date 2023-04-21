
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
            player.addChip();
            System.out.println(player.getUserName()+ ", You have "+ player.getchip() + " chips.");
        }else if(player.getTotalValue() == dealer.getTotalValue()) {
            System.out.println("Ties. ");
        }else if(player.getTotalValue() < dealer.getTotalValue()) {
            System.out.println(player.getUserName() + " Loses. ");
        }
    }


    public void resetGame(Dealer dealer, Player player) {
        deck.appendCard(dealer.cardsOnHand);
        deck.appendCard(player.cardsOnHand);
        dealer.removeCardFromHand();
        player.removeCardFromHand();
        player.setChip(100);
        dealer.setChip(100);
        player.setTotalBetChip(0);
        deck.shuffleCard();
        System.out.println("Dealer shuffles used cards and place behind the deck.");
        
    }

    public String checkCardValue(Dealer dealer, Player player) {
        String turn = "dealer";
        int dealerCardRealValue = dealer.cardsOnHand.get(dealer.cardsOnHand.size()-1).getRealValue();
        int playerCardRealValue = player.cardsOnHand.get(player.cardsOnHand.size()-1).getRealValue();
        int dealerSuitRank = dealer.cardsOnHand.get(dealer.cardsOnHand.size()-1).getSuitRank();
        int playerSuitRank = player.cardsOnHand.get(player.cardsOnHand.size()-1).getSuitRank();
        if(dealerCardRealValue > playerCardRealValue) {
            turn = "dealer";          
        }else if (dealerCardRealValue == playerCardRealValue) {
            if(dealerSuitRank > playerSuitRank) {
                turn = "dealer";
            }else if (dealerSuitRank < playerSuitRank){
                turn = "player";
            }
            

        }else if (dealerCardRealValue < playerCardRealValue) {
            turn = "player";
        }
        return turn;

    }








}