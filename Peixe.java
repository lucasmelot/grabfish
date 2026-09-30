// Classe que representa um peixe do jogo.
class Peixe {
    // Atributos do peixe.
    String nome;
    String raridade;
    int valor;

    // Construtor: usado quando criamos um novo objeto Peixe.
    Peixe(String nome, String raridade, int valor) {
        this.nome = nome;
        this.raridade = raridade;
        this.valor = valor;
    }

    // Metodo que mostra as informacoes do peixe.
    void mostrarDados() {
        System.out.println("Peixe: " + nome);
        System.out.println("Raridade: " + raridade);
        System.out.println("Valor base: R$ " + valor);
    }
}
