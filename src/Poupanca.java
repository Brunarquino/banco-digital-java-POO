//Classe derivada
public class Poupanca extends Conta{


    public Poupanca(Cliente cliente, double saldo) {
        super(cliente, saldo);
    }



    @Override
    public String toString() {
        return "Poupanca{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                '}';
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("--- Extrato da Conta Poupança ---");
        imprimirInformacoes();
    }
}
