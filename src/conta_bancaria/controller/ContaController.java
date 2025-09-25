package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private List<Conta> accounts = new ArrayList<Conta>();
	int number = 0;

	@Override
	public void viewAll() {
		for (var c : accounts) {
			c.view();
		}
	}

	@Override
	public void register(Conta acc) {
		accounts.add(acc);
		System.out.println("Conta cadastrada com sucesso.");

	}

	@Override
	public void update(Conta acc) {

	}

	@Override
	public void searchByNumber(int number) {

	}

	@Override
	public void delete(int number) {

	}

	@Override
	public void withdraw(int number, float value) {

	}

	@Override
	public void deposit(int number, float value) {

	}

	@Override
	public void withdraw(int origin, int destination, float value) {

	}
}