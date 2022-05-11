
import java.util.*;


public class Main {
    public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Integer numeroAcesso = 1000;
		Integer clienteNumeroAcesso = 0;

		Map<Integer, Conta> contasPoupanca = new HashMap<>();
		Map<Integer, Conta> contasCorrente = new HashMap<>();
		int resposta = 0;

		do{

			do {
				System.out.println("\t===== Banco Digital BA =====\t");
				System.out.println("\t==== Seja Bem vindo(a)! ====\t");
				System.out.println("1 - Acessar Conta");
				System.out.println("2 - Criar Conta");
				System.out.println("3 - Sair do banco");
				String respostaS = scan.nextLine();
				try {
					resposta = Integer.parseInt(respostaS);

				}catch (NumberFormatException e){
					System.out.println("\n");
				}
				if(resposta != 1 & resposta != 2 & resposta != 3){
					System.out.println("Valor Invalido!");
				}
			}while (resposta != 1 & resposta != 2 & resposta != 3);
			if(resposta == 3)break;



			switch (resposta){
				case 1:
					System.out.println("Digite seu número de Identificação");
					clienteNumeroAcesso  = scan.nextInt();
					boolean existeContaPoupaca = false;
					boolean existeContaCorrente = false;
					for (Map.Entry<Integer, Conta> contas : contasCorrente.entrySet()) {
						if(contas.getKey() == clienteNumeroAcesso) existeContaCorrente = true;
					}
					for (Map.Entry<Integer, Conta> contas : contasPoupanca.entrySet()) {
						if(contas.getKey() == clienteNumeroAcesso) existeContaPoupaca = true;
					}

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
						resposta = 3;
					}
					if(resposta == 3)break;

					break;
				case 2:
					numeroAcesso++;
					System.out.println("Digite seu nome: ");
					String nome = scan.nextLine();
					Cliente cliente = new Cliente();
					cliente.setNome(nome);
					resposta = decidirQualTipoDeContaCriar(resposta, nome, numeroAcesso, scan);

					switch (resposta){
						case 1:
							contasCorrente.put(numeroAcesso, new Corrente(cliente, 0d));
							break;
						case 2:
							contasPoupanca.put(numeroAcesso, new Poupanca(cliente, 0d));
							break;
						default:
							break;
					}
					System.out.println("\nConta criada com sucesso!");
					break;
				default:
					break;
			}

		}while (resposta == 100);

		System.out.println("Finalizou o programa!");

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

		System.out.println("Abri conta corrente");


	}

	private static void AcessarContaPoupanca(Integer ClienteNumeroAcesso) {

		System.out.println("Abri conta corrente");

	}


		


}
