import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<>();
    }

    public void createFullDeck(){
        for (Suit cardSuit : Suit.values()){
            for (Value cardValue : Value.values()){
                this.cards.add(new Card(cardSuit,cardValue));
            }
        }
    }

    //method to shuffle deck of cards
    public void shuffle(){
        ArrayList<Card> tmpDeck = new ArrayList<>();
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();
        for (int i = 0; i < originalSize; i++){
            //generate random index rand.nextInt((max-min)+1)+min
            randomCardIndex = random.nextInt((this.cards.size() - 1) + 1 )+ 0;
            tmpDeck.add(this.cards.get(randomCardIndex));

            //remove from original deck
            this.cards.remove(randomCardIndex);
        }
        this.cards = tmpDeck;
    }

    //remove card
    public void removeCard(int i){
        this.cards.remove(i);
    }

    //get card
    public Card getCard(int i){
        return this.cards.get(i);
    }

    //add card
    public void addCard(Card addCard){
        this.cards.add(addCard);
    }

    //draw card
    public void draw(Deck comingFrom){
        this.cards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
    }

    //return value of card in deck
    public int cardsValue(){
        int totalValue = 0;
        int ace = 0;

        for (Card aCard : this.cards){
            switch (aCard.getValue()){
                case TWO: totalValue += 2; break;
                case THREE: totalValue += 3; break;
                case FOUR: totalValue += 4; break;
                case FIVE: totalValue += 5; break;
                case SIX: totalValue += 6; break;
                case SEVEN: totalValue += 7; break;
                case EIGHT: totalValue += 8; break;
                case NINE: totalValue += 9; break;
                case TEN: totalValue += 10; break;
                case JACK: totalValue += 10; break;
                case QUEEN: totalValue += 10; break;
                case KING: totalValue += 10; break;
                case ACE: totalValue += 1; break;
            }
        }
        for (int i = 0; i < ace; i++){
            if (totalValue > 10){
                totalValue += 1;
            }
            else {
                totalValue += 11;
            }
        }
        return totalValue;
    }

    public int deckSize(){
        return this.cards.size();
    }

    public void  moveAllToDeck(Deck moveTo){
        int thisDeckSize = this.cards.size();
        for (int i = 0; i < thisDeckSize; i++){
            moveTo.addCard(this.getCard(i));
        }
        for (int i = 0; i < thisDeckSize; i++){
            this.removeCard(0);
        }
    }

    public String toString(){
        String carListOutput = "";
        for (Card aCard : this.cards){
            carListOutput += "\n" + aCard.toString();
        }
        return carListOutput;
    }

}
