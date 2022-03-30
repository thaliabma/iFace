package entities;
import java.util.Scanner;

class iFace { 
	public static void Menu(){
		System.out.printf("\n\nSeja bem-vindo(a) ao iFace!\n" );
		System.out.printf("Digite a opção que deseja entrar: \n");
		System.out.printf("1- Criar conta \n");
		System.out.printf("2- Entrar\n");
		System.out.printf("3- Criar/Editar perfil\n");
		System.out.printf("4- Adicionar amigos \n");
		System.out.printf("5- Envio de mensagens \n");
		System.out.printf("6- Sair \n");

	}
}


class Conta { 
	public static void LOGIN(int usuario, String login[], String senha[], String nome[]){
		
		
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
	
	public static void Editar(int usuario,String login[], String senha[], String nome[]){
		int ID = 0;

		 System.out.print("\n\n----- Editar Perfil -----\n");
		 Scanner Login = new Scanner(System.in);
		 System.out.print("Digite o nome de usuário: ");
		 String nomee = Login.next();
		 for(int i = 0; i < usuario; i++) {
	        	if(login[i] == nomee) {
	        		ID = i;
	        		break;
	        	}
	        }
		 System.out.print("Alterar Senha: ");
        String senha_enter= Login.next();
        senha[ID]= senha_enter;
		System.out.print("Alterar nome de usuário:");
        String nome_enter = Login.next();
        nome[ID]= nome_enter;
	}
}

class Logar{
	public static void Entrar(int usuario,String login[], String senha[], String nome[]){
		 Scanner Logar = new Scanner(System.in);	
		 int ID = 0;
		 System.out.print("Login: ");
	      String nome_enter = Logar.next();
	        for(int i = 0; i < usuario; i++) {
	        	if(login[i] == nome_enter) {
	        		ID = i;
	        		break;
	        	}
	        }
	        
	      System.out.print("Senha: ");
	      String senha_enter= Logar.next();
	      System.out.print("Bem-vindo(a), " + nome[ID]);

		 
	}
}

public class Main {
	
	public static void main(String[] args) {
		
		iFace.Menu();
		Scanner Enter = new Scanner(System.in);
		System.out.print("Qual a opção?:");
		int enter = Enter.nextInt();
		int usuarios = 0;
		String login[];
		login = new String[1000]; 
		String senha[];
		senha = new String[1000];
		String nome[];
		nome = new String[1000];
		
		while(enter != 6) {
			
			
			switch (enter) {
			case 1:
				
				Conta.LOGIN(usuarios, login, senha, nome);
				usuarios++;
				break;
			case 2:
				Logar.Entrar(usuarios, login, senha, nome);
				break;
			case 3:
				Conta.Editar(usuarios, login, senha, nome);
				System.out.print("\n Perfil alterado com sucesso!\n");
				break;
			case 4:
				System.out.print("EM BREVE!");
				break;
				case 5:
					System.out.print("EM BREVE!");
					break;
				case 6:
					break;
			default : 
				System.out.print("EM BREVE!");
				
			}
			iFace.Menu();
			System.out.print("Qual a opção?:");
			enter = Enter.nextInt();
		}
		
		 System.out.print("\nObrigada por usar nossa aplicação!\n");

	}
	
}
