
import javax.swing.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
		Conta poupanca = null;
		Conta corrente = null;

		System.out.println("\t----Seja Bem Vindo(a) ao Banco digital BA----\t");
		System.out.println("\t Vamos criar uma conta? \t");
		System.out.println("\t Digite seu nome: \t");
		String nome = scan.next();
		Cliente cliente= new Cliente();
		cliente.setNome(nome);

		System.out.println("Deseja criar uma conta:");
		System.out.println("1 - Corrente");
		System.out.println("2 - Poupança");
		int tipoDeConta = scan.nextInt();
		String contaCriada = "";

		switch (tipoDeConta){
			case 1:
				corrente = new Corrente(cliente);
				contaCriada = "corrente";
				System.out.println("Conta Corrente criada!");
				corrente.imprimirExtrato();
				System.out.println("Deseja criar uma conta poupança também?");
				break;
			case 2:
				poupanca = new Poupanca(cliente);
				System.out.println("Conta Poupança criada!");
				contaCriada = "poupanca";
				poupanca.imprimirExtrato();
				System.out.println("Deseja criar uma conta Corrente também?");
				break;
			default:
				break;
		}
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		int resposta = scan.nextInt();

		if(resposta == 1){
			switch(contaCriada){
				case "corrente":
					poupanca = new Poupanca(cliente);
					System.out.println("Conta Popança Criada!");
					poupanca.imprimirExtrato();
					break;
				case "poupanca":
					corrente = new Corrente(cliente);
					System.out.println("Conta Corrente Criada!");
					corrente.imprimirExtrato();
					break;
				default:
					break;
			}
		}

		do {
			System.out.println(cliente.getNome() + ", Qual conta deseja acessar?");
			System.out.println("1 - Corrente");
			System.out.println("2 - Poupança");
			System.out.println("0 - sair");
			resposta = scan.nextInt();

			int numeroConta = 0;

			switch (resposta){
				case 1:
					break;
				case 2:

					break;
				default:
					System.exit(0);
					break;
			}

			System.out.println(cliente.getNome() + ", Deseja realizar qual serviços na sua conta?");
			System.out.println("1 - Depositar");
			System.out.println("2 - Sacar");
			System.out.println("3 - tranferir");
			System.out.println("4 - Imprimir Extrato");
			System.out.println("0 - sair");
			resposta = scan.nextInt();



		}while (resposta == 0);

		System.out.println("Finalizando Sistema...");

//		cc.depositar(100);
//        cc.sacar(100);
//
//
//		cc.imprimirExtrato();
//		poupanca.imprimirExtrato();



    }

}
