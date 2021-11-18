public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.suit.toString() + "-" + this.value.toString();
    }

    /*public enum Value{
        ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING;

        public static Value getValue(int index){
            Value[]values = Value.values();
            return values[index];
        }

        public static int getValueLength(){
            return Value.values().length;
        }
    }

    public enum Suit{
        HEART,DIAMOND,CLUB,SPADE;

        public static Suit getSuit(int index){
            Suit[] suits = Suit.values();
            return suits[index];
        }

        public static int getSuitLength(){
            return Suit.values().length;
        }
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", value=" + value +
                '}';
    }*/
}
