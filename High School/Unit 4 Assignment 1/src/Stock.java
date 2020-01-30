public class Stock {

	private String symbol;
	private int totalShares;
	private double totalCost;
	public double profit;

	public Stock(String theSymbol) {
		symbol = theSymbol;
		totalShares = 0;
		totalCost = 0;
		profit = 0;
	}

	public void purchase(int shares, double pricePerShare) {
		totalShares += shares;
		totalCost += (shares * pricePerShare);
	}

	public double getProfit(double currentPrice) {
		profit = (currentPrice * totalShares) - totalCost;
		return profit;
	}

	public String getSymbol() {
		return symbol;
	}

}