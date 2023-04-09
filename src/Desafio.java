import java.util.Scanner;

import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {

        Cliente wayne = new Cliente("Bruce Wayne", "112.358.132-10", "Bilionário");
        Conta contadobruce = new Conta("123-4", 123456, 1000.0, wayne);

        Cliente clark = new Cliente("Clark Kent", "358.132.134-55", "Jornalista");
        Conta contadoclark = new Conta("123-4", 78921, 0.0, clark);

        int opcao = 0;

        System.out.printf(
                "Nome: %s\n" +
                        "CPF: %s\n" +
                        "Profissão: %s\n" +
                        "Saldo: %.2f\n",
                contadobruce.getTitular().getNome(),
                contadobruce.getTitular().getCpf(),
                contadobruce.getTitular().getProfissao(),
                contadobruce.getSaldo());
        String menu = String.format(
                "1 - Saldo\n" +
                        "2 - Transferir\n" +
                        "3 - Sacar\n" +
                        "4 - Sair\n");
        Scanner leitura = new Scanner(System.in);


        while (opcao != 4) {
            System.out.println(menu);
            System.out.print("> ");
            opcao = leitura.nextInt();

            if (opcao == 1) {
                System.out.println("Saldo: " + contadobruce.getSaldo());
            } else if (opcao == 2) {
                System.out.printf("Digite o valor a ser transferido: ");
                double valorASerTransferido = leitura.nextDouble(); // atribua o valor de entrada a uma variável
                contadobruce.transfere(valorASerTransferido, contadoclark);

                System.out.print("> ");
                // substitua o Scanner dos if's pela variavel criada
                // Atente-se ao contexto, ou seja, onde a variável é criada e onde
                // deve ser utilizada.
                if (contadobruce.getSaldo() < valorASerTransferido) {
                    System.out.println("Saldo insuficiente");
                } else {
                    System.out.println("Transferência realizada com sucesso");
                    System.out.println("Novo saldo: " + contadobruce.getSaldo());
                }
            } else if (opcao == 3) {
                System.out.print("> ");
                System.out.printf("Digite o valor a ser sacado: ");
                double valorASerSacado = leitura.nextDouble();
                contadobruce.saca(valorASerSacado);

                if (contadobruce.getSaldo() < valorASerSacado) {
                    System.out.println("Saldo insuficiente");
                } else {
                    System.out.println("Saque realizado com sucesso");
                    System.out.println("Novo saldo: " + contadobruce.getSaldo());
                }
            } else if (opcao == 4) {
                System.out.println("Obrigado por utilizar nossos serviços");
            } else {
                System.out.println("Opção inválida");
            }

            //usei esses parametros para verificar se a transferencia e o saque estavam sendo realizados
            System.out.println("Saldo de Bruce Wayne: " + contadobruce.getSaldo());
            System.out.println("Saldo de Clark Kent: " + contadoclark.getSaldo());;


        }

    }

}
