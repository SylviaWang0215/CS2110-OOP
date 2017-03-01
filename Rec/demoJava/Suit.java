
public enum Suit {
	CLUBS("black"), DIAMONDS("red"), HEARTS("red"), SPADES("black");
	
	// Enums can have fields and constructors to initialize those fields.
	// The only time the constructor can be called is in the declaration of
    // initial enum constants
	private String color;
	
	/** Constructor: a suit with color c
	    Precondition: c is either "red" or "black" */
	Suit(String c) {
		color = c;
	}
	
	// Enums can have instance or static methods.
	// Examples of calling instance methods on enum values:
	//    Suit.CLUBS.color();
	//    Suit.HEARTS.isRed();
	
	/** Return the color of the suit. */
	public String getColor() {
		return color;
	}
	/** Return "this suit is red. */
	public boolean isRed() {
		return color == "red";
	}
	
	/** Return "this suit is black. */
	public boolean isBlack() {
		return color == "black";
	}
}
