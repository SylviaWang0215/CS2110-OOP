/**
 * Created by mac on 2/2/17.
 */
public class Time {
    private int hr;    //the hour of the day
    private int mn;    //the minute of the hours
    
    /**Constructor: an instance with hour h and minute m
     * precondition: h in 0~23 and minute in 0~59*/
    public Time(int h, int m){
    	hr = h;
    	mn = m;
    }
    
    
    public void printitout(int n){
    	int y = 0;
    	n = n / y;
    	System.out.println(n);
    }

    /**return the hour of the day*/
    public int getHour() {
        return hr;
    }
    

    /**return the minutes of the day*/
    public int getMinute(){
        return mn;
    }
    
    public String toString(){
    	return make2(hr) + ":" + make2(mn);
    }
    
    public void setHour(int h){
    	assert 0 <= h && h <= 23;
    	hr = h;
    }
    
    private String make2(int n){
    	if (n < 10){
    		return "0" + n;
    	}
    	return "" + n;
    }
    

    
}
