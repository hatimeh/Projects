package eecs2030.pe2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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


public class PhoneCardWallet 
{
	
		private String cardName;
		private Set<PhoneCard> cardSet;

	public PhoneCardWallet(String name)
	{
		this.cardName = name;
		this.cardSet = new HashSet<PhoneCard>();	
	}
	
	public PhoneCardWallet(String string, Set<PhoneCard> cardSet)
	{
		this.cardSet = cardSet;
			
	}
	
	public String getName()
	{
		return this.cardName;
	}
	
	public Set<PhoneCard> getCardSet()
	{
		return this.cardSet;
	}
	
	public void addCard(PhoneCard card)
	{
		cardSet.add(card);
	}
	
	public void removeCard(PhoneCard card)
	{
		cardSet.remove(card);
	}
	
	public Set<PhoneCard> filter(CallZone zone, double cost)
	{
		
		//store the set of all cards in the wallet
		Set<PhoneCard> setFilter = new HashSet<PhoneCard>();
		
		for(PhoneCard check: cardSet)
	{
			
		//check to see if the card is valid in the zone		
		if(check.isAllowed(zone))
			
	{
	    //check to see if the card has suffecient funds
		if(check.getBalance() >= cost)
	{
		setFilter.add(check);
	}
			
	}
	}
		return setFilter;
	}

	@Override
	public int hashCode() 
	{
		
		//returns wallet's name and card set.
		return Objects.hash(cardName, cardSet);
	}

	@Override
	public boolean equals(Object obj) 
	{
		
		PhoneCardWallet compare = (PhoneCardWallet) obj;
		if (this.getName().equals(compare.getName()) && this.getCardSet().equals(compare.getCardSet())) 
	{
			 
		return true;
			
	}
		return false;
	}
	
	
	
}
