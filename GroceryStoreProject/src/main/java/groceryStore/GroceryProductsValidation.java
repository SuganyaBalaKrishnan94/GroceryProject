package groceryStore;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class GroceryProductsValidation {
/**
 * Method is used validate the date input
 * @param date
 * @param input
 * @param purchaseDate
 * @return valid purchaseDate
 */
	public static LocalDate ValidateDateFormate(String date, Scanner input, LocalDate purchaseDate) {
		boolean flag;
		do {
			try {
				purchaseDate=LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyy[-MM[-dd]]"));
				flag=false;
			}catch(DateTimeParseException e) {
				System.out.println("Date formate is incorrect please enter the correct formate");
				date=input.next();
				flag=true;
			}
		}
		while(flag);
		return purchaseDate;
	}
/**
 * Method is used to validate the product
 * @param productNumber
 * @param input
 */
	public static void inputProductValidation(int productNumber, Scanner input) {
		if(productNumber< 0||productNumber>4) {
			System.out.println("Please enter valid input");	
			productNumber=input.nextInt();

		}		
	}
/**
 * Method is used to validate quantity of the product
 * @param productQuantity
 * @param input
 */
	public static void quantityValidation(int productQuantity, Scanner input) {
		if(productQuantity<0) {
			System.out.println("Please enter valid input");
			productQuantity=input.nextInt();
		}		
	}
/**
 * Method is used to validate discount date
 * @param purchaseDate
 * @param discountStartDate
 * @param discountEndDate
 * @return boolean value
 */
	public static boolean validateDiscountDate(LocalDate purchaseDate, LocalDate discountStartDate,
			LocalDate discountEndDate) {
		return (purchaseDate.equals(discountStartDate)||purchaseDate.equals(discountEndDate)||
				(purchaseDate.isAfter(discountStartDate)&&purchaseDate.isBefore(discountEndDate)));
	}

}
