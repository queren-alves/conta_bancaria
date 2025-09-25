package conta_bancaria.model;

public abstract class Conta {

	private int number;
	private int agency;
	private int type;
	private String holder;
	private float balance;

	public Conta(int number, int agency, int type, String holder, float balance) {
		this.number = number;
		this.agency = agency;
		this.type = type;
		this.holder = holder;
		this.balance = balance;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getAgency() {
		return agency;
	}

	public void setAgency(int agency) {
		this.agency = agency;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public boolean withdraw(float value) {
		if (this.balance < value) {
			System.out.println("\nSaldo insuficiente.");
			return false;
		}

		this.balance -= value;
		return true;
	}

	public void deposit(float value) {
		this.balance += value;
	}

	public void view() {
		String type = "";

		switch (this.type) {
			case 1 -> type = "Conta Corrente";
			case 2 -> type = "Conta Poupança";
			default -> type = "Desconhecido";
		}

		System.out.println("\nDados da conta:\n");
		System.out.printf("Número da conta: %d%n", this.number);
		System.out.printf("Número da agência: %d%n", this.agency);
		System.out.printf("Tipo da conta: %s%n", type);
		System.out.printf("Titular da conta: %s%n", this.holder);
		System.out.printf("Saldo da conta: R$ %.2f%n", this.balance);
	}

}