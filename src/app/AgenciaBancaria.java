package app;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {

        System.out.println("--------------------------------------------------");
        System.out.println("------------Bem vindos a nossa Agencia------------");
        System.out.println("--------------------------------------------------");
        System.out.println("*** Selecione uma operacao que deseja Realizar ***");
        System.out.println("--------------------------------------------------");
        System.out.println("|     Opcao 1 - Criar Conta     |");
        System.out.println("|     Opcao 2 - Depositar       |");
        System.out.println("|     Opcao 3 - Sacar           |");
        System.out.println("|     Opcao 4 - Transferir      |");
        System.out.println("|     Opcao 5 - Listar Contas   |");
        System.out.println("|     Opcao 6 - Sair            |");

        int operacao = input.nextInt();

        switch(operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                System.out.println("Obrigado por usar nossos servicos");
                System.exit(0);

            default:
                System.out.println("Opcao Invalida");
                operacoes();
                break;
        }
    }

    public static void criarConta() {

        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Pessoa pessoa = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso ");

        operacoes();
    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for(Conta c: contasBancarias) {
                if(c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void  depositar() {
        System.out.println("Numero da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual o valor deseja depositar? ");
            Double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("Valor depositado com sucesso! ");
        }else {
            System.out.println("A conta não foi encontrada! ");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Numero da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual o valor deseja sacar? ");
            Double valorSacar = input.nextDouble();
            conta.sacar(valorSacar);
            System.out.println("Valor sacado com sucesso! ");
        }else {
            System.out.println("A conta nao foi encontrada! ");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Numero da conta do remetente: ");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null) {
            System.out.println("Numero da conta do destinatario: ");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null) {
                System.out.println("Valor da transferencia: ");
                Double valor = input.nextDouble();

                contaRemetente.transferir(contaDestinatario, valor);
            }else {
                System.out.println("A conta para deposito nao foi encontrada");
            }
        }else {
            System.out.println("Conta para transferencia nao encontrada");
        }
        operacoes();
    }

    public static void listarContas() {
        if(contasBancarias.size() > 0) {
            for(Conta conta: contasBancarias){
                System.out.println(conta);
            }
            }else {
            System.out.println("Nao ha contas cadastradas");
        }
        operacoes();
    }
}
