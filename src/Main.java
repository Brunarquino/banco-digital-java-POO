
import java.util.*;


public class Main {
    public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Integer numeroAcesso = 1000;
		Integer clienteNumeroAcesso = 0;

		Map<Integer, Conta> contasPoupanca = new HashMap<>();
		Map<Integer, Conta> contasCorrente = new HashMap<>();

		int resposta = 1000;

		do{
			resposta = 1000;
			resposta = menuPrincipal(resposta, scan);
			if(resposta == 0)break;

			switch (resposta){
				case 1:
					System.out.println("Digite seu número de Identificação");
					clienteNumeroAcesso  = scan.nextInt();
					boolean existeContaPoupaca = false;
					boolean existeContaCorrente = false;

					if(contasCorrente.containsKey(clienteNumeroAcesso) == true) existeContaCorrente = true;
					if(contasPoupanca.containsKey(clienteNumeroAcesso) == true) existeContaPoupaca = true;

					if(existeContaCorrente == true & existeContaPoupaca == true){

						resposta = decidirQualTipoDeContaAbrir(resposta, clienteNumeroAcesso, scan);
						if(resposta == 1)AcessarContaCorrente(clienteNumeroAcesso);
						else AcessarContaPoupanca(clienteNumeroAcesso);

					} else if (existeContaCorrente == true) {
						AcessarContaCorrente(clienteNumeroAcesso);
					}else if(existeContaPoupaca == true){
						AcessarContaPoupanca(clienteNumeroAcesso);
					}else{
						System.out.println("Conta não existe!");
					}

					break;
				case 2:
					Cliente cliente = new Cliente();
					resposta = verificarSeTemUmaContaCriada(numeroAcesso, clienteNumeroAcesso, resposta, scan);
					String nome = "";
					if(resposta == 1){
						System.out.println("Digite seu número de Identificação");
						clienteNumeroAcesso  = scan.nextInt();
						boolean existeContaPoupaca2 = false;
						boolean existeContaCorrente2 = false;

						if(contasCorrente.containsKey(clienteNumeroAcesso) == true) existeContaCorrente2 = true;
						if(contasPoupanca.containsKey(clienteNumeroAcesso) == true) existeContaPoupaca2 = true;

						if(existeContaCorrente2 == true & existeContaPoupaca2 == true){
							System.out.println("Você ja possui os dois tipos de conta");
							continue;
						} else if (existeContaCorrente2 == true) {
							resposta = 2;
							for(Map.Entry<Integer, Conta> conta : contasCorrente.entrySet()) {
								if (conta.getKey().equals(clienteNumeroAcesso)) {
									nome = conta.getValue().cliente.getNome();
								}
							}
							System.out.println("criando conta poupança");

						}else if(existeContaPoupaca2 == true){
							resposta = 1;
							for(Map.Entry<Integer, Conta> conta : contasPoupanca.entrySet())  {
								if (conta.getKey().equals(clienteNumeroAcesso)) {
									nome = conta.getValue().cliente.getNome();
								}
							}
							System.out.println("criando conta corrente");

						}

						cliente.setNome(nome);

					} else{
						numeroAcesso++;
						clienteNumeroAcesso = numeroAcesso;
						System.out.println("Digite seu nome: ");
						nome = scan.nextLine();
						cliente.setNome(nome);
						resposta = decidirQualTipoDeContaCriar(resposta, nome, clienteNumeroAcesso, scan);
					}

					switch (resposta){
						case 1:
							contasCorrente.put(clienteNumeroAcesso, new Corrente(cliente, 0d));
							System.out.println("\nConta Corrente criada com sucesso!");
							break;
						case 2:
							contasPoupanca.put(clienteNumeroAcesso, new Poupanca(cliente, 0d));
							System.out.println("\nConta Poupança criada com sucesso!");
							break;
						default:
							break;
					}

					break;
				default:
					break;
			}

		}while (resposta != 100);

		System.out.println("Finalizou o programa!");

    }

	private static int menuPrincipal(int resposta, Scanner scan) {

		do {
			System.out.println("\t===== Banco Digital BA =====\t");
			System.out.println("\t==== Seja Bem vindo(a)! ====\t");
			System.out.println("1 - Acessar Conta");
			System.out.println("2 - Criar Conta");
			System.out.println("0 - Sair do banco");
			String respostaS = scan.nextLine();
			try {
				resposta = Integer.parseInt(respostaS);

			}catch (NumberFormatException e){
				System.out.println("\n");
			}
			if(resposta != 1 & resposta != 2 & resposta != 0){
				System.out.println("Valor Invalido!");
			}
		}while (resposta != 1 & resposta != 2 & resposta != 0);

		return resposta;
	}

	private static int verificarSeTemUmaContaCriada(Integer numeroAcesso, Integer clienteNumeroAcesso, int resposta, Scanner scan) {

		do {
			System.out.println( "Já possui conta e deseja criar um tipo de conta nova?" );
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			String respostaS = scan.nextLine();
			try {
				resposta = Integer.parseInt(respostaS);

			}catch (NumberFormatException e){
				System.out.println("\n");
			}
			if(resposta != 1 & resposta != 2){
				System.out.println("Valor Invalido!");
			}
		}while (resposta != 1 & resposta != 2);

		return resposta;

	}

	private static int decidirQualTipoDeContaCriar(int resposta, String nome, Integer numeroAcesso, Scanner scan) {
		do {
			System.out.println("\n" + nome + " seu Numero de Acesso é " + numeroAcesso);
			System.out.println("Deseja criar uma conta ");
			System.out.println("1 - Corrente");
			System.out.println("2 - Poupança");
			String respostaS = scan.nextLine();
			try {
				resposta = Integer.parseInt(respostaS);

			}catch (NumberFormatException e){
				System.out.println("\n");
			}
			if(resposta != 1 & resposta != 2){
				System.out.println("Valor Invalido!");
			}
		}while (resposta != 1 & resposta != 2);

		return resposta;
	}

	private static int decidirQualTipoDeContaAbrir(int resposta, Integer clienteNumeroAcesso, Scanner scan) {
		do {
			System.out.println("Você deseja entrar em qual conta? ");
			System.out.println("1 - Corrente");
			System.out.println("2 - Poupança");
			String respostaS = scan.nextLine();
			try {
				resposta = Integer.parseInt(respostaS);

			}catch (NumberFormatException e){
				System.out.println("\n");
			}
			if(resposta != 1 & resposta != 2){
				System.out.println("Valor Invalido!");
			}
		}while (resposta != 1 & resposta != 2);

		return resposta;
	}

	private static void AcessarContaCorrente(Integer ClienteNumeroAcesso) {

		System.out.println(ClienteNumeroAcesso + " Abrir conta corrente");


	}

	private static void AcessarContaPoupanca(Integer ClienteNumeroAcesso) {

		System.out.println(ClienteNumeroAcesso + " Abrir conta Poupanca");

	}


		


}
