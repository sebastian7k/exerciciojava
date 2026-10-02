public class Conta {

    protected int numeroConta;
    protected String titular;
    protected double saldo;
    protected Agencia agencia;

    public Conta(int numeroConta, String titular, double saldo, Agencia agencia){
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
        this.agencia = agencia;
    }

    public void  depositar(double valor){
        if (valor > 0 ){
            saldo = saldo + valor;
            System.out.println("Déposito realizado. Novo saldo: R$" + saldo);
        }else{
            System.out.println("Valor de depósito inválido!");
        }

    }
    
    public void consultarSaldo(){
        System.out.println("Saldo disponivel: R$" + saldo);
    }

    public void mostrarDadosConta(){
        agencia.mostrarDadosAgencia();
        System.out.println("Conta: "+ numeroConta);
        System.out.println("Titular: "+ titular);
        System.out.println("Saldo atual: R$ " + saldo);
    }

    public void mostarDados(){
        mostrarDadosConta();
    }
} 