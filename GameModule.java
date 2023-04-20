public class GameModule {
    private Player player;
    private Dealer dealer;

    GameModule() {
        player = new Player("a", "a", 100);
        dealer = new Dealer("Dealer", "", 100);
    }

    public void run() {
        // boolean = true;
        // while() {
            UI.heading();
            player.userLogin();
            UI.heading();
            player.showUserInfo();
            UI.oneDot();
            
            dealer.shuffle();
            
            gameStart();
            gameEnd();
            dealer.resetDeck(dealer, player) ;
            // bettingGame();
            // endScore();
            // nextGame();

        // }
    }


    public static void main(String[] args) {
        GameModule app = new GameModule();
        app.run();
        
    }

    public void gameStart() {
        for(int round = 1; round <=4; round++) {
            UI.oneDot();

            
            System.out.println("Dealer dealing cards - ROUND " + round);
            UI.oneDot();
            if(round ==1) {
                dealer.dealCardtoAll(player, dealer);
            
            }
            dealer.dealCardtoAll(player, dealer);

            dealer.showCardsOnHand(false);

            player.showCardsOnHand(true);
            player.showTotalValue();
        }
        
    }

    public void gameEnd() {
    UI.oneDot();
    System.out.println("Game End - Dealer reveal hidden cards ");
    UI.oneDot();
    
    

    dealer.showCardsOnHand(true);
    dealer.showTotalValue();

    player.showCardsOnHand(true);
    player.showTotalValue();

    dealer.checkWinner(player, dealer) ;

    }



    
}
