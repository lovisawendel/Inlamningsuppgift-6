package uppgift6;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class App {

	private JFrame frame;
	private JTextField textField_Name;
	private JTextField textField_ID;
	private JTextField textField_AccountNbr;
	private JTextField textField_Amount;
	private Controller controller; // Koppling till klassen Controller
	private Personregister pReg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(6, 6, 61, 16);
		frame.getContentPane().add(lblName);

		textField_Name = new JTextField();
		textField_Name.setBounds(51, 1, 130, 26);
		frame.getContentPane().add(textField_Name);
		textField_Name.setColumns(10);

		JLabel lblID = new JLabel("ID - number:");
		lblID.setBounds(6, 34, 91, 16);
		frame.getContentPane().add(lblID);

		textField_ID = new JTextField();
		textField_ID.setBounds(92, 29, 130, 26);
		frame.getContentPane().add(textField_ID);
		textField_ID.setColumns(10);

		JLabel lblAccountNbr = new JLabel("Account Number:");
		lblAccountNbr.setBounds(6, 90, 117, 16);
		frame.getContentPane().add(lblAccountNbr);

		textField_AccountNbr = new JTextField();
		textField_AccountNbr.setBounds(125, 85, 130, 26);
		frame.getContentPane().add(textField_AccountNbr);
		textField_AccountNbr.setColumns(10);

		textField_Amount = new JTextField();
		textField_Amount.setBounds(267, 240, 130, 26);
		frame.getContentPane().add(textField_Amount);
		textField_Amount.setColumns(10);

		JLabel lblResponse = new JLabel("Response");
		lblResponse.setBounds(6, 118, 282, 16);
		frame.getContentPane().add(lblResponse);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(267, 62, 199, 100);
		frame.getContentPane().add(textArea);

		JButton btnAddPerson = new JButton("Add Person");
		btnAddPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_Name.getText();
				String pNbr = textField_ID.getText();
				controller.addPerson(name, pNbr); // lägger till person till personregister
				lblResponse.setText(name + " is added to register");
			}
		});

		btnAddPerson.setBounds(290, 21, 117, 29);
		frame.getContentPane().add(btnAddPerson);

		JButton btnAddAccount = new JButton("Add Account");
		btnAddAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double balance = 0;
				String pNbr = textField_ID.getText();
				String nbr = textField_AccountNbr.getText();
				controller.addAccount(balance, nbr, pNbr); // lägger till konto till person
				lblResponse.setText("Person " + pNbr + " owns account " + nbr);

			}
		});
		btnAddAccount.setBounds(6, 158, 117, 29);
		frame.getContentPane().add(btnAddAccount);

		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pNbr = textField_ID.getText();
				Person person = controller.findPerson(pNbr); // letar efter person i personregister
				if (person != null) {
					lblResponse.setText("Person " + pNbr + " found");
				} else {
					lblResponse.setText("Person " + pNbr + " not found");
				}
			}
		});
		btnFind.setBounds(125, 158, 117, 29);
		frame.getContentPane().add(btnFind);

		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pNbr = textField_ID.getText();
				Person person = controller.findPerson(pNbr); // letar efter person i personregister
				if (person != null) {
					controller.removePerson(pNbr); // tar bort person
					lblResponse.setText("Person " + pNbr + " deleted");
				} else {
					lblResponse.setText("Person " + pNbr + " not found");
				}
			}
		});

		btnRemove.setBounds(6, 199, 117, 29);
		frame.getContentPane().add(btnRemove);

		JButton btnCredit = new JButton("Credit");
		btnCredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pNbr = textField_ID.getText();
				String nbr = textField_AccountNbr.getText();
				double amount = Double.valueOf(textField_Amount.getText());
				controller.credit(pNbr, nbr, amount);
				lblResponse.setText(amount + " added to account " + nbr);
			}
		});
		btnCredit.setBounds(6, 240, 117, 29);
		frame.getContentPane().add(btnCredit);

		JButton btnWhitdraw = new JButton("Whitdraw");
		btnWhitdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pNbr = textField_ID.getText();
				String nbr = textField_AccountNbr.getText();
				double amount = Double.valueOf(textField_Amount.getText());
				controller.whitdraw(pNbr, nbr, amount);
				lblResponse.setText(amount + " whitdrawn from account " + nbr);
			}
		});
		btnWhitdraw.setBounds(138, 240, 117, 29);
		frame.getContentPane().add(btnWhitdraw);

		JButton btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pNbr = textField_ID.getText();
				for(Account tmp: controller.getAccountList(pNbr)) {
					if(tmp != null) {
					String text = ("\nSaldo: " + tmp.getBalance() + " nummer: " + tmp.getNbr());
					textArea.append(text);
					}
				}
			}
			
		});
		btnShowAll.setBounds(125, 199, 117, 29);
		frame.getContentPane().add(btnShowAll);

		JButton btnTotalB = new JButton("Total Balance");
		btnTotalB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pNbr = textField_ID.getText();
				controller.totBalance(pNbr); // hämtar totalt saldo för en person
				lblResponse.setText(
						"Total balance for person " + pNbr + " is: " + String.valueOf(controller.totBalance(pNbr)));
			}
		});
		btnTotalB.setBounds(258, 199, 117, 29);
		frame.getContentPane().add(btnTotalB);

		pReg = new Personregister();
		controller = new Controller(pReg, frame);

	}
}
