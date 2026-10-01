class Jogador {
    int dinheiro;
    long ultimaPesca;

    Jogador() {
        this.dinheiro = 100;
        this.ultimaPesca = 0;
    }

    void receberDinheiro(int valor) {
        dinheiro = dinheiro + valor;
    }

    void mostrarStatus() {
        System.out.println("Dinheiro: R$ " + dinheiro);
    }
}
