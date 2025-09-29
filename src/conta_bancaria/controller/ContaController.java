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
		if (!accounts.isEmpty()) {
			for (var c : accounts) {
				c.view();
			}
		} else 
			System.out.println("\t╭────────────────────────────╮"
			   				+"\n\t│ Não há contas cadastradas. │"
			   				+"\n\t╰────────────────────────────╯");
	}

	@Override
	public void register(Conta acc) {
		accounts.add(acc);
		System.out.println("\t╭───────────────────────────────╮"
				   		+"\n\t│ Conta cadastrada com sucesso. │"
				   		+"\n\t╰───────────────────────────────╯");

	}

	@Override
	public void update(Conta acc) {
		var search = search(acc.getNumber());
		
		if (search != null) {
			accounts.set(accounts.indexOf(search), acc);
			System.out.println("\t╭─────────────────────────────────────╮"
						   	+"\n\t│ A conta foi atualizada com sucesso. │"
						   	+"\n\t╰─────────────────────────────────────╯");
		} else
			System.err.println("\t╭─────────────────────────────╮"
							+"\n\t│ A conta não foi encontrada. │"
							+"\n\t╰─────────────────────────────╯");
	}

	@Override
	public void searchByNumber(int number) {
		var c = search(number);
		if(c != null) 
			c.view();
		else 
			System.err.println("\t╭─────────────────────────────╮"
					  		+"\n\t│ A conta não foi encontrada. │"
					  		+"\n\t╰─────────────────────────────╯");
	}

	@Override
	public void delete(int number) {
		var c = search(number);
		if (c != null) {
			if (accounts.remove(c)) 
				System.out.println("\t╭───────────────────────────────────╮"
						  		+"\n\t│ A conta foi deletada com sucesso. │"
						  		+"\n\t╰───────────────────────────────────╯");
		} else 
			System.err.println("\t╭─────────────────────────────╮"
						    +"\n\t│ A conta não foi encontrada. │"
							+"\n\t╰─────────────────────────────╯");
	}

	@Override
	public void withdraw(int number, float value) {
		var c = search(number);
		if(c != null) {
			if(c.withdraw(value))
				System.out.println("\nSaque efetuado com sucesso.");
		} else 
			System.err.println("\t╭─────────────────────────────╮"
					  		+"\n\t│ A conta não foi encontrada. │"
					  		+"\n\t╰─────────────────────────────╯");
	}

	@Override
	public void deposit(int number, float value) {
		var c = search(number);
		if(c != null) {
			c.deposit(value);
			System.out.println("\nDepósito efetuado com sucesso.");
		} else 
			System.err.println("\t╭─────────────────────────────╮"
					  		+"\n\t│ A conta não foi encontrada. │"
					  		+"\n\t╰─────────────────────────────╯");
	}

	@Override
	public void transfer(int origin, int destination, float value) {
		var accOrigin = search(origin);
		var accDest = search(destination);
		if(accOrigin != null && accDest != null) {
			if(accOrigin.withdraw(value)) {
				accDest.deposit(value);
				System.out.println("\nTransferência efetuada com sucesso.");
			}	
		} else 
			System.err.println("\t╭──────────────────────────────────────────────────────────╮"
					  		+"\n\t│ A conta de origem e/ou de destino não foram encontradas. │"
					  		+"\n\t╰──────────────────────────────────────────────────────────╯");
	}
	
	public int generateId() {
		return ++number;
	}
	
	public Conta search(int number) {
		for(var c : accounts) {
			if(c.getNumber() == number) 
				return c;
		}	
		return null;
	}
}