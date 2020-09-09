package victor.training.java8;

/* "I call it my billion-dollar mistake. 
 * It was the invention of the null reference in 1965..." NullPointerException
 *  -- Sir Charles Antony Richard  */

// Get a discount line to print in UI

import java.util.Optional;

import static java.util.Optional.*;

class DiscountService {
	public String getDiscountLine(Customer customer) {
		return customer.getMemberCard()
			.flatMap(this::getApplicableDiscountPercentage)
			.map(p -> "Discount: " + p)
			.orElse("");
	}
		
	private Optional<Integer> getApplicableDiscountPercentage(MemberCard card) {
		if (card.getFidelityPoints() >= 100) {
			return of(5);
		}
		if (card.getFidelityPoints() >= 50) {
			return of(3);
		}
		return empty();
	}
		
	// test: 60, 10, no MemberCard
	public static void main(String[] args) {
		System.out.println(new DiscountService().getDiscountLine(new Customer(new MemberCard(60))));
		System.out.println(new DiscountService().getDiscountLine(new Customer(new MemberCard(10))));
		System.out.println(new DiscountService().getDiscountLine(new Customer()));
	}
}


// VVVVVVVVV ==== supporting (dummy) code ==== VVVVVVVVV

// entity.* --------------  sacred grounds of Entities ---------------------
class Customer {
	private MemberCard memberCard;
	public Customer() {
	}
	public Customer(MemberCard profile) {
		this.memberCard = profile;
	}

	// if the column in DB was NULLABLE then -> getter : Optional<> in *all entities
	public Optional<MemberCard> getMemberCard() {
		return ofNullable(memberCard);
	}
}

class MemberCard {
	private final int fidelityPoints;

	public MemberCard(int fidelityPoints) {
		this.fidelityPoints = fidelityPoints;
	}

	public int getFidelityPoints() {
		return fidelityPoints;
	}
	
}
