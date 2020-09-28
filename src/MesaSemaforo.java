import java.util.concurrent.Semaphore;

public class MesaSemaforo extends Mesa {
    private Semaphore[] talheres;

    public MesaSemaforo(int numTalheres, int tempo)
    {
        super(tempo);

        talheres = new Semaphore[numTalheres];
        for (int i = 0; i < numTalheres; i++)
            talheres[i] = new Semaphore(1);
    }

    public boolean pegaTalheres(int i, int j){
        try {
            talheres[i].acquire();
            talheres[j].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean soltaTalheres(int i, int j){
        talheres[i].release();
        talheres[j].release();
        return true;
    }

    public int qtdTalheres(){
        return talheres.length;
    }
}
