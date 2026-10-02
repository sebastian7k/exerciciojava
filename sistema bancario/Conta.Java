public class Conta{
    private String numero;
    private String titular;
    private double saldo;

    public Conta(String numero, String titular, double saldo) throws ExcecaoDadosInvalidos{
        setNumero(numero);
        setTitular(titular);
        setSaldo(saldo);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) throws ExcecaoDadosInvalidos {
        if(numero == null || numero.isEmpty()){
            throw new ExcecaoDadosInvalidos("Número da conta inválido.");
        }
        this.numero = numero;

        public String getTitular() {
            return titular;
    }
    public void setTitular(String titular) throws ExcecaoDadosInvalidos {
        if(titular == null || titular.trim().isEmpty()){
            throw new ExcecaoDadosInvalidos("O nome do titular não pode ser  vazio.");
         }
         this.titular = titular.trim();
    }

}
publc double getSaldo() {
    return saldo;
}
public void setSaldo(double saldo) throws ExcecaoDadosInvalidos {
    if (saldo < 0) {
        throw new ExcecaoDadosInvalidos("O saldo não pode ser negativo.");
    }
    this.saldo = saldo;
    
}