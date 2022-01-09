package uppgift6;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Controller { 
	Personregister pReg; //kopplar samman med personregister
	JFrame customerFrame; //refererar till applikationen	
	
	public Controller(Personregister preg1, JFrame customerFrame) { 
		this.pReg = preg1; 
		this.customerFrame = customerFrame; 
    } 
	public void removePerson(String pNbr) { 
		pReg.removePerson(pNbr); 
	} 
	public Person findPerson(String pNbr) {
		return pReg.findPerson(pNbr);
	}
	public double totBalance(String pNbr) {
		return findPerson(pNbr).totBalance();
	}
	public void whitdraw(String pNbr, String nbr, double amount) {
		 this.findPerson(pNbr).findAccount(nbr).whitdraw(amount);
	}
	public void credit(String pNbr, String nbr, double amount) {
		 this.findPerson(pNbr).findAccount(nbr).credit(amount);
	}
	public ArrayList<Account> getAccountList(String pNbr) {
			ArrayList<Account> accountList = this.findPerson(pNbr).getAccountList();
			return accountList;
	}
	public void addAccount(double balance, String nbr, String pNbr) { 
		Account tmpAccount = new Account(balance, nbr);
		Person tmpPerson = pReg.findPerson(pNbr);
		tmpPerson.addAccount(tmpAccount);
		}
	public void addPerson(String name, String pNbr) { 
		
		Person tmpPerson = new Person(name, pNbr);
		pReg.addPerson(tmpPerson); 
	}
	}

