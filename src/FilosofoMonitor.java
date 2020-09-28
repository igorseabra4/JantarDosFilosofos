public class FilosofoMonitor extends Filosofo {

    public FilosofoMonitor(Mesa mesa, int i) {
        super(mesa, i);
    }

    protected void come() {
        while (!mesa.pegaTalheres(num, num2));

        System.out.println("Filosofo " + num + " vai comer");
        finge();

        while (!mesa.soltaTalheres(num, num2));

        System.out.println("Filosofo " + num + " comeu");
        comeu++;
    }
}