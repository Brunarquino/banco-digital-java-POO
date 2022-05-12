
import java.util.*;


public class Main {
    public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int numeroAcesso = 1000;
		Integer clienteNumeroAcesso = 0;

		Map<Integer, Conta> contasPoupanca = new HashMap<>();
		Map<Integer, Conta> contasCorrente = new HashMap<>();

		Conta contaDestino = null;
		int resposta;

		do{
			resposta = menuPrincipal(scan);
			if(resposta == 0)break;
			boolean existeContaPoupaca = false;
			boolean existeContaCorrente = false;

			switch (resposta){
				case 1:
					System.out.println("Digite seu número de Identificação");
					clienteNumeroAcesso  = scan.nextInt();
					existeContaPoupaca = ExisteContaPoupaca(clienteNumeroAcesso, contasPoupanca);
					existeContaCorrente = ExisteContaCorrente(clienteNumeroAcesso, contasCorrente);


					if(existeContaCorrente & existeContaPoupaca){
						resposta = decidirQualTipoDeContaAbrir(scan);
					}/*else if (existeContaCorrente) {
						resposta = 1;
					}*/else if(existeContaPoupaca){
						resposta = 2;
					}else{
						System.out.println("Conta não existe!");
						resposta = 0;
					}

					double valor;

					switch (resposta){
						case 1:
							do { //Acessar conta corrente
								resposta = AcessarContaCorrente(clienteNumeroAcesso, scan);
								switch (resposta) {
									case 1:
										System.out.println("Digite o valor que deseja depositar?");
										valor = scan.nextDouble();
										for (Map.Entry<Integer, Conta> contas : contasCorrente.entrySet()) {
											if(contas.getKey().equals(clienteNumeroAcesso)){
												contas.getValue().depositar(valor);
												System.out.println("Valor de depositado!");
											}
										}

										break;
									case 2:
										System.out.println("Digite o valor que deseja sacar?");
										valor = scan.nextDouble();
										for (Map.Entry<Integer, Conta> contas : contasCorrente.entrySet()) {

											if(contas.getKey().equals(clienteNumeroAcesso)){
												contas.getValue().sacar(valor);
												System.out.println("Valor Sacado!");
											}
										}
										break;
									case 3:
										System.out.println("Digite o valor que deseja tranferir?");
										valor = scan.nextDouble();

										System.out.println("Digite o numero de acesso da conta que deseja tranferir?");
										Integer numeroAcessoContaDestino = scan.nextInt();

										existeContaPoupaca = ExisteContaPoupaca(numeroAcessoContaDestino, contasPoupanca);
										existeContaCorrente = ExisteContaCorrente(numeroAcessoContaDestino, contasCorrente);

										if(existeContaCorrente & existeContaPoupaca){
											resposta = decidirQualTipoDeContaAbrir(scan);
										}else if (existeContaCorrente) {
											resposta = 1;
										}else{
											resposta = 2;
										}

										switch (resposta){
											case 1:
												contaDestino = contaDestinoCorrente(contasCorrente, numeroAcessoContaDestino, contaDestino);
												for (Map.Entry<Integer, Conta> contas : contasCorrente.entrySet()) {
													if(contas.getKey().equals(clienteNumeroAcesso)){
														contas.getValue().transferir(valor, contaDestino);
														System.out.println("Valor Transferido!");
													}
												}
												break;
											case 2:
												contaDestino = contaDestinoPoupanca(contasPoupanca, numeroAcessoContaDestino, contaDestino);
												for (Map.Entry<Integer, Conta> contas : contasPoupanca.entrySet()) {
													if(contas.getKey().equals(clienteNumeroAcesso)){
														contas.getValue().transferir(valor, contaDestino);
														System.out.println("Valor Transferido!");
													}
												}
												break;
											default:
												System.out.println("Conta não existe!");
												break;
										}
										break;
									case 4:
										for (Map.Entry<Integer, Conta> contas : contasCorrente.entrySet()) {
											if(contas.getKey().equals(clienteNumeroAcesso)){
												contas.getValue().imprimirExtrato();
												System.out.println("Este é seu Extrato!");
											}
										}
										break;
									default:
										System.out.println("Saindo da Conta!");
										break;

								}
							}while (resposta != 5);
							break;
						case 2:
							do {
								resposta = AcessarContaPoupanca(clienteNumeroAcesso, scan);
								switch (resposta) {
									case 1:
										System.out.println("Digite o valor que deseja depositar?");
										valor = scan.nextDouble();
										for (Map.Entry<Integer, Conta> contas : contasPoupanca.entrySet()) {
											if(contas.getKey().equals(clienteNumeroAcesso)){
												contas.getValue().depositar(valor);
												System.out.println("Valor de depositado!");
											}
										}

										break;
									case 2:
										System.out.println("Digite o valor que deseja sacar?");
										valor = scan.nextDouble();
										for (Map.Entry<Integer, Conta> contas : contasPoupanca.entrySet()) {

											if(contas.getKey().equals(clienteNumeroAcesso)){
												contas.getValue().sacar(valor);
												System.out.println("Valor Sacado!");
											}
										}
										break;
									case 3:
										System.out.println("Digite o valor que deseja tranferir?");
										valor = scan.nextDouble();

										System.out.println("Digite o numero de acesso da conta que deseja tranferir?");
										Integer numeroAcessoContaDestino = scan.nextInt();

										existeContaPoupaca = ExisteContaPoupaca(numeroAcessoContaDestino, contasPoupanca);
										existeContaCorrente = ExisteContaCorrente(numeroAcessoContaDestino, contasCorrente);

										if(existeContaCorrente & existeContaPoupaca){
											resposta = decidirQualTipoDeContaAbrir(scan);
										}else if (existeContaCorrente) {
											resposta = 1;
										}else{
											resposta = 2;
										}

										switch (resposta){
											case 1:
												contaDestino = contaDestinoCorrente(contasCorrente, numeroAcessoContaDestino, contaDestino);
												for (Map.Entry<Integer, Conta> contas : contasCorrente.entrySet()) {
													if(contas.getKey().equals(clienteNumeroAcesso)){
														contas.getValue().transferir(valor, contaDestino);
														System.out.println("Valor Transferido!");
													}
												}
												break;
											case 2:
												contaDestino = contaDestinoPoupanca(contasPoupanca, numeroAcessoContaDestino, contaDestino);
												for (Map.Entry<Integer, Conta> contas : contasPoupanca.entrySet()) {
													if(contas.getKey().equals(clienteNumeroAcesso)){
														contas.getValue().transferir(valor, contaDestino);
														System.out.println("Valor Transferido!");
													}
												}
												break;
											default:
												System.out.println("Conta não existe!");
												break;
										}


										break;
									case 4:
										for (Map.Entry<Integer, Conta> contas : contasPoupanca.entrySet()) {
											if(contas.getKey().equals(clienteNumeroAcesso)){
												contas.getValue().imprimirExtrato();
												System.out.println("Este é seu Extrato!");
											}
										}

										break;
									default:
										System.out.println("Saindo da Conta!");
										break;

								}
							}while (resposta != 5);
							break;
						default:
							break;

					}


					break;
				case 2: //Criando Conta
					Cliente cliente = new Cliente();
					resposta = verificarSeTemUmaContaCriada(scan);
					String nome = "";

					if(resposta == 1){
						System.out.println("Digite seu número de Identificação");
						clienteNumeroAcesso  = scan.nextInt();
						//Verificando se esse numero de acesso existe mesmo
						existeContaPoupaca = ExisteContaPoupaca(clienteNumeroAcesso, contasPoupanca);
						existeContaCorrente = ExisteContaCorrente(clienteNumeroAcesso, contasCorrente);

						if(!existeContaCorrente & !existeContaPoupaca){
							System.out.println("Conta não existe, Criando Conta");
							resposta = 2;
						}

					}

					if(resposta == 1){
						if(existeContaCorrente & existeContaPoupaca){
							System.out.println("Você ja possui os dois tipos de conta");
							continue;
						} else if (existeContaCorrente) {
							resposta = 2;
							for(Map.Entry<Integer, Conta> conta : contasCorrente.entrySet()) {
								if (conta.getKey().equals(clienteNumeroAcesso)) {
									nome = conta.getValue().cliente.getNome();
								}
							}
							System.out.println("criando conta poupança");

						}else{
							//resposta = 1; mántem
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
						if(nome.isEmpty()) nome = scan.nextLine();
						cliente.setNome(nome);
						resposta = decidirQualTipoDeContaCriar(nome, clienteNumeroAcesso, scan);
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

		System.out.println("\nCONTAS CORRENTES: ");

		for (Map.Entry<Integer, Conta> contas : contasCorrente.entrySet()) {
			contas.getValue().imprimirExtrato();
			System.out.println("\n");
		}

		System.out.println("\nCONTAS POUPANÇA: ");
		for (Map.Entry<Integer, Conta> contas : contasPoupanca.entrySet()) {
			contas.getValue().imprimirExtrato();
			System.out.println("\n");
		}


		System.out.println("Finalizou o programa!");

    }

	private static boolean ExisteContaCorrente(Integer clienteNumeroAcesso, Map<Integer, Conta> contasCorrente) {

		return contasCorrente.containsKey(clienteNumeroAcesso);

	}

	private static boolean ExisteContaPoupaca(Integer clienteNumeroAcesso, Map<Integer, Conta> contasPoupanca) {

		return contasPoupanca.containsKey(clienteNumeroAcesso);
	}

	private static Conta contaDestinoPoupanca(Map<Integer, Conta> contasPoupanca, Integer numeroAcessoContaDestino, Conta contaDestino) {

		for (Map.Entry<Integer, Conta> contas : contasPoupanca.entrySet()) {
			if(contas.getKey().equals(numeroAcessoContaDestino)){
				contaDestino = contas.getValue();
			}
		}
		return contaDestino;
	}

	private static Conta contaDestinoCorrente(Map<Integer, Conta> contasCorrente, Integer numeroAcessoContaDestino, Conta contaDestino) {
		for (Map.Entry<Integer, Conta> contas : contasCorrente.entrySet()) {
			if(contas.getKey().equals(numeroAcessoContaDestino)){
				contaDestino = contas.getValue();
			}
		}
		return contaDestino;
	}

	private static int menuPrincipal(Scanner scan) {
		int resposta;
		do {
			System.out.println("\t===== Banco Digital BA =====\t");
			System.out.println("\t==== Seja Bem vindo(a)! ====\t");
			System.out.println("1 - Acessar Conta");
			System.out.println("2 - Criar Conta");
			System.out.println("0 - Sair do banco");
			resposta = 0;
			String respostaS = scan.nextLine();
			if(respostaS.isEmpty()) respostaS = scan.nextLine(); //Estava pulando o pedido do scanner
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

	private static int verificarSeTemUmaContaCriada(Scanner scan) {
		int resposta;
		do {
			System.out.println( "Já possui conta e deseja criar um tipo de conta nova?" );
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			resposta = 0;
			String respostaS = scan.nextLine();
			if(respostaS.isEmpty()) respostaS = scan.nextLine();
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

	private static int decidirQualTipoDeContaCriar(String nome, Integer numeroAcesso, Scanner scan) {
		int resposta;
		do {
			System.out.println("\n" + nome + " seu Numero de Acesso é " + numeroAcesso);
			System.out.println("Deseja criar uma conta ");
			System.out.println("1 - Corrente");
			System.out.println("2 - Poupança");
			resposta = 0;
			String respostaS = scan.nextLine();
			if(respostaS.isEmpty()) respostaS = scan.nextLine();
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

	private static int decidirQualTipoDeContaAbrir(Scanner scan) {
		int resposta;
		do {
			System.out.println("Você deseja entrar em qual conta? ");
			System.out.println("1 - Corrente");
			System.out.println("2 - Poupança");
			resposta = 0;
			String respostaS = scan.nextLine();
			if(respostaS.isEmpty()) respostaS = scan.nextLine();
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

	private static int AcessarContaCorrente(Integer ClienteNumeroAcesso, Scanner scan) {

		System.out.println(ClienteNumeroAcesso + " Abrir conta corrente");
		int resposta;
		do {
			System.out.println( "Você deseja?" );
			System.out.println("1 - Depositar");
			System.out.println("2 - Sacar");
			System.out.println("3 - Tranfererir");
			System.out.println("4 - Imprimir Extrato");
			System.out.println("5 - Sair");
			resposta = 0;
			String respostaS = scan.nextLine();
			if(respostaS.isEmpty()) respostaS = scan.nextLine();
			try {
				resposta = Integer.parseInt(respostaS);

			}catch (NumberFormatException e){
				System.out.println("\n");
			}
			if(resposta != 1 & resposta != 2 & resposta != 3 & resposta != 4 & resposta != 5){
				System.out.println("Valor Invalido!");
			}
		}while (resposta != 1 & resposta != 2 & resposta != 3 & resposta != 4 & resposta != 5);

		return resposta;


	}

	private static int AcessarContaPoupanca(Integer ClienteNumeroAcesso, Scanner scan) {

		System.out.println(ClienteNumeroAcesso + " Abrir conta Poupanca");
		int resposta;
		do {
			System.out.println( "Você deseja?" );
			System.out.println("1 - Depositar");
			System.out.println("2 - Sacar");
			System.out.println("3 - Tranfererir");
			System.out.println("4 - Imprimir Extrato");
			System.out.println("5 - Sair");
			resposta = 0;
			String respostaS = scan.nextLine();
			if(respostaS.isEmpty()) respostaS = scan.nextLine();
			try {
				resposta = Integer.parseInt(respostaS);

			}catch (NumberFormatException e){
				System.out.println("\n");
			}
			if(resposta != 1 & resposta != 2 & resposta != 3 & resposta != 4 & resposta != 5){
				System.out.println("Valor Invalido!");
			}
		}while (resposta != 1 & resposta != 2 & resposta != 3 & resposta != 4 & resposta != 5);


		return resposta;

	}


		


}
