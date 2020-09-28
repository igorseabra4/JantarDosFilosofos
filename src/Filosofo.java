public abstract class Filosofo implements Runnable {
    protected Mesa mesa;
    protected int num;
    protected int num2;

    private int pensou;
    protected int comeu;
    private boolean vivo;

    public Filosofo(Mesa mesa, int num){
        this.mesa = mesa;
        this.num = num;
        this.num2 = (num + 1) % mesa.qtdTalheres();

        pensou = 0;
        comeu = 0;
        vivo = true;
    }

    @Override
    public void run(){
        while (vivo) {
            pensa();
            come();
        }
    }

    protected void pensa(){
        System.out.println("Filosofo " + num + " vai pensar");
        finge();
        System.out.println("Filosofo " + num + " pensou");
        pensou++;
    }

    protected abstract void come();

    protected void finge(){
        try {
            Thread.sleep(mesa.tempo());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void morrer(){
        vivo = false;
    }

    @Override
    public String toString() {
        return "Filosofo " + num + " pensou " + pensou + " vezes e comeu " + comeu + " vezes.";
    }
}
