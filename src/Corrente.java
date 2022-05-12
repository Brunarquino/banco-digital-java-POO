//Classe derivada
public class Corrente extends Conta{

    public Corrente(Cliente cliente, double saldo) {
        super(cliente, saldo);
    }



    @Override
    public String toString() {
        return "Corrente{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                '}';
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("--- Extrato da Conta Corrente ---");
        imprimirInformacoes();
    }
}
