//Classe derivada
public class Corrente extends Conta{


    public Corrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("--- Extrato da Conta Corrente ---");
        imprimirInformacoes();
    }
}
