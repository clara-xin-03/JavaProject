public class GameModule {
    private Player player;
    private Dealer dealer;

    GameModule() {
        player = new Player("a", "a", 100);
        dealer = new Dealer("Dealer", "", 100);
    }

    public void run() {
  
            UI.heading();
            player.userLogin();
            boolean start = true;

            while(start) { 
                UI.heading();
                player.showUserInfo();
                UI.oneDot();  
                dealer.shuffle();
                gameStart();
                dealer.resetGame(dealer, player);
                start = nextGame();
            }
    }

    public boolean nextGame() {
        boolean a; 
        a = Keyboard.readBoolean("Next Game? (Y/N)") ;
        return a;
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
            
            boolean end = player.betting(dealer,player, round);
            if(end) {
                break;
            }
            if(round == 4) {
                gameEnd();

            }
            

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
