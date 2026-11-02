import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ReHash hash = new ReHash();
        Random random = new Random(1090);

        int ocupacao = 0;
        int totalColisoes = 0;

        int max1 = -1, max2 = -1, max3 = -1;
        int el1 = -1, el2 = -1, el3 = -1;

        for (int k = 0; k < 100; k++) {
            if (ocupacao >= 90) {
                break;
            }

            int numero = random.nextInt(100001);
            int colisoesAtuais = hash.insere_hashing(numero);

            totalColisoes += colisoesAtuais;
            ocupacao++;

            if (colisoesAtuais > max1) {
                max3 = max2; el3 = el2;
                max2 = max1; el2 = el1;
                max1 = colisoesAtuais; el1 = numero;
            } else if (colisoesAtuais > max2) {
                max3 = max2; el3 = el2;
                max2 = colisoesAtuais; el2 = numero;
            } else if (colisoesAtuais > max3) {
                max3 = colisoesAtuais; el3 = numero;
            }
        }

        System.out.println("Total de colisões: " + totalColisoes);
        System.out.println("3 elementos com mais colisões:");
        System.out.println("1º: " + el1 + " (" + max1 + " colisões)");
        System.out.println("2º: " + el2 + " (" + max2 + " colisões)");
        System.out.println("3º: " + el3 + " (" + max3 + " colisões)");

        System.out.print("\nPosições livres na matriz: ");
        for (int i = 0; i < hash.tamanho; i++) {
            if (hash.tabela[i] == hash.VAZIO) {
                System.out.print(i + " ");
            }
        }

        int[] top3 = {el1, el2, el3};

        for (int i = 0; i < 3; i++) {
            int chave = top3[i];
            if (chave != -1) {
                int indiceEncontrado = hash.busca_hashing(chave);
                if (indiceEncontrado != -1) {
                    System.out.println("Elemento " + chave + " encontrado no índice " + indiceEncontrado);
                } else {
                    System.out.println("Elemento " + chave + " não encontrado.");
                }
            }
        }
    }
}