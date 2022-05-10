
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


			switch (resposta){
				case 1:
					System.out.println("Digite seu número de Identificação");
					clienteNumeroAcesso  = scan.nextInt();
					AcessarConta(clienteNumeroAcesso);
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
					break;
				default:
					break;
			}

		}while (resposta == 100);

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

	private static void AcessarConta(Integer ClienteNumeroAcesso) {

	}


		


}
