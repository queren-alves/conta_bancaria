package conta_bancaria.model;

public class ContaPoupanca extends Conta{
	
	private int birthday;

	public ContaPoupanca(int number, int agency, int type, String holder, float balance, int birthday) {
		super(number, agency, type, holder, balance);
		this.birthday = birthday;
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public void view() {
		super.view();
		System.out.printf("Aniversário: %d%n", this.birthday);
		
	}
	
	public boolean withdraw(float value) {
		return super.withdraw(value);
	}

}
