import java.util.Arrays;

public class Match {
    private int defenders;
    private int attackers;

    public Match(int defenders, int attackers){
        this.defenders=defenders;
        this.attackers=attackers;
    }


    public int[] simulateBattle(){
        while(defenders>0 && attackers>0){
            int[] aRolls = new int[Math.min(attackers, 3)];
            int[] dRolls = new int[Math.min(defenders, 2)];
            for(int i=0;i<Math.min(attackers, 3);i++){aRolls[i]=rollDice();}
            for(int i=0;i<Math.min(defenders, 2);i++){dRolls[i]=rollDice();}

            Arrays.sort(aRolls);
            Arrays.sort(dRolls);

            int numCompare = Math.min(aRolls.length,dRolls.length);

            for(int i=0;i<numCompare;i++){
                if(aRolls[aRolls.length-i-1] > dRolls[dRolls.length-i-1]){
                    defenders--;
                } else{
                    attackers--;
                }
            }
        }

        // format: [0:attack won/1: defense won, num troops of winning side won]
        return new int[]{defenders<=0 ? 0 : 1,defenders<=0 ? attackers:defenders};
    }


    /**
     * Simulates the rolling of a six-sided die.
     * 
     * @return an integer value between 1 and 6 (inclusive), representing the result of the die roll.
     */
    public static int rollDice(){
        return (int)(Math.random()*6)+1;
    }

    public int getDefenders() {
        return defenders;
    }

    public void setDefenders(int defenders) {
        this.defenders = defenders;
    }

    public int getAttackers() {
        return attackers;
    }

    public void setAttackers(int attackers) {
        this.attackers = attackers;
    }
}
