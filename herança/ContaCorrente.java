public class  ContaCorrente extends Conta implements Pagamento{
  
    public ContaCorrente(int numeroConta, String titular, double saldo, Agencia agencia){
        super(numeroConta, titular, saldo, agencia);
    }
    
    @Override
    public void pagar(double valor){
        if (valor <=0){
            System.out.println("Erro: O valor de pagamento deve ser maior que zero!");
            return;
        }
        if (valor > saldo){
            System.out.println("Erro: Saldo insuficiente para realizar o pagamento!");
            return;
        }
        
        saldo = saldo - valor; 
        System.out.println("Pagamento em dinheiro de R$" + valor + " realizado com sucesso!");
        consultarSaldo(); 
    }
    public void pagar (double valor, String chavePix){
        if (valor <= 0 ){
            System.out.println("Erro: O valor de pagamento deve ser maior que zero!");
            return;
        }
        if (valor > saldo){
            System.out.println("Erro: Saldo insuficiente para realizar o pagamento!");
            return;
        }
        saldo=saldo - valor;
        System.out.println("Pagamento via PIX realizado com sucesso!");
        System.out.println("Chave PIX utilizada: "+ chavePix);
        consultarSaldo();
    }
    public void pagar(double valor, int parcelas){
        if (valor<= 0){
            System.out.println("Erro: O valor de pagamento deve ser maior que zero!");
            return;
        }
        if (parcelas <= 0){
            System.out.println("Erro: a quantidade de parcelas deve ser maior que zero!");
            return;
        }
        if (valor > saldo){
            System.out.println("Erro: Saldo insuficiente para realizar o pagamento");
            return;
        }
        double valorParcela = valor / parcelas;
        saldo = saldo - valor;
        System.out.println("Pagamento no cartão realizado");
        System.out.println("Valor parcelado: "+ parcelas + "x de R$" + valorParcela);
        consultarSaldo();
    }
  
}