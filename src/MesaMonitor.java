public class MesaMonitor extends Mesa {
    private boolean[] talheres;

    public MesaMonitor(int numTalheres, int tempo)
    {
        super(tempo);

        talheres = new boolean[numTalheres];
        for (int i = 0; i < numTalheres; i++)
            talheres[i] = false;
    }

    public synchronized boolean pegaTalheres(int i, int j) {
        if (talheres[i] || talheres[j])
            return false;

        talheres[i] = true;
        talheres[j] = true;

        return true;
    }

    public synchronized boolean soltaTalheres(int i, int j) {
        if (!talheres[i] || !talheres[j]) {
            System.out.println("ERRO: Filosofo tentando soltar talher que nao esta em uso.");
            return false;
        }

        talheres[i] = false;
        talheres[j] = false;

        return true;
    }

    public int qtdTalheres(){
        return talheres.length;
    }
}
