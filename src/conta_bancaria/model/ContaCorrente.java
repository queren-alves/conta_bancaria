package conta_bancaria.model;

public class ContaCorrente extends Conta {
	
	private float limit;
	
	public ContaCorrente(int number, int agency, int type, String holder, float balance, float limit) {
		super(number, agency, type, holder, balance);
		this.limit = limit;
	}

	public float getLimit() {
		return limit;
	}

	public void setLimit(float limit) {
		this.limit = limit;
	}
	
	@Override
	public void view() {
		super.view();
		System.out.printf("\tLimite da conta: R$ %.2f%n", this.limit);
	}

	@Override
	public boolean withdraw(float value) {
		if(this.getBalance() + this.getLimit() < value) {
			System.out.println("\nSaldo insuficiente.");
			return false;
		}
		
		this.setBalance(this.getBalance() - value);
		return true;
	}
}
