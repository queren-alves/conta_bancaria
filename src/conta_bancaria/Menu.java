package conta_bancaria;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;

public class Menu {

	private static final Scanner sc = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();
	
	public static void main(String[] args) {
		mainMenu();
	}
	
	public static void header() {
		LocalDateTime now = LocalDateTime.now();
        String time = now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println("\t╭─────────────────────────────────────────────────╮"
        				+"\n\t│           ─────── Banco Atlas ───────           │"
        				+"\n\t│     Segurança e confiança em cada transação     │"
        				+"\n\t│        Data/Hora: "+ time + "           │"
        				+"\n\t╰─────────────────────────────────────────────────╯");
	}
	
	public static void mainMenu() {
		Menu.header();
		boolean start = true;
        while(start) {
        	
		System.out.println("\t╭─────────────────────────────────────────────────╮"
						+"\n\t│         ─────── Menu Principal ───────          │"
						+"\n\t├─────────────────────────────────────────────────┤"
						+"\n\t│        ╭───────────────────────────────╮        │"
						+"\n\t│        │1. Cadastro e Gestão de Contas │        │"
						+"\n\t│        ╰───────────────────────────────╯        │"
						+"\n\t│        ╭───────────────────────────────╮        │"
						+"\n\t│        │2. Consultar Contas            │        │"
						+"\n\t│        ╰───────────────────────────────╯        │"
						+"\n\t│        ╭───────────────────────────────╮        │"
						+"\n\t│        │3. Operações Financeiras       │        │"
						+"\n\t│        ╰───────────────────────────────╯        │"
						+"\n\t│        ╭───────────────────────────────╮        │"
						+"\n\t│        │0. Sair                        │        │"
						+"\n\t│        ╰───────────────────────────────╯        │"
						+"\n\t╰─────────────────────────────────────────────────╯"); 

            System.out.print("Escolha uma opção: ");
            int op = readOp();

            switch(op) {
                case 1:
                    accMenu();
                    break;
                case 2:
                    viewMenu();
                    break;
                case 3:
                    operationMenu();
                    break;
                case 0:
                    start = false;
                    break;
                default:
                    System.err.println("\t╭────────────────────────────────────╮"
                    				+"\n\t│ Opção inválida! Escolha novamente. │"
                    				+"\n\t╰────────────────────────────────────╯");
            }
        }
        
        System.out.println(end());
        sc.close();
	}
	
	public static void accMenu() {
		boolean start = true;
        while(start) {
	
		System.out.println("\t╭─────────────────────────────────────────────────╮"
						+"\n\t│             ───────  Contas ───────             │"
						+"\n\t├─────────────────────────────────────────────────┤"
						+"\n\t│         ╭─────────────╮ ╭─────────────╮         │"
						+"\n\t│         │1. Criar     │ │2. Atualizar │         │"
						+"\n\t│         ╰─────────────╯ ╰─────────────╯         │"
						+"\n\t│         ╭─────────────╮ ╭─────────────╮         │"
						+"\n\t│         │3. Apagar    │ │0. Voltar    │         │"
						+"\n\t│         ╰─────────────╯ ╰─────────────╯         │"
						+"\n\t╰─────────────────────────────────────────────────╯"); 
		
			System.out.print("Escolha uma opção: ");
			int op = readOp();

			switch(op) {
        		case 1:
        			System.out.println("\t╭─────────────────────────╮"
									+"\n\t│       Criar Conta       │"
									+"\n\t╰─────────────────────────╯");
        			register();
        			sc.nextLine();
        			keyPress();
        			break;
        		case 2:
        			System.out.println("\t╭─────────────────────────╮"
									+"\n\t│     Atualizar Conta     │"
									+"\n\t╰─────────────────────────╯");
        			update();
        			keyPress();
        			break;
        		case 3:
        			System.out.println("\t╭─────────────────────────╮"
									+"\n\t│      Apagar Conta       │"
									+"\n\t╰─────────────────────────╯");
        			delete();
        			keyPress();
        			break;
        		case 0:
        			start = false;
        			break;
        		default:
        			System.err.println("\t╭────────────────────────────────────╮"
            						+"\n\t│ Opção inválida! Escolha novamente. │"
            						+"\n\t╰────────────────────────────────────╯");
			}
       }
    }
	
	public static void viewMenu() {
		boolean start = true;
        while(start) {
	
		System.out.println("\t╭─────────────────────────────────────────────────╮"
						+"\n\t│        ───────  Consultar Conta ───────         │"
						+"\n\t├─────────────────────────────────────────────────┤"
						+"\n\t│      ╭────────────────╮ ╭────────────────╮      │"
						+"\n\t│      │1. Buscar Conta │ │2. Listar Todas │      │"
						+"\n\t│      ╰────────────────╯ ╰────────────────╯      │"
						+"\n\t│               ╭────────────────╮                │"
						+"\n\t│               │0. Voltar       │                │"
						+"\n\t│               ╰────────────────╯                │"
						+"\n\t╰─────────────────────────────────────────────────╯"); 
		
			System.out.print("Escolha uma opção: ");
			int op = readOp();

			switch(op) {
        		case 1:
        			System.out.println("\t╭─────────────────────────╮"
    								+"\n\t│ Buscar conta por número │"
    								+"\n\t╰─────────────────────────╯");
        			searchByNumber();
        			keyPress();
        			break;
        		case 2:
        			System.out.println("\t╭──────────────────────────╮"
									+"\n\t│ Lista de todas as contas │"
									+"\n\t╰──────────────────────────╯");
        			viewAll();
        			sc.nextLine();
        			keyPress();
        			break;
        		case 0:
        			start = false;
        			break;
        		default:
        			System.err.println("\t╭────────────────────────────────────╮"
            						+"\n\t│ Opção inválida! Escolha novamente. │"
            						+"\n\t╰────────────────────────────────────╯");
			}
       }
    }
	
	public static void operationMenu() {
		boolean start = true;
        while(start) {
	
		System.out.println("\t╭─────────────────────────────────────────────────╮"
						+"\n\t│      ───────  Operações Financeiras ───────     │"
						+"\n\t├─────────────────────────────────────────────────┤"
						+"\n\t│        ╭──────────────╮ ╭──────────────╮        │"
						+"\n\t│        │1. Sacar      │ │2. Depositar  │        │"
						+"\n\t│        ╰──────────────╯ ╰──────────────╯        │"
						+"\n\t│        ╭──────────────╮ ╭──────────────╮        │"
						+"\n\t│        │3. Transferir │ │0. Voltar     │        │"
						+"\n\t│        ╰──────────────╯ ╰──────────────╯        │"
						+"\n\t╰─────────────────────────────────────────────────╯"); 
		
			System.out.print("Escolha uma opção: ");
			int op = readOp();

			switch(op) {
        		case 1:
        			System.out.println("Sacar.");
        			break;
        		case 2:
        			System.out.println("Depositar.");
        			break;
        		case 3:
        			System.out.println("Transferir.");
        			break;
        		case 0:
        			start = false;
        			break;
        		default:
        			System.err.println("\t╭────────────────────────────────────╮"
            						+"\n\t│ Opção inválida! Escolha novamente. │"
            						+"\n\t╰────────────────────────────────────╯");
			}
       }
    }

	public static int readOp() {
        while (!sc.hasNextInt()) {
        	 System.err.println("\n\t╭──────────────────────────╮"
             				   +"\n\t│ Digite um número válido! │"
             				   +"\n\t╰──────────────────────────╯");
            sc.next();
            System.out.print("Escolha novamente: ");
        }
        return sc.nextInt();
    }
	
	public static String end() {
		return			   "\t╭──────────────────────────────╮"
						+"\n\t│ Sistema encerrado. Até logo! │"
						+"\n\t│                              │"
						+"\n\t│ Desenvolvido por Quéren Alves│"
						+"\n\t╰──────────────────────────────╯";
		
	}
	
	public static void keyPress() {
		System.out.println("\t╭────────────────────────────────╮"
						+"\n\t│ Pressione ENTER para continuar │"
						+"\n\t╰────────────────────────────────╯");
		sc.nextLine();
	}
	
	private static void viewAll() {
		contaController.viewAll();
	}
	
	private static void register() {
		System.out.print("\tDigite o número da agência: ");
		int agency = sc.nextInt();
		System.out.print("\tDigite o nome do titular: ");
		sc.skip("\\R");
		String holder = sc.nextLine();
		System.out.print("\tDigite o tipo da conta (1- CC | 2- CP): ");
		int type = sc.nextInt();
		System.out.print("\tDigite o saldo inicial: ");
		float balance = sc.nextFloat();
		
		switch(type) {
		case 1 ->{
			System.out.print("\tDigite o limite inicial: ");
			float limit = sc.nextFloat();
			contaController.register(new ContaCorrente(contaController.generateId(), agency, type, holder, balance, limit));
		}
		case 2 -> {
			System.out.print("\tDigite o dia do aniversário da conta: ");
			int anniversary = sc.nextInt();
			contaController.register(new ContaPoupanca(contaController.generateId(), agency, type, holder, balance, anniversary));
		}
		default -> System.err.println("\t╭─────────────────────────╮"
		 						   +"\n\t│ Tipo de conta inválido. │"
		 						   +"\n\t╰─────────────────────────╯");
		}
	}
	
	private static void searchByNumber() {
		System.out.print("\nDigite o número da conta: ");
		int number = sc.nextInt();
		sc.nextLine();
		contaController.searchByNumber(number);
	}
	
	private static void delete() {
		System.out.print("\nDigite o número da conta: ");
		int number = sc.nextInt();
		sc.nextLine();
		
		Conta c = contaController.search(number);
		if (c != null) {
			System.out.print("\nTem certeza que deseja excluir está conta? (S/N): ");
			String confirm = sc.nextLine();
			
			if (confirm.equalsIgnoreCase("s")) 
				contaController.delete(number);
			else
				System.out.println("\t╭─────────────────────╮"
						   		+"\n\t│ Operação cancelada. │"
						   		+"\n\t╰─────────────────────╯");
		} else 
			System.err.println("\t╭─────────────────────────────╮"
					 		+"\n\t│ A conta não foi encontrada. │"
					 		+"\n\t╰─────────────────────────────╯");
		
	}
	
	private static void update() {
		System.out.print("\n\tDigite o número da conta: ");
		int number = sc.nextInt();
		sc.nextLine();
		
		Conta c = contaController.search(number);
		if (c != null) {
			int agency = c.getAgency();
			String holder = c.getHolder();
			int type = c.getType();
			float balance = c.getBalance();
			
			System.out.printf("\tNome do titular atual: %s\n\tNovo titular (Pressione ENTER para manter o nome do titular atual): ", holder);
			String input = sc.nextLine();
			holder = input.isEmpty() ? holder : input;
			
			System.out.printf("\tSaldo atual: %.2f\n\tNovo saldo (Pressione ENTER para manter o valor atual): ", balance);
			input = sc.nextLine();
			balance = input.isEmpty() ? balance : Float.parseFloat(input);
			
			switch(type) {
			case 1 ->{
				float limit = ((ContaCorrente) c).getLimit(); //casting: transforma um objeto em outro
				
				System.out.printf("\tLimite atual: %.2f\n\tNovo limite (Pressione ENTER para manter o valor atual): ", limit);
				input = sc.nextLine();
				limit = input.isEmpty() ? limit : Float.parseFloat(input);
				contaController.update(new ContaCorrente(number, agency, type, holder, balance, limit));
			}
			case 2 -> {
				int anniversary = ((ContaPoupanca) c).getAnniversary();
				contaController.update(new ContaPoupanca(number, agency, type, holder, balance, anniversary));
			}
			default -> System.err.println("\t╭─────────────────────────╮"
			 						   +"\n\t│ Tipo de conta inválido. │"
			 						   +"\n\t╰─────────────────────────╯");
			}
		} else 
			 	System.err.println("\t╭─────────────────────────────╮"
			 				    +"\n\t│ A conta não foi encontrada. │"
			 					+"\n\t╰─────────────────────────────╯");
	}
	
}