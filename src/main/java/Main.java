public class Main {
    public static void main(String[] args) {
        CashMachine ATM = new CashMachine(10_000);

        Thread kostikTheread = new Thread(new Runnable() {
            @Override
            public void run() {
                ATM.checkMoney("Kostik", 5_000);
            }
        });
        Thread igorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                ATM.checkMoney("Igor", 8_000);

            }
        });
        Thread mashaThread = new Thread(new Runnable() {
            @Override
            public void run() {
                ATM.checkMoney("Masha", 3_000);

            }
        });

        kostikTheread.start();
        igorThread.start();
        mashaThread.start();

    }
}
