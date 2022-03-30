package entities;
import java.util.Scanner;

class iFace { 
	public static void Menu(){
		System.out.printf("\nSeja bem-vindo(a) ao iFace!\n" );
		System.out.printf("Digite a opção que deseja entrar: \n");
		System.out.printf("1- Criar conta \n");
		System.out.printf("2- Criar/Editar perfil\n");
		System.out.printf("3- Adicionar amigos \n");
		System.out.printf("4- Envio de mensagens \n");
		System.out.printf("5- Sair \n");

	}
}


class Conta { 
	public static void LOGIN(int usuario){
		String login[];
		login = new String[1000]; 
		String senha[];
		senha = new String[1000];
		String nome[];
		nome = new String[1000];
		
		 System.out.print("\n\n----- Criar conta -----\n");
		 System.out.print("Digite um e-mail para login: ");
		Scanner Login = new Scanner(System.in);
        String login_enter = Login.next();
        login[usuario]= login_enter;
        
		System.out.print("Senha: ");
        String senha_enter= Login.next();
        senha[usuario]= senha_enter;

		System.out.print("Nome de usuário: ");
        String nome_enter = Login.next();
        nome[usuario]= nome_enter;
	}
}

public class Main {
	
	public static void main(String[] args) {
		
		iFace.Menu();
		Scanner Enter = new Scanner(System.in);
		System.out.print("Qual a opção?:");
		int enter = Enter.nextInt();
		while(enter != 5) {
			
			int usuarios = 0;
			switch (enter) {
			case 1:
				Conta.LOGIN(usuarios);
				usuarios++;
				break;
			case 2:
				System.out.print("EM BREVE!");
				break;
			case 3:
				System.out.print("EM BREVE!");
				break;
			case 4:
				System.out.print("EM BREVE!");
				break;
			default: 
				
				
			}
			iFace.Menu();
			System.out.print("Qual a opção?:");
			enter = Enter.nextInt();
		}
		
		 System.out.print("\nObrigada por usar nossa aplicação!\n");

		
        

	}
	
}
