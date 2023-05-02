package Model.Entity;

import java.util.Scanner;

import Model.DAO.UsuarioDAO;
import Model.Entity.Enums.Naipe;
import Model.Entity.Enums.Valor;
import Model.Service.UsuarioService;

public class Game {
	public static Scanner scanner = new Scanner(System.in);
	
	public static void telaInicio(String caminho, Usuario[] usuarios) {
	    int opcao;
	    String nome,senha;

	    do {
	        System.out.println("================================\n");    
	        System.out.println("SEJA BEM-VINDO AO GAME ASCENSION ");
	        System.out.println("================================\n\n");
	        System.out.println("Digite 1 para realizar o login\nDigite 2 para realizar o cadastro\nDigite 3 para sair da aplicação\nDigite 4 para ver usuarios cadastrados");
	        System.out.print("Opção escolhida: ");
	        opcao = scanner.nextInt();
	        scanner.nextLine(); // limpa o buffer do teclado

	        switch (opcao) {
	            case 1:
	            	 System.out.print("Digite o login: ");
	         	    nome = scanner.next();
	         	    System.out.print("Digite a senha: ");
	         	    senha = scanner.next();
	         	    Usuario jogador = UsuarioDAO.fazerLogin(caminho, nome, senha);

	         	    if (jogador != null) {
	         	        System.out.println("Login realizado com sucesso. Dados do jogador:");
	         	        UsuarioService.exibirPainelDeUsuario(jogador);
	         	    } else {
	         	        System.out.println("Não foi possível fazer o login. Verifique as informações de login e senha.");
	         	    }
	                break;
	            case 2:
	            	System.out.print("Digite o nome do usuario:");
	        		nome = scanner.next();
	        		System.out.print("Digite a senha do usuario:");
	        		senha = scanner.next();
	        		UsuarioDAO.cadastrarUsuario(caminho, nome, senha);
	                break;
	            case 3:
	                System.out.println("Saindo da aplicação...");
	                break;
	            case 4:
	            	System.out.println("Mostrando usuarios cadastrados...");
	            	usuarios = UsuarioDAO.lerUsuariosDoArquivo(caminho);
	    		    for (Usuario usuario : usuarios) {
	    		        System.out.println(usuario.getLogin() + " vencidas " + usuario.getVencidas());
	    		    }
	            	break;
	            default:
	                System.out.println("Opção inválida! Tente novamente.\n");
	                break;
	        }

	    } while (opcao != 3);

	    scanner.close();
	}
	
	public static void main(String []args) {
		
		/*
		String caminho = "C:\\Users\\Usuário\\Documents\\GitHub\\Ascencion\\src\\Database\\usuarios.txt";
		 Usuario[] usuarios = UsuarioDAO.lerUsuariosDoArquivo(caminho);
		    for (Usuario usuario : usuarios) {
		        System.out.println(usuario.toString());
		    }
		    
		System.out.print("Digite o nome do usuario:");
		String nome = scanner.next();
		System.out.print("Digite a senha do usuario:");
		String senha = scanner.next();
		UsuarioDAO.cadastrarUsuario(caminho, nome, senha);
		 
		usuarios = UsuarioDAO.lerUsuariosDoArquivo(caminho);
	    for (Usuario usuario : usuarios) {
	        System.out.println(usuario.toString());
	    }
	    
	    System.out.print("Digite o login: ");
	    nome = scanner.next();
	    System.out.print("Digite a senha: ");
	    senha = scanner.next();
	    Usuario jogador = UsuarioDAO.fazerLogin(caminho, nome, senha);

	    if (jogador != null) {
	        System.out.println("Login realizado com sucesso. Dados do jogador:");
	        UsuarioService.exibirPainelDeUsuario(jogador);
	    } else {
	        System.out.println("Não foi possível fazer o login. Verifique as informações de login e senha.");
	    }
		*/
		

		Monstro monster = new Monstro();
		monster.adicionarCartas();
		monster.embaralhar();
		System.out.println(monster.toString());
		monster.pegarCartas();
		monster.mostrarCartasJogadas();
		   
		Baralho baralho = new Baralho();
		
		String caminho = "C:\\Users\\Usuário\\Documents\\GitHub\\Ascencion\\src\\Database\\usuarios.txt";
		Usuario[] usuarios = null;
		telaInicio(caminho, usuarios);
		
		
		/*
		baralho.limpar(); //Criação de um baralho aleatorio
		for (int i = 0; i < 50; i++) {
		    Carta carta = new Carta(Naipe.values()[new Random().nextInt(Naipe.values().length)], Valor.values()[new Random().nextInt(Valor.values().length)]);
		    baralho.adicionarCarta(carta);
		} */
		
		 System.out.print("BEM-VINDO AO GAME ASCENSION\n\n");
		 Jogador jogador = new Jogador(); // Jogador criado
		 String heroi ="", heroi2 ="";
			System.out.print("Digite o nome do seu jogador:");
			String name = scanner.next();
			jogador.setNome(name);
			System.out.print("Escolha a sua classe:\n[G]uerreiros\n[P]aladinos\n[A]assassinos\n[M]agos\nSua opção:");
			char opcao = scanner.next().charAt(0);
			switch(opcao) {
			case 'G': 
			case 'g':
				heroi = "Guerreiros";
				break;
			case 'P': 
			case 'p':
				heroi = "Paladinos";
				break;
			case 'A': 
			case 'a':
				heroi = "Assassinos";
				break;
			case 'M': 
			case 'm':
				heroi = "Magos";
				break;
			default:
				System.out.println("Opção invalida");
			}
			
			System.out.print("Escolha outra opção de classe:\n[G]uerreiros\n[P]aladinos\n[A]assassinos\n[M]agos\nSua opção:");
			char opcao2 = scanner.next().charAt(0);
			switch(opcao2) {
			case 'G': 
			case 'g':
				heroi2 = "Guerreiros";
				break;
			case 'P': 
			case 'p':
				heroi2 = "Paladinos";
				break;
			case 'A': 
			case 'a':
				heroi2 = "Assassinos";
				break;
			case 'M': 
			case 'm':
				heroi2 = "Magos";
				break;
			default:
				System.out.println("Opção invalida");
			}
			
			System.out.print("Herois escolhidos: " + heroi + " e " + heroi2 + "\n");
	        
			Baralho baralhoJogador = new Baralho();
			baralhoJogador.limpar();
			
			for (Carta carta : baralho.getCartas()) {
			    if (carta.getNaipe().equals(heroi)) 
			    	baralhoJogador.adicionarCarta(carta);
			}
			
			for (Carta carta : baralho.getCartas()) {
			    if (carta.getNaipe().equals(heroi2)) 
			    	baralhoJogador.adicionarCarta(carta);
			}
			jogador.setBaralhoDeClasse(baralhoJogador);
			System.out.print(jogador.toString());
		
	}
}