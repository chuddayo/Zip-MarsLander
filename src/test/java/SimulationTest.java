import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimulationTest {

    @Test
    public void runSimulationLanding() {
        int[] burns = {200, 200, 200, 200, 200, 200, 200, 200, 200,
                100, 100, 100, 100,
                150, 125, 120, 100, 100, 100, 103,
                100, 100, 100, 100};
        BurnStream burnSource = new BurnDataStream(burns);
        Simulation game = new Simulation(new Vehicle(5000));
        int okay = game.runSimulation(burnSource);
        Assert.assertEquals(Vehicle.SUCCESS, okay);
    }
    @Test
    public void runSimulationCrash_Dead() {
        int[] burns = {0,0,0,0,0};
        BurnStream burnSource = new BurnDataStream(burns);
        Simulation game = new Simulation(new Vehicle(5000));
        int okay = game.runSimulation(burnSource);
        Assert.assertEquals(Vehicle.DEAD, okay);
    }
    @Test
    public void runSimulationComputer_4500() {
        BurnStream burnSource = new OnBoardComputer();
        Simulation game = new Simulation(new Vehicle(4500));
        int okay = game.runSimulation(burnSource);
        Assert.assertEquals(Vehicle.DEAD, okay);
    }
    @Test
    public void runSimulationComputer_4501() {
        BurnStream burnSource = new OnBoardComputer();
        Simulation game = new Simulation(new Vehicle(4501));
        int okay = game.runSimulation(burnSource);
        Assert.assertEquals(Vehicle.SUCCESS, okay);
    }
    @Test
    public void runSimulationComputer_5000() {
        BurnStream burnSource = new OnBoardComputer();
        Simulation game = new Simulation(new Vehicle(5000));
        int okay = game.runSimulation(burnSource);
        Assert.assertEquals(Vehicle.SUCCESS, okay);
    }
    @Test
    public void runSimulationComputer_5500() {
        BurnStream burnSource = new OnBoardComputer();
        Simulation game = new Simulation(new Vehicle(5500));
        int okay = game.runSimulation(burnSource);
        Assert.assertEquals(Vehicle.SUCCESS, okay);
    }
    @Test
    public void runSimulationComputer_10000() {
        BurnStream burnSource = new OnBoardComputer();
        Simulation game = new Simulation(new Vehicle(10000));
        int okay = game.runSimulation(burnSource);
        Assert.assertEquals(Vehicle.SUCCESS, okay);
    }
    @Test
    public void runSimulationComputer_15000() {
        BurnStream burnSource = new OnBoardComputer();
        Simulation game = new Simulation(new Vehicle(15000));
        int okay = game.runSimulation(burnSource);
        Assert.assertEquals(Vehicle.SUCCESS, okay);
    }
    @Test
    public void runSimulationComputer_20000() {
        BurnStream burnSource = new OnBoardComputer();
        Simulation game = new Simulation(new Vehicle(20000));
        int okay = game.runSimulation(burnSource);
        Assert.assertEquals(Vehicle.SUCCESS, okay);
    }
    @Test
    public void runSimulationComputerRandom() {
        BurnStream burnSource = new OnBoardComputer();
        Simulation game = new Simulation(new Vehicle(Simulation.randomaltitude()));
        int okay = game.runSimulation(burnSource);
        Assert.assertEquals(Vehicle.SUCCESS, okay);
    }
}