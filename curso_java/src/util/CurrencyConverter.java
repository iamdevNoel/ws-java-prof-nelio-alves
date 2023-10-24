package util;

public class CurrencyConverter {
	public static final double IOF = 6.00;
	
	public static double usdToBRL(double dollarAmount, double dollarPrice) {
		return dollarAmount * dollarPrice * (1 + IOF / 100);
	}
}
