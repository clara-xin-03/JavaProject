import java.util.*;




public class Player extends User {
    private int playerChip;
    protected ArrayList<Card> cardsOnHand;
    private int totalBetChips = 0;

    public Player(String userName, String userPassword, int playerChip ) {
        super(userName, userPassword);
        this.playerChip = playerChip;
        cardsOnHand = new ArrayList<Card>();
    }

    public void deductChip(int chipAmount) {
        this.playerChip -= chipAmount;
    }

    public void addChipTotalBet(int chipAmount) {
        totalBetChips += chipAmount;
    }

    public int getTotalBetChip() {
        return totalBetChips;

    }

    public void setTotalBetChip(int chip) {
        totalBetChips = chip;

    }

    public int getchip() {
        return this.playerChip;

    }

    public void setChip(int playerChip) {
        this.playerChip = playerChip;

    }

    public void addChip() {
        this.playerChip  += totalBetChips;
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


    public boolean betting(Dealer dealer, Player player, int round) {
        boolean end = false;
        String checkTurn = dealer.checkCardValue(dealer, player);

        if(checkTurn == "player")  {
            boolean checkCall = true;
            if(round != 1) {
            checkCall = Keyboard.readQC("Do your want to[C]all or [Q]uit?: ");
            }
            

            if(checkCall) {
                int chipAmount = 0;
                while(true) {
                    chipAmount = Keyboard.readInt("Player call, state bet: ");
                    
                    if(player.getchip() < 10) {
                        System.out.println("Not enough chips.");
                        System.out.println(player.getUserName() + " Loses.");
                        return end = true;
                    }else if(chipAmount > player.getchip()) {
                        System.out.println("Not enough chips. Please enter again.");
                    }
                    else if(chipAmount < player.getchip()){
                        break;
                    }else{
                        break;
                    }

                }
                
                player.deductChip(chipAmount);
                addChipTotalBet(chipAmount);

                dealer.deductChip(chipAmount);
                addChipTotalBet(chipAmount);

                System.out.println(player.getUserName()+ ", You are left with "+ player.getchip()+ " chips. ");
                System.out.println("Bet On Table : " + getTotalBetChip());


            }else if(!checkCall) {
                System.out.println(player.getUserName() + " Loses.");
                return end = true;
                
            }
          

        }else if (checkTurn == "dealer"){
            int chipAmount = 10;
            dealer.deductChip(chipAmount);
            addChipTotalBet(chipAmount);

            System.out.println("Dealer call, state bet : " + chipAmount);
            boolean follow = Keyboard.readBoolean("Do you want to follow? [Y/N]");
            if(player.getchip() < 10) {
                System.out.println("Not enough chips.");
                System.out.println(player.getUserName() + " Loses.");
                return end = true;
            }
            if(!follow) {
                System.out.println(player.getUserName() + " Loses.");
                return end = true;


            }else if (follow) {
                player.deductChip(chipAmount);
                addChipTotalBet(chipAmount);
                System.out.println(player.getUserName()+ ", You are left with "+ player.getchip()+ " chips. ");
                System.out.println("Bet On Table : " + getTotalBetChip());

            }

        }

        return end;
    }

    



}