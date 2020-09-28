public class Main {

    private static Thread[] threads;
    private static Filosofo[] filosofos;

    public static void main(String[] args) {
        int numFilosofos = 5;
        int tempo = 500;

        // escolher aqui monitor ou semaforo
        comecarMonitor(numFilosofos, tempo);
        //comecarSemaforo(numFilosofos, tempo);

        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        terminar();
    }

    private static void comecarMonitor(int numFilosofos, int tempo) {
        var mesa = new MesaMonitor(numFilosofos, tempo);

        threads = new Thread[numFilosofos];
        filosofos = new FilosofoMonitor[numFilosofos];

        for (int i = 0; i < numFilosofos; i++) {
            filosofos[i] = new FilosofoMonitor(mesa, i);
            threads[i] = new Thread(filosofos[i]);
        }

        for (var t : threads)
            t.start();
    }

    private static void comecarSemaforo(int numFilosofos, int tempo) {
        var mesa = new MesaSemaforo(numFilosofos, tempo);

        threads = new Thread[numFilosofos];
        filosofos = new FilosofoSemaforo[numFilosofos];

        for (int i = 0; i < numFilosofos; i++) {
            filosofos[i] = new FilosofoSemaforo(mesa, i);
            threads[i] = new Thread(filosofos[i]);
        }

        for (var t : threads)
            t.start();
    }

    private static void terminar() {
        for (var f : filosofos)
            f.morrer();

        for (var t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (var f : filosofos)
            System.out.println(f);
    }
}