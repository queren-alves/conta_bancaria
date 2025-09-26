package conta_bancaria.model;

public class ContaPoupanca extends Conta{
	
	private int anniversary;

	public ContaPoupanca(int number, int agency, int type, String holder, float balance, int anniversary) {
		super(number, agency, type, holder, balance);
		this.anniversary = anniversary;
	}

	public int getAnniversary() {
		return anniversary;
	}

	public void setAnniversary(int anniversary) {
		this.anniversary = anniversary;
	}
	
	@Override
	public void view() {
		super.view();
		System.out.printf("\tAniversário da Conta: %d%n", this.anniversary);	
	}

}
