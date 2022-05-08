import com.sun.source.tree.Tree;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNome("Bruna");

        Conta contaCorrente = new Corrente(cliente);
        Conta contaPoupanca = new Poupanca(cliente);

        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();



    }
}
