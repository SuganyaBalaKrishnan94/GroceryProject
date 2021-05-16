package groceryStore;

import java.time.LocalDate;
import java.time.YearMonth;

public class ProductPriceCalculation {
/**
 * method is used to calculate total amount
 * @param totalAmount
 * @param productPrice
 * @param productQuantity
 * @return totalAmount of the products
 */
	public double getTotalAmount(double totalAmount, double productPrice, int productQuantity) {
		totalAmount=totalAmount+(productQuantity*productPrice);
		return totalAmount;
	}
	/**
	 * Method is used to calculate bread price
	 * @param currentDate
	 * @param totalAmount
	 * @param productPrice
	 * @param productQuantity
	 * @param soupQuantity
	 * @param purchaseDate
	 * @return price of the bread
	 */

	public double calculateBreadPrice(LocalDate currentDate, double totalAmount, double productPrice,
			int productQuantity, int soupQuantity, LocalDate purchaseDate) {
		LocalDate discountStartDate=currentDate.minusDays(1);
		LocalDate discountEndDate=currentDate.plusDays(7);
		if(soupQuantity>=2 && GroceryProductsValidation.validateDiscountDate(purchaseDate,discountStartDate,discountEndDate)) {
			int breadDiscount=(int) Math.floor(soupQuantity/2);
			if(productQuantity>breadDiscount) {
				totalAmount=totalAmount+(((productQuantity-breadDiscount)*0.80)+(breadDiscount*0.40));
			}
			if(productQuantity<=breadDiscount) {
				totalAmount=totalAmount+(productPrice*0.40);
			}
		}
		else {
			totalAmount=getTotalAmount(totalAmount,productPrice,productQuantity);
		}
		return totalAmount;
	}
/**
 * Method id used to calculate apple price
 * @param currentDate
 * @param totalAmount
 * @param productPrice
 * @param productQuantity
 * @param purchaseDate
 * @return price of the apple
 */
	public double calculateApplePriceAmount(LocalDate currentDate, double totalAmount, double productPrice,
			int productQuantity, LocalDate purchaseDate) {
		LocalDate AppleDiscountStartDate=currentDate.plusDays(3);
		LocalDate AppleDiscountEndDate=YearMonth.from(currentDate.plusMonths(1)).atEndOfMonth();
		if(GroceryProductsValidation.validateDiscountDate(purchaseDate,AppleDiscountStartDate,AppleDiscountEndDate)) {
			totalAmount=totalAmount+(productQuantity*(productPrice-(productPrice*10/100)));
		}
		else {
			totalAmount=getTotalAmount(totalAmount, productPrice, productQuantity);
		}
		return totalAmount;
	}



}
