package uppgift6;

public class Account {
	private double balance;
	private String nbr;
	private Person owner;

	public Account(double balance, String nbr) {
		this.setBalance(balance);
		this.setNbr(nbr);
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getNbr() {
		return nbr;
	}

	public void setNbr(String nbr) {
		this.nbr = nbr;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public void credit(double amount) {
		balance += amount;
	}

	public void whitdraw(double amount) {
		balance -= amount;
	}
}
