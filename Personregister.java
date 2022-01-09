package uppgift6;

import java.util.ArrayList;

public class Personregister {
	private ArrayList<Person> personList = new ArrayList<Person>();

	public void addPerson(Person p) {
		personList.add(p);
	}

	public double totBalancePerson(String pNbr) {
		return findPerson(pNbr).totBalance();
	}

	public ArrayList<Person> getPersonList() {
		return this.personList;
	}

	public Person findPerson(String pNbr) {
		for (Person tmpP : personList) {
			if (tmpP.getpNbr().equals(pNbr)) {
				return tmpP;
			}
		}
		return null;
	}

	public Person removePerson(String pNbr) {
		Person p = this.findPerson(pNbr);
		if (p != null) {
			personList.remove(p);
		}
		return p;
	}

	public Account findAccount(String pNbr, String nbr) {
		Person p = findPerson(pNbr);
		if (p != null) {
			return p.findAccount(pNbr);
		}
		return null;
	}
}
