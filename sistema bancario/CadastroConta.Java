import java.util.arrayList;
import java.util.List;


public class cadastroConta{
    private List<Conta> contas;
    private static final int MAX_CONTAS = 100;

    public cadastroConta() {
        this.contas = new ArrayList<>();
    }

    public void cadastrarConta(Conta conta) throws ExcecaoReoisitorio, ExcecaoElementoJaExiste {
        if (contas.size()>= MAX_CONTAS){
            throw new ExcecaoReoisitorio("Limite de contas atingido.");
        }

        for (Conta c : contas) {
            if (c.getNumero().equals(conta.getNumero())){
                throw new ExcecaoElementoJaExiste("Limite máximo de 100 contas atingido.");
            }

            for (Conta c: contas) {
                if (c.getNumero().equalsIgnoreCase(conta.getNumero())){
                    throw new ExcecaoElementoJaExiste("Já existe uma conta com esse número.");
                }
            }
            contas.add(conta);
        }
        public Conta buscar(String numero) throws ExcecaoElementoInexistente {
            for (Conta c : contas) {
                if (c.getNumero().equalsIgnoreCase(numero)) {
                    return c;
                }
            }
            throw new ExcecaoElementoInexistente("Conta não encontrada.");
        }
        public void remover(String numero) throws ExcecaoElementoInexistente {
            Conta contaEncontrada = buscar(numero);
            contas.remove(contaEncontrada);
        }
    }
}