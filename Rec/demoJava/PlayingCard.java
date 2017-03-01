/** AN instance is a playing card. */
public class PlayingCard {
	
	// should be private, simplified for demo purposes
	public Suit suit;
	public int value;
	
	/** Constructor: a playing card with suit s and value n.
	 * Precondition: n in 1..13 */
	public PlayingCard(Suit s, int n) {
		suit= s;
		value= n;
	}
	
	/** = a representation of the paying card. */
	public @Override String toString() {
		String name;
		if (value == 1)  name= "Ace";
		else if (value == 11)  name= "Jack";
		else if (value == 12)  name= "Queen";
		else if (value == 13)  name= "King";
		else  name= "" + value;
		return name + " of " + suit;
	}
}
