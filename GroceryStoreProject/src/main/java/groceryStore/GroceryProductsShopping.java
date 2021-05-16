package groceryStore;

import java.time.LocalDate;
import java.util.Scanner;


public class GroceryProductsShopping {

	public static void main(String[] args) {
		int productNumber=1;
		double productPrice=0,totalAmount=0;
		int soupQuantity=0;
		LocalDate currentDate=LocalDate.now();
		ProductPriceCalculation priceCalculation=new ProductPriceCalculation();
		Scanner input=new Scanner(System.in);
		LocalDate purchaseDate=null;
		System.out.println("Enter the date of purchasing and date formate is yyyy-mm-dd");
		String date=input.next();
		purchaseDate=GroceryProductsValidation.ValidateDateFormate(date,input,purchaseDate);
		do {
			System.out.println("Welcome to GroceryStore-Billing");
			System.out.println();
			System.out.println("Product     unit      cost");
			System.out.println("==========================");
			System.out.println("1.soup      tin       " + GroceryProductsConstants.SOUP_PRICE);
			System.out.println("2.bread     loaf      " + GroceryProductsConstants.BREAD_PRICE);
			System.out.println("3.milk      bottle    " + GroceryProductsConstants.MILK_PRICE);
			System.out.println("4.apples    single    " + GroceryProductsConstants.APPLE_PRICE);
			System.out.println();
			System.out.println("0. Quit");
			System.out.println("");

			System.out.println("Please select product number or Enter 0 for exit");
			productNumber=input.nextInt();
			GroceryProductsValidation.inputProductValidation(productNumber,input);
			if(productNumber==0)
				break;
			System.out.println("Enter the quantity");
			int productQuantity=input.nextInt();
			GroceryProductsValidation.quantityValidation(productQuantity,input);
			switch(productNumber) {
			case 1:
				soupQuantity=productQuantity;
				productPrice=GroceryProductsConstants.SOUP_PRICE;
				totalAmount=priceCalculation.getTotalAmount(totalAmount,productPrice,productQuantity);
				break;
			case 2:
				productPrice=GroceryProductsConstants.BREAD_PRICE;
				totalAmount=priceCalculation.calculateBreadPrice(currentDate,totalAmount,productPrice,productQuantity,soupQuantity,purchaseDate);
				break;
			case 3:
				productPrice=GroceryProductsConstants.MILK_PRICE;
				totalAmount=priceCalculation.getTotalAmount(totalAmount,productPrice,productQuantity);
				break;

			case 4:
				productPrice=GroceryProductsConstants.APPLE_PRICE;
				totalAmount=priceCalculation.calculateApplePriceAmount(currentDate,totalAmount,productPrice,productQuantity,purchaseDate);
				break;
			default:
				break;

			}

		}while(productNumber>0);
		System.out.println("Total Bill amount is "+totalAmount);
	}

}
