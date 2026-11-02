public class ReHash {
    int tamanho = 100;
    int[] tabela = new int[tamanho];
    final int VAZIO = -1;

    public ReHash() {
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = VAZIO;
        }
    }

    public int h(int chave) {
        return chave % tamanho;
    }

    public int r(int i) {
        return (i + 1) % tamanho;
    }

    public int insere_hashing(int chave) {
        int i = h(chave);
        int colisoes = 0;

        while(tabela[i] != VAZIO) {
            i = r(i);
            colisoes++;
        }

        tabela[i] = chave;
        return colisoes;
    }

    public int busca_hashing(int chave) {
        int i = h(chave);

        while(tabela[i] != chave && tabela[i] != VAZIO) {
            i = r(i);
        }

        if(tabela[i] == VAZIO) {
            return -1;
        } else {
            return i;
        }
    }
}