public class Simulation {
    private final Vehicle vehicle;

    public Simulation(Vehicle v) {
        this.vehicle = v;
    }
    // Mars Simulation Source Code.
    static String version = "2.0"; /* The Version of the program */

    public static int randomaltitude() {
        int max = 20000;
        int min = 10000;
//        return (int)(Math.random() * (max - min)) + min;
        int r = (int)(Math.random() * (max - min)) + min;
        return (r % 15000 + 4501); // best you can land is 4501
    }


    public String gameHeader() {
        String s = "";
        s = s + "\nMars Simulation - Version " + version + "\n";
        s = s + "Elon Musk has sent a really expensive Starship to land on Mars.\n";
        s = s + "The on-board computer has failed! You have to land the spacecraft manually.\n";
        s = s + "Set burn rate of retro rockets to any value between 0 (free fall) and 200\n";
        s = s + "(maximum burn) kilo per second. Set burn rate every 10 seconds.\n"; /* That's why we have to go with 10 second-steps. */
        s = s + "You must land at a speed of 2 or 1. Good Luck!\n\n";
        return s;
    }

    public String getHeader() {
        String s = "\n";
        s = s + "      Time";
        s = s + "  Velocity";
        s = s + "      Fuel";
        s = s + "  Altitude";
        s = s + "      Burn\n";
        s = s + "      ----";
        s = s + "  --------";
        s = s + "      ----";
        s = s + "  --------";
        s = s + "      ----";
        return s;
    }


    public void printString(String string) {
// print long strings with new lines the them.
    String[] a = string.split("\r?\n");
        for (String s : a) {
            System.out.println(s);
        }
    }

    // main game loop
    public int runSimulation(BurnStream burnSource) {
        DescentEvent status = null;
        int burnInterval = 0;
        printString(gameHeader());
        printString(getHeader());
        while (vehicle.stillFlying()) {
            status = vehicle.getStatus(burnInterval);
            System.out.print(status.toString()); // +"\t\t"
            vehicle.adjustForBurn(burnSource.getNextBurn(status));
            if (vehicle.outOfFuel()) {
                break;
            }
            burnInterval++;
            if (burnInterval % 9 == 0) {
                printString(getHeader());
            }
        }
        printString(vehicle.checkFinalStatus());
        if (status != null) {
//            return status.getStatus();
            return vehicle.getFlying();
        }
        return -44;
    }

    public static void main(String[] args) {
        // create a new Simulation object with a random starting altitude
        // create a new BurnInputStream
        // pass the new BurnInputStream to the runSimulation method
//        Simulation sim = new Simulation(new Vehicle(randomaltitude()));
//        OnBoardComputer onBoardComputer = new OnBoardComputer();
//        sim.runSimulation(onBoardComputer);

//        Simulation sim = new Simulation(new Vehicle(5000));
//        BurnInputStream burnStream = new BurnInputStream();
//        sim.runSimulation(burnStream);

        OnBoardComputer burnStream = new OnBoardComputer();
        Simulation simRunner;
        for (int i = 20501; i <= 30501; i++) {
            simRunner = new Simulation(new Vehicle(i));
            if (simRunner.runSimulation(burnStream) < 0) {
                System.out.println("You lose.");
                break;
            }
            burnStream.setFreefall(true);
        }
        System.out.println("fin.");
    }

}
