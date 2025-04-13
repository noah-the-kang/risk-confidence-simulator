public class Simulation{
    // Input data
    private int numSims; // number of simulations

    // Stats to calculate (not input)
    private int aWins;
    private int dWins;
    private double aAvgStanding; // number of attackers standing after successful attack
    private double dAvgStanding; // number of defenders standing after successful defense


    // Constructor
    public Simulation(int numSims){
        this.numSims=numSims;
    }


    /**
     * Confidence interval stuff? maybe hypothesis testing
     */
    public void simulate(int defenders, int attackers){
        for(int i=0;i<numSims;i++){
            Match match = new Match(defenders, attackers);
            int[] result = match.simulateBattle();
            if(result[0]==0){ // attacker wins
                aWins++;
                aAvgStanding+=result[1];
            } else{ // defender wins
                dWins++;
                dAvgStanding+=result[1];
            }
        }
        aAvgStanding/=aWins;
        dAvgStanding/=dWins;
    }


    /**
     * Prints the simulation results to the console.
     * The output includes:
     * - The number of times attackers and defenders won.
     * - The win rates for attackers and defenders as percentages.
     * - The average standing of attackers and defenders.
     */
    public void printInfo(){
        System.out.println("Attackers won " + aWins + " times, defenders won " + dWins + " times.");
        System.out.println("Attacker win rate: " + ((double)(aWins)/numSims) + "%; Defender win rate: " + ((double)(dWins)/numSims) + "%");
        System.out.println("Attackers average standing: " + aAvgStanding);
        System.out.println("Defenders average standing: " + dAvgStanding);
    }


    // implement Java FX to show the results in a graphical way:
    // - Pie chart for win rates
    // - Scatterplot of attackers and defenders standing
    // - print info can be used on text for the GUI
    public void graphicalInfo(){
        
    }
}
