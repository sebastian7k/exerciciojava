import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao = -1 ;
        Scanner sc = new Scanner(System.in);

        
        System.out.println("=== CADASTRO INICIAL ===");
        System.out.print("Número da agência: ");
        int numAgencia = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome da agência: ");
        String nomeAgencia = sc.nextLine();

        System.out.print("Número da conta: ");
        int numConta = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome do titular: ");
        String titular = sc.nextLine();

        System.out.print("Saldo inicial: R$ ");
        double saldoInicial = sc.nextDouble();

        
        Agencia agencia = new Agencia(numAgencia, nomeAgencia);
        ContaCorrente conta = new ContaCorrente(numConta, titular, saldoInicial, agencia);


        
        while (opcao != 0) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Mostrar dados da conta");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Depositar");
            System.out.println("4 - Pagar com PIX");
            System.out.println("5 - Pagar com cartão");
            System.out.println("6 - Pagar em dinheiro");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
             switch (opcao) {
                case 1:
                    conta.mostrarDadosConta();
                    break;
                case 2:
                    conta.consultarSaldo();
                    break;
                case 3:
                    System.out.print("Valor do depósito: ");
                    double valorDeposito = sc.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 4:
                    System.out.print("Valor do pagamento PIX: ");
                    double valorPix = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Chave PIX: ");
                    String chavePix = sc.nextLine();
                    conta.pagar(valorPix, chavePix); 
                    break;
                case 5:
                    System.out.print("Valor da compra: ");
                    double valorCartao = sc.nextDouble();
                    System.out.print("Quantidade de parcelas: ");
                    int parcelas = sc.nextInt();
                    conta.pagar(valorCartao, parcelas); 
                    break;
                case 6:
                    System.out.print("Valor do pagamento em dinheiro: ");
                    double valorDinheiro = sc.nextDouble();
                    conta.pagar(valorDinheiro); 
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            
        }
        sc.close();
        
    }
}