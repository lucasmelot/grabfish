import java.util.Random;

public class Vara {
    private int _nivel;
    private int _durabilidade;
    private int _durabilidadeMaxima;
    private final Random _random;

    public Vara (){
        this._nivel = 1;
        this._durabilidade = 100;
        this._durabilidadeMaxima = 100;
        this._random = new Random();
    }

    public int GetNivel(){
        return this._nivel;
    }
    public int GetDurabilidade(){
        return this._durabilidade;
    }
    public int GetDurabilidadeMaxima(){
        return this._durabilidadeMaxima;
    }
    public int GetCustoEvoluir(){
        return 150 * this._nivel;
    }
    public int GetCustoConserto(){
        return 40 * this._nivel;
    }
    
    public void Evoluir(){
        ++this._nivel;
        this._durabilidadeMaxima += 25;
        this._durabilidade = this._durabilidadeMaxima;
    }

    public void Desgastar(){
        this._durabilidade -= _random.nextInt(3, 8);
        if(this._durabilidade < 0) this._durabilidade = 0;
    }

    public void Status(){
        System.out.println("Nivel da vara: " + this._nivel);
        System.out.println("Durabilidade: " + this._durabilidade + "/" + this._durabilidadeMaxima);
    }

    public void Consertar(){
        this._durabilidade = this._durabilidadeMaxima;
    }
}
