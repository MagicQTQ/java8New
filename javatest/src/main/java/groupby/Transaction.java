package groupby;

public class Transaction { //事务
	private final Trader trader; 
	private final int year;
	private final int value;
	private final boolean flag;

	public Transaction(Trader trader, int year, int value,boolean flag) {
		this.trader = trader;
		this.year = year;
		this.value = value;
		this.flag = flag;
	}

	public Trader getTrader() {
		return this.trader;
	}

	public int getYear() {
		return this.year;
	}

	public int getValue() {
		return this.value;
	}


	public boolean getFlag() {
		return flag;
	}

	public String toString() {
		return "{" + this.trader + ", " + "year: " + this.year + ", " + "value:" + this.value + "}";
	}
}
