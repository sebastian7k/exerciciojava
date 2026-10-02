import java.util.Scanner;

public class ContaApp{
    public static void main(String[] args) {
        Scanner sc = new scanner(System.in);
        cadastroConta cadastro = new cadastroConta();
        boolean executando = true;

        whilw (executando){
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Cadastrar Conta");
            System.out.println("2. Buscar Conta");
            System.out.println("3. Remover Conta");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            String opcaoEntrada = scanner.nextLine();
            int opcao;

            try{
                opcao = Integer.parseInt(opcaoEntrada);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Por favor, digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    // Opção 1: Cadastro
                    try {
                        System.out.print("Informe o número da conta: ");
                        String numero = scanner.nextLine();

                        System.out.print("Informe o nome do titular: ");
                        String titular = scanner.nextLine();

                        System.out.print("Informe o saldo inicial: ");
                        String saldoInput = scanner.nextLine();
                        double saldo;

                        try {
                            saldo = Double.parseDouble(saldoInput.replace(",", "."));
                        } catch (NumberFormatException e) {
                            throw new ExcecaoDadoInvalido("O valor do saldo deve ser um número válido.");
                        }

                        // Instancia a conta e insere no repositório
                        Conta novaConta = new Conta(numero, titular, saldo);
                        repositorio.inserir(novaConta);

                        System.out.println("Sucesso: Conta cadastrada com sucesso!");

                    } catch (ExcecaoDadoInvalido | ExcecaoRepositorio | ExcecaoElementoJaExistente e) {
                        // Trata e exibe mensagens de erro  sem encerrar o programa:
                        System.out.println("Erro ao cadastrar conta: " + e.getMessage());
                    }
                    break;

                case 2:
                    // Opção 2: Buscar Conta
                    try {
                        System.out.print("Informe o número da conta que deseja buscar: ");
                        String numero = scanner.nextLine();

                        Conta conta = repositorio.buscar(numero);
                        System.out.println("\n--- Dados da Conta ---");
                        System.out.println("Nome do Titular: " + conta.getTitular()); // Exibe o nome do titular[cite: 1]
                        System.out.println("Saldo: R$ " + String.format("%.2f", conta.getSaldo())); // Exibe o saldo[cite: 1]

                    } catch (ExcecaoElementoInexistente e) {
                        System.out.println("Erro na busca: " + e.getMessage());
                    }
                    break;

                case 3:
                    // Opção 3: Remover Conta:
                    try {
                        System.out.print("Informe o número da conta que deseja remover: ");
                        String numero = scanner.nextLine();

                        repositorio.remover(numero);
                        System.out.println("Sucesso: Operação realizada com sucesso!"); // Exibe mensagem de sucesso[cite: 1]

                    } catch (ExcecaoElementoInexistente e) {
                        System.out.println("Erro na remoção: " + e.getMessage());
                    }
                    break;

                case 4:
                    // Opção 4: Sair
                    System.out.println("Saindo do sistema. Até mais!");
                    executando = false;
                    break;

                default:
                    System.out.println("Opção inválida! Escolha um número de 1 a 4.");
                    break;
            }
        }

        scanner.close();
    }
}