/**NetId: sw883. Time spent: 2 hours, 00 minutes.
 * An instance maintains info about the PHD of a person
 * Class a1PHD contains 3 constructors and 11 methods.
 * You can use those methods to get the basic inforamtion about this person*/

public class PHD {
	private String name; // a string of length > 0
	private char gender; // 'f' for female or 'm' for male
	private int year; 
	private int month; // in range 1-12 with 1 being January, etc
	private PHD advisor1; // the first PHD advisor of this person, null if unknown
	private PHD advisor2; // second advisor of this person. null if unknown. 
	                      //if the first-advisor field is null, the second advisor field must be null
	private int advisees; // the number of PHD advisees of this person
	
	/**Group A
	 * Constructor: an instance for a person has name n, gender g, Phd year y, Phd month m. 
	 * The advisor is unknow and it has no advisees 
	 * Precondition: n has at least 1 char. m is in 1~12. g is 'f' or 'm' for male*/
	public PHD(String n, char g, int y, int m){
		/**name n, gender g, phd year y, phd month m*/
		assert n!= null && n.length() >= 1;
		assert 1 <= m && m <= 12;
		assert g == 'f' || g == 'm';
		name = n;
		gender = g;
		year = y;
		month = m;
		advisor1 = null;
		advisor2 = null;
		advisees = 0;
	}
	
	/**return the name of this person*/
	public String getName(){
		return name;
	}
	
	/**return the year of this person got his PHD*/
	public int getYear(){
		return year;
	}
	
	/**return the month this person got their PHD*/
	public int getMonth(){
		return month;
	}
	
	/**return the value of the sentence "This person is male"*/
	public boolean isMale(){
		if (gender == 'm'){
			return true;
		}
		return false;
	}
	
	/**return the first advisor of this PHD (null if unknown)*/
	public PHD advisor1(){
		return advisor1;
	}
	
	/**return the second advisor of this PHD(null if unknown or non-existent)*/
	public PHD advisor2(){
		return advisor2;
	}
	
	/**return the number of PHD advisees of this person*/
	public int numAdvises(){
		return advisees;
	}
	
	/**Group B*/
	/**add p as the first advisor of this person
	 * Precondition: the first advisor is unknown and p is not null*/
	public void setAdvisor1(PHD p){
		assert this.advisor1 == null;
		assert p != null;
		advisor1 = p;
		p.advisees = p.advisees + 1;
	}
	
	/**add p as the second advisor of this person
	 * Precondition: the first advisor (of this person) is known, 
	 * the second advisor is unknown, p is not null, and p is different from the first advisor*/
	public void setAdvisor2(PHD p){
		assert this.advisor1 != null;
		assert this.advisor2 == null;
		assert p != null;
		assert p != advisor1;
		advisor2 = p;
		p.advisees = p.advisees + 1;
	}
	
	/**Group C
	 * Constructor: a PHD with name n, gender g, PHD year y, PHD month m, first advisor adv and no second advisor
	 * Precondition: n has at least 1 char, g is 'f' for female or 'm' for male, m is 1~12 and adv is not null*/
	public PHD(String n, char g, int y, int m, PHD adv){
		assert n != null && n.length() >= 1;
		assert g == 'f' || g == 'm';
		assert m >= 1 && m <= 12;
		assert adv != null;
		name = n;
		gender = g;
		year = y;
		month = m;
		advisor1 = adv;
		advisor2 = null;
		advisees = 0;
		adv.advisees = adv.advisees + 1;
	}
	
	/**Constructor: a PHD with name n, gender g, PHD year y, PHD month m, first advisor adv1 and second advisor adv2
	 * Precondition: n has at least 1 char. g is 'f' for female or 'm' for male.
	 * m is in 1~12. adv1 and adv2 are not null. adv1 and adv2 are different*/
	public PHD(String n, char g, int y, int m, PHD adv1, PHD adv2){
		assert n != null && n.length() >= 1;
		assert g == 'f' || g == 'm';
		assert m >= 1 && m <= 12;
		assert adv1 != null;
		assert adv2 != null;
		assert adv1 != adv2;
		name = n;
		gender = g;
		year = y;
		month = m;
		advisor1 = adv1;
		advisor2 = adv2;
		advisees = 0;
		adv1.advisees = adv1.advisees + 1;
		adv2.advisees = adv2.advisees + 1;
	}
	
	/**Group D*/
	/**return value of "this person got their PHD before p did
	 * Precondition: p is not null"*/
	public boolean gotBefore(PHD p){
		assert p != null;
		return year < p.year || (year == p.year && month < p.month);
	}
	
	/**return value of "p is not null and this person and p are intellectual siblings"*/
	public boolean arePHDSiblings(PHD p){
		assert p != null;
		assert p != this;
		return (((advisor1 == p.advisor1 || advisor1 == p.advisor2)
				&& advisor1 != null) || ((advisor2 == p.advisor1 || 
				advisor2 == p.advisor2) && advisor2 != null));
	}
}