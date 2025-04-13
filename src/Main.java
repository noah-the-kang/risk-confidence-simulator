public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(1000); // Number of simulations
        simulation.simulate(2, 5);
        simulation.printInfo();
    }
}