package conta_bancaria.repository;

import conta_bancaria.model.Conta;

public interface ContaRepository {

	void viewAll();
	void register(Conta acc);
	void update(Conta acc);
	void searchByNumber(int number);
	void delete(int number);
	
	void withdraw(int number, float value);
	void deposit(int number, float value);
	void transfer(int origin, int destination, float value);
	
}
