package conta_bancaria;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {

	private static final Scanner sc = new Scanner(System.in);
	
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
                    System.out.println("\t╭────────────────────────────────────╮"
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
        			System.out.println("Criar Conta.");
        			break;
        		case 2:
        			System.out.println("Atualizar Conta.");
        			break;
        		case 3:
        			System.out.println("Apagar Conta.");
        			break;
        		case 0:
        			start = false;
        			break;
        		default:
        			System.out.println("\t╭────────────────────────────────────╮"
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
        			System.out.println("Buscar Conta.");
        			break;
        		case 2:
        			System.out.println("Listar Contas.");
        			break;
        		case 0:
        			start = false;
        			break;
        		default:
        			System.out.println("\t╭────────────────────────────────────╮"
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
        			System.out.println("\t╭────────────────────────────────────╮"
            						+"\n\t│ Opção inválida! Escolha novamente. │"
            						+"\n\t╰────────────────────────────────────╯");
			}
       }
    }

	public static int readOp() {
        while (!sc.hasNextInt()) {
        	 System.out.println("\t╭──────────────────────────╮"
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
}