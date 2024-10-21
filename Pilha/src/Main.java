import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        Scanner scanner = new Scanner(System.in);



        while (true){
            System.out.println("\nEscolha uma ação:\n" +
                    "1. Adicionar à Pilha\n" +
                    "2. Remover da Pilha\n" +
                    "3. Sair");
            int opcao = scanner.nextInt();

            clearConsole();

            if (opcao == 1){
                if(pilha.isFull()){
                    System.out.println("A Pilha está cheia!");
                }
            }
            switch (opcao){

                case 1:
                    while (!pilha.isFull()){
                        System.out.println("Digite um número para ser adicionado a Pilha:");
                        int number = scanner.nextInt();
                        pilha.push(number);
                        clearConsole();

                    }
                    break;
                case 2:
                    if (!pilha.isEmpty()){
                        int elemento = pilha.pop();
                        System.out.println("\nElemento removido da Pilha: " + elemento);
                    }else {
                        System.out.println("A pilha está vazia.");
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    System.exit(0);

                default:
                    System.out.println("Escolha invalida. Tente novamente. ");

            }
        }

    }

    public static void clearConsole(){

    }
}