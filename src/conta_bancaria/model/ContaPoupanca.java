package conta_bancaria.model;

public class ContaPoupanca extends Conta{
	
	private int anniversary;

	public ContaPoupanca(int number, int agency, int type, String holder, float balance, int anniversary) {
		super(number, agency, type, holder, balance);
		this.anniversary = anniversary;
	}

	public int getBirthday() {
		return anniversary;
	}

	public void setBirthday(int anniversary) {
		this.anniversary = anniversary;
	}
	
	@Override
	public void view() {
		super.view();
		System.out.printf("Aniversário da Conta: %d%n", this.anniversary);	
	}

}
