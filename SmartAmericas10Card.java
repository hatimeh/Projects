package eecs2030.pe2;

import java.util.HashSet;

/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: HATIM TAYABALLY	
Student Number: 217888199
Course Section: SECTION M
*/


import java.util.Set;

public class SmartAmericas10Card extends PhoneCard 
{
	
	public static final double COST_PER_MIN_TO_CANADA = 0.03;
	public static final double COST_PER_MIN_TO_LATINAM = 0.10;
	public static final double COST_PER_MIN_TO_USA = 0.05;
	public static final double INITIAL_BALANCE = 10.0;
	public static final double WEEKLY_FEES = 0.30;
	
	
	/*
	* Creates a SmartAmericas10Card phone card with the given number and password. Sets card's balance to INITIAL_BALANCE and its call history to the empty list.
	*
	* @param number - the card's number.
			password - the card's password.
	* 
	* @pre number and password are positive.
	*/
	public SmartAmericas10Card( long number, int password)
	{
		super(number, password, INITIAL_BALANCE);
	}
	
	/*
	* Create a copy of the given SmartAmericas10Card. A deep copy is returned.
	*
	* @param card - the card to make a copy of.
	* 
	* @pre card is not null.
	*/
	public SmartAmericas10Card( SmartAmericas10Card card)
	{
		 super(card.getNumber(), card.getPassword(), card.getBalance());
	}
	
	public Set<CallZone> allowedZones() 
	{
		Set<CallZone> allowed = new HashSet<CallZone>();
		allowed.add(CallZone.CANADA);
		allowed.add(CallZone.USA);
		allowed.add(CallZone.LATINAM);
		return allowed;
		
	}
	
	public boolean isAllowed(CallZone canada)
	{
		if(allowedZones().contains(canada))
	{
		return true;
	}
		
		else 
	{
		return false;
	}
	}
	
	// new list to store history
	Set<Call> history = new HashSet<Call>();
	
	public Set<Call> getCallHistory()
	{
		return history;
	}
	
	public boolean charge(Call call)
	{
		assert this.isAllowed(call.getZone());
	    if(call.getMinutes() * this.costPerMin(call.getZone()) > this.getBalance())
	{
		return false;
	}
	    else
	{
		this.setBalance(this.getBalance() - call.getMinutes() * this.costPerMin(call.getZone())); 
		//adding to history set
	    history.add(call);
	    return true;
	}
	}
	
	@Override
	public double costPerMin(CallZone zone)
	{
		if(zone == CallZone.CANADA)
	{
		return COST_PER_MIN_TO_CANADA;
	}
		else if(zone == CallZone.USA)
	{
		return COST_PER_MIN_TO_USA;
	}
		else
	{
		return COST_PER_MIN_TO_LATINAM;
	}
	}
	
	@Override
	public void deductWeeklyFee()
	{
		//math func that returns 0 or the latter
		this.setBalance(Math.max(0, this.getBalance() - WEEKLY_FEES));
	}
	
	public boolean Equals(Object obj) 
	{
		
		//variables to store T/F value
		boolean compare = super.equals(obj);

		if (compare) 
	{
		SmartAmericas10Card other = (SmartAmericas10Card) obj;
			
		if (this.getPassword() == other.getPassword() && this.getBalance() == other.getBalance() 
			&& this.getCallHistory().equals(other.getCallHistory()) && this.getNumber() == other.getNumber()) 
	{
		compare = true;
	}
	}
		return compare;
	}
}
