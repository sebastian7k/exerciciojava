public class Agencia {

    private int numero;
    private String nome;
    
    public Agencia (int numero, String nome){
        this.numero = numero;
        this.nome = nome;
    }
    public void setNumero(int numero){
        this.numero = numero;
        

    }
    public void setNome(String nome){
        this.nome = nome;

    }
    public int getNumero(){
        return numero;
    }

    public String getNome(){
        return nome;
    }

    public void mostrarDadosAgencia(){
        System.out.println("Agencia:" + nome + "(Número: " + numero + ")");
    }
}