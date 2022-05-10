import java.util.ArrayList;
import java.util.List;

//Classe Base
//Abstração dessa classe garante que ninguem vai instanciar elas
//Só pode extanciar suas subclasses
public abstract class Conta implements Servicos {


    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;


    //só os Get, por não ter a necessidade de outros alterarem os dados
    public int getAgencia() {
        return agencia;
    }
    public int getNumero() {
        return numero;
    }
    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {return cliente;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if(verificarSeTemValor(valor) ==  true)saldo -= valor;
        else System.out.println("Você não tem essa quantia");
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(verificarSeTemValor(valor) ==  true) {
            this.sacar(valor);
            contaDestino.depositar(valor);
        }else{
            System.out.println("Você não tem essa quantia");
        }

    }

    protected void imprimirInformacoes() {
        System.out.println("Titular: " + cliente.getNome());
        System.out.println(String.format("Agencia: %d", this.agencia) );
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    private boolean verificarSeTemValor(double valor) {

        if(valor <= saldo && valor > 0){
            return true;
        }else{
            return false;
        }

    }
}
