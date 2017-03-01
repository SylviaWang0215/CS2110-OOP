import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {

	private ArrayList<PlayingCard> cards; //Deck of cards

    /** Constructor: a deck of 52 playing cards. */
	public Deck() {
		cards = new ArrayList<PlayingCard>();

		// Suit.values() returns an array of all values in enum Suit
		for (Suit s : Suit.values()) {
			for (int i= 1; i < 14; i= i+1) {
				cards.add(new PlayingCard(s, i));
			}
		}
	}

	/** Shuffle the deck. */
	public void shuffleDeck() {
		Collections.shuffle(cards);
	}

	/** Draw one card --take it from the top of the deck. */
	public PlayingCard drawCard() {
		return cards.remove(cards.size() - 1);
	}

	/** remove all cards of suit s. */
	public void removeAll(Suit s) {
		ArrayList<PlayingCard> newDeck= new ArrayList<PlayingCard>();
		for (PlayingCard card : cards) {
			// Note:you can use != and == to compare enum values. equals works too
			if (card.suit != s) {
				newDeck.add(card);
			}
		}
		cards= newDeck;
	}

	/** Return the probability of a card being red. */
	public double probabilityOfRed() {
		int numRed= 0;
		for (PlayingCard c : cards) {
			// Suit has instance methods that can be called on any Suit enum value
			if (c.suit.isRed()) {
				numRed++;
			}
		}
		return ((double) numRed) / cards.size();
	}

	/** Return the probability of a card being black. */
    public double probabilityOfBlack() {
		return 1 - probabilityOfRed();
	}

	/** Return a representation of this Deck. */
	public @Override String toString() {
		return Arrays.toString(cards.toArray());
	}

	public void printProbabilities() {
		System.out.println("Probability of red:   " + probabilityOfRed());
		System.out.println("Probability of black: " + probabilityOfBlack());
		System.out.println();
	}

	public static void main(String[] args) {
		Deck d = new Deck();
		System.out.println(d);
		System.out.println();

		System.out.println("New deck of cards");
		d.printProbabilities();

		System.out.println("Removing all hearts");
		d.removeAll(Suit.HEARTS);
		d.printProbabilities();

		System.out.println("New deck of cards. Shuffling and drawing 7 random cards.");
		d = new Deck();
		d.shuffleDeck();
		for (int i = 0; i < 7; i++) {
			System.out.println(d.drawCard());
		}
		d.printProbabilities();
	}

}
