package atm;

import java.util.Scanner;

class Sbi implements Bank {

	Account b = new Account();
	Scanner sc = new Scanner(System.in);

	public void info() {
		System.out.println("Bank : " + b.getbName());
		System.out.println("Id :" + b.getId());
		System.out.println("Name :" + b.getName());
		System.out.println("Balance : " + b.getBalance());
		System.out.println("--------------------------------------");

	}

	public void showbalance() {
		System.out.println("Enter Pin: ");
		int p = sc.nextInt();
		if (p == b.getPin()) {
			System.out.println(b.getBalance());
			System.out.println("--------------------------------------");
		}
	}

	public void openAccount() {
		b.setbName("State bank of India");
		System.out.print("Enter Your Id : ");
		b.setId(sc.nextInt());
		System.out.print("Enter Account holder Name: ");
		b.setName(sc.next());
		System.out.print("Plese set a 4 digit pin : ");
		b.setPin(sc.nextInt());
		System.out.println("Please Deposit some Money: ");
		System.out.print("Enter amount : ");
		b.setBalance(b.getBalance() + sc.nextInt());

		System.out.println("--------------------------------------");
	}

	public void debit(int n) {
		System.out.println("Enter Pin: ");
		int p = sc.nextInt();
		if (p == b.getPin()) {
			if (b.getBalance() >= n) {
				b.setBalance(b.getBalance() - n);
			}
			else {
				System.out.println("--------------------------------------");
				System.out.println("Insufficient Balance");
				System.out.println("--------------------------------------");
			}
			System.out.println(b.getBalance());
			System.out.println("--------------------------------------");
		}

	}

	public void credit(int n) {
		System.out.println("Enter Pin: ");
		int p = sc.nextInt();
		if (p == b.getPin()) {
			if (b.getBalance() >= n) {
				b.setBalance(b.getBalance() + n);
			}
			System.out.println(b.getBalance());
			System.out.println("--------------------------------------");
		}

	}

}

public class Atm implements Bank {
	Account a = new Account();

	public void info() {
		System.out.println("Bank : " + a.getbName());
		System.out.println("Id :" + a.getId());
		System.out.println("Name :" + a.getName());
		System.out.println("Balance : " + a.getBalance());
		System.out.println("--------------------------------------");

	}

	public void openAc() {
		a.setbName("Hdfc");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter id : ");
		a.setId(sc.nextInt());
		System.out.print("Enter name : ");
		a.setName(sc.next());
		System.out.println("Please deposit some money before we continue");
		System.out.print("Enter Amount : ");
		a.setBalance(a.getBalance() + sc.nextInt());

	}

	public void showbalance() {
		System.out.println(a.getBalance());
		System.out.println("--------------------------------------");

	}

	public void debit(int n) {
		if (n <= a.getBalance()) {
			a.setBalance(a.getBalance() - n);
			System.out.println(a.getBalance());
			System.out.println("--------------------------------------");
		} else {
			System.out.println("--------------------------------------");
			System.out.println("insufficient balance");
			System.out.println("--------------------------------------");
		}

	}

	public void credit(int n) {
		a.setBalance(a.getBalance() + n);
		System.out.println(a.getBalance());
		System.out.println("--------------------------------------");

	}

	public static void main(String[] args) {
		Sbi a1 = new Sbi();
		Atm a2 = new Atm();
		Boolean az = true;
		while (az) {
			System.out.println("--------------------------------------");
			System.out.println("Enter your Choice \n1. Sbi \n2. Hdfc \n3.Exit");
			System.out.println("--------------------------------------");
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				a1.openAccount();
				boolean a = true;
				while (a) {

					System.out.println("Enter your Choice: ");
					System.out.println(
							"1. Balance Enquiry \n2. Add Money \n3. Withdraw Money \n4. Account info \n5. logout");
					System.out.println("--------------------------------------");
					int c = sc.nextInt();
					switch (c) {
					case 1:
						a1.showbalance();
						break;
					case 2:
						System.out.print("Enter Amount : ");
						int amt = sc.nextInt();
						a1.credit(amt);
						break;
					case 3:
						System.out.print("Enter Amount : ");
						int am = sc.nextInt();
						a1.debit(am);
						break;
					case 4:
						a1.info();
						break;
					case 5:
						System.out.println("--------------------------------------");
						a = false;
						break;

					}

				}
				break;

			case 2:
				a2.openAc();
				boolean b = true;
				while (b) {
					System.out.println("Enter your Choice: ");
					System.out.println(
							"1. Balance Enquiry \n2. Add Money \n3. Withdraw Money \n4. Account info \n5. logout");
					System.out.println("--------------------------------------");
					int c = sc.nextInt();
					switch (c) {
					case 1:
						a2.showbalance();
						break;
					case 2:
						System.out.print("Enter amount : ");
						int amt = sc.nextInt();
						a2.credit(amt);
						break;
					case 3:
						System.out.print("Enter Amount : ");
						int am = sc.nextInt();
						a2.debit(am);
						break;
					case 4:
						a2.info();
						break;
					case 5:
						System.out.println("--------------------------------------");
						b = false;
					}

				}

				break;

			case 3:
				az = false;
				break;

			}
		}

	}
}
