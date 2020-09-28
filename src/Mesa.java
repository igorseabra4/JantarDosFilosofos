import java.util.Random;

public abstract class Mesa {
    private int tempo;
    //private Random random;

    public Mesa(int tempo){
        this.tempo = tempo;
        //random = new Random();
    }

    public abstract boolean pegaTalheres(int i, int j);

    public abstract boolean soltaTalheres(int i, int j);

    public abstract int qtdTalheres();

    public int tempo(){
        return tempo;
        //return random.nextInt(tempo);
    }
}
