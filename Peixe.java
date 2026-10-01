class Peixe {
    // Atributos do peixe.
    String nome;
    String raridade;
    int valor;

    Peixe(String nome, String raridade, int valor) {
        this.nome = nome;
        this.raridade = raridade;
        this.valor = valor;
    }

    void mostrarDados() {
        System.out.println("Peixe: " + nome);
        System.out.println("Raridade: " + raridade);
        System.out.println("Valor base: R$ " + valor);
    }
}
