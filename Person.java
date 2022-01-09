package uppgift6;

import java.util.ArrayList;

public class Person {
	private String name;
	private String pNbr;
	private ArrayList<Account> accountList = new ArrayList<Account>();

	public Person(String name, String pNbr) {
		this.setName(name);
		this.setpNbr(pNbr);
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public String getpNbr() {
		return pNbr;
	}

	public void setpNbr(String newPNbr) {
		this.pNbr = newPNbr;
	}

	public ArrayList<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(ArrayList<Account> getAccountList) {
		this.accountList = getAccountList;

	}

	public void addAccount(Account a) {
		this.accountList.add(a);
	}

	public Account findAccount(String nbr) {
		for (Account tmp : accountList) {
			if (tmp.getNbr().equals(nbr))
				return tmp;
			{
			}
		}
		return null;
	}

	public double totBalance() {
		double totalBalance = 0;
		for (Account tmp : getAccountList()) {
			totalBalance += tmp.getBalance();
		}
		return totalBalance;
	}
}
