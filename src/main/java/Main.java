import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack");

        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();

        //Create a deck for player
        Deck playerDeck = new Deck();

        Deck dealerDeck = new Deck();

        double playerMoney = 100.00;

        Scanner userInput = new Scanner(System.in);
        while (playerMoney > 0){
            //play game
            //take player bet
            System.out.println("You have ¢"+playerMoney + ", how much would you like to bet");
            double playerBet = userInput.nextDouble();
            if (playerBet > playerMoney){
                System.out.println("You cannot bet more than you have");
                break;
            }

            boolean endRound = false;

            //start dealing
            //player gets two cards
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);

            //dealer gets two cards
            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);

            while (true){
                System.out.println("You have:");
                System.out.println(playerDeck.toString());
                System.out.println("Your deck is valued at: "+ playerDeck.cardsValue());

                //display dealer hand
                System.out.println("Dealer hand "+ dealerDeck.getCard(0).toString() + " and hidden");

                //What does the player want to do
                System.out.println("Would you like to (1)Hit or (2)Stand");
                int response = userInput.nextInt();

                //they hit
                if (response == 1){
                    playerDeck.draw(playingDeck);
                    System.out.println("You draw a: "+ playerDeck.getCard(playerDeck.deckSize() - 1).toString());

                    //bust if > 21
                    if (playerDeck.cardsValue() > 21){
                        System.out.println("Bust. current value at: "+ playerDeck.cardsValue());
                        playerMoney -= playerBet;
                        endRound = true;
                        break;
                    }
                }
                if (response == 2){
                    break;
                }
            }
            //Reveal dealers card
            System.out.println("dealer cards: "+ dealerDeck.toString());

            //see if dealer has more point than player
            if (dealerDeck.cardsValue() > playerDeck.cardsValue() && !endRound){
                System.out.println("Dealer beats you");
                playerMoney -= playerBet;
                endRound = true;
            }

            //dealer draw at 16, stand at 17
            while ((dealerDeck.cardsValue() < 17) && !endRound){
                dealerDeck.draw(playingDeck);
                System.out.println("dealer draws " + dealerDeck.getCard(dealerDeck.deckSize() - 1).toString());
            }

            //display total value for dealer
            System.out.println("dealer's hand is valued at: " + dealerDeck.cardsValue());

            //determine if dealer is busted
            if ((dealerDeck.cardsValue() > 21) && !endRound){
                System.out.println("dealer busted, you've won");
                playerMoney += playerBet;
                endRound = true;
            }

            //determine push
            if ((playerDeck.cardsValue() == dealerDeck.cardsValue()) && !endRound){
                System.out.println("Push");
                endRound = true;
            }

            if ((playerDeck.cardsValue() > dealerDeck.cardsValue() && !endRound)){
                System.out.println("you've won");
                playerMoney += playerBet;
                endRound = true;
            }
            else if (!endRound){
                System.out.println("You've lost");
                playerMoney -= playerBet;
                endRound = true;
            }

            playerDeck.moveAllToDeck(playingDeck);
            dealerDeck.moveAllToDeck(playingDeck);
            System.out.println("End of hand");
        }
        System.out.println("Game over: you are out of money");

    }
}
