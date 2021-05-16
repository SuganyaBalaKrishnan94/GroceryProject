package groceryStoreTest;


import java.text.DecimalFormat;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import groceryStore.GroceryProductsConstants;
import groceryStore.ProductPriceCalculation;

public class ProductPriceCalculationTest {
	ProductPriceCalculation priceCalculation =new ProductPriceCalculation();
	LocalDate currentDate=LocalDate.now();
	LocalDate purchaseDate = LocalDate.parse("2021-05-16");
	@Test
	public void testBasket1() {
		double totalCostexpected =3.15;
		double totalAmount = 0;
		int soupQuantity=3;
		int breadQuantity=2;
		double soupTotalPrice=priceCalculation.getTotalAmount(totalAmount, GroceryProductsConstants.SOUP_PRICE, soupQuantity);
		double breadTotalPrice=priceCalculation.calculateBreadPrice(currentDate, totalAmount, GroceryProductsConstants.BREAD_PRICE, breadQuantity, soupQuantity, purchaseDate);
		double actual=soupTotalPrice+breadTotalPrice;
		Assert.assertEquals(totalCostexpected, Double.parseDouble(new DecimalFormat("#.##").format(actual)), 0.0);
	}
	@Test
	public void testBasket2() {
		double totalCostexpected =1.90;
		double totalAmount = 0;
		int AppleQuantity=6;
		int milkQuantity=1;
		double milkTotalPrice=priceCalculation.getTotalAmount(totalAmount, GroceryProductsConstants.MILK_PRICE, milkQuantity);
		double AppleTotalPrice=priceCalculation.calculateApplePriceAmount(currentDate, totalAmount, GroceryProductsConstants.APPLE_PRICE, AppleQuantity, purchaseDate);
		double actual=milkTotalPrice+AppleTotalPrice;
		Assert.assertEquals(totalCostexpected, Double.parseDouble(new DecimalFormat("#.##").format(actual)), 0.0);
	}

	@Test
	public void testBasket3() {
		double totalCostexpected =1.84;
		double totalAmount = 0;
		int AppleQuantity=6;
		int milkQuantity=1;
		LocalDate purchaseDate=LocalDate.parse("2021-05-21");
		double milkTotalPrice=priceCalculation.getTotalAmount(totalAmount, GroceryProductsConstants.MILK_PRICE, milkQuantity);
		double AppleTotalPrice=priceCalculation.calculateApplePriceAmount(currentDate, totalAmount, GroceryProductsConstants.APPLE_PRICE, AppleQuantity, purchaseDate);
		double actual=milkTotalPrice+AppleTotalPrice;
		Assert.assertEquals(totalCostexpected, Double.parseDouble(new DecimalFormat("#.##").format(actual)), 0.0);
	}

	@Test
	public void testBasket4() {
		double totalCostexpected =1.97;
		double totalAmount = 0;
		int AppleQuantity=3;
		int soupQuantity=2;
		int breadQuantity=1;
		LocalDate purchaseDate=LocalDate.parse("2021-05-21");
		double AppleTotalPrice=priceCalculation.calculateApplePriceAmount(currentDate, totalAmount, GroceryProductsConstants.APPLE_PRICE, AppleQuantity, purchaseDate);
		double soupTotalPrice=priceCalculation.getTotalAmount(totalAmount, GroceryProductsConstants.SOUP_PRICE, soupQuantity);
		double breadTotalPrice=priceCalculation.calculateBreadPrice(currentDate, totalAmount, GroceryProductsConstants.BREAD_PRICE, breadQuantity, soupQuantity, purchaseDate);
		double actual=AppleTotalPrice+soupTotalPrice+breadTotalPrice;
		Assert.assertEquals(totalCostexpected, Double.parseDouble(new DecimalFormat("#.##").format(actual)), 0.0);
	}

}
