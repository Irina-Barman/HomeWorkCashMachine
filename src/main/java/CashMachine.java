public class CashMachine {
    private double machineMoney;
    private final Object monitor = new Object();

    public CashMachine(double machineMoney) {
        this.machineMoney = machineMoney;
    }


    public void checkMoney(String userName, double userSum) {
        synchronized (monitor) {
            System.out.println(userName + " подошёл к банкомату");
            try {
                Thread.sleep(20_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (machineMoney >= userSum) {
                machineMoney -= userSum;
                System.out.println(userName + " вывел " + (userSum) + "." + "В банкомате осталось " + (machineMoney) + " рублей.");

            } else {
                System.out.println("В банкомате недостаточно денег для " + userName + ".");
                System.out.println("Баланс " + machineMoney);
            }
        }

    }

}

