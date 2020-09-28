public class FilosofoSemaforo extends Filosofo {

    public FilosofoSemaforo(Mesa mesa, int i) {
        super(mesa, i);
    }

    protected void come() {
        if (mesa.pegaTalheres(num, num2)){
            System.out.println("Filosofo " + num + " vai comer");
            finge();
            if (mesa.soltaTalheres(num, num2)){
                System.out.println("Filosofo " + num + " comeu");
                comeu++;
            }
        }
    }
}
