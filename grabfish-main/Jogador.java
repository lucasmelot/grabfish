// Classe que representa o jogador.
class Jogador {
    // Atributos do jogador.
    String nome;
    int dinheiro;

    // Construtor: define os valores iniciais do jogador.
    Jogador(String nomeJogador) {
        nome = nomeJogador;
        dinheiro = 100;
    }

    // Metodo para receber dinheiro depois de pescar.
    void receberDinheiro(int valor) {
        dinheiro = dinheiro + valor;
    }

    // Metodo que mostra os dados atuais do jogador.
    void mostrarStatus() {
        System.out.println("Dinheiro: R$ " + dinheiro);
        
    }
}
