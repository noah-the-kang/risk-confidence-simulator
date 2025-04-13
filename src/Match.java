import java.util.ArrayList;
import java.util.Arrays;

public class Match {
    private int defenders;
    private int attackers;
    private int[] result; // necessary?

    public Match(int defenders, int attackers){
        this.defenders=defenders;
        this.attackers=attackers;
        this.result=simulateBattle();
    }


    public int[] simulateBattle(){
        int numRounds=0; // for fun
        while(defenders>0 && attackers>0){
            int[] aRolls = new int[Math.min(attackers, 3)];
            int[] dRolls = new int[Math.min(defenders, 2)];
            for(int i=0;i<Math.min(attackers, 3);i++){aRolls[i]=rollDice();}
            for(int i=0;i<Math.min(defenders, 2);i++){dRolls[i]=rollDice();}

            Arrays.sort(aRolls);
            Arrays.sort(dRolls);

            // debugging prints
            System.out.println("aRolls:");
            for(int i:aRolls){System.out.println(i);}
            System.out.println("dRolls:");
            for(int i:dRolls){System.out.println(i);}

            int numCompare = Math.min(aRolls.length,dRolls.length);

            System.out.println("numCompare = " + numCompare);

            System.out.println("========ROUND ANALYSIS========");
            for(int i=0;i<numCompare;i++){
                System.out.println("ROUND "+(i+1));
                System.out.println("\tComparing: "+aRolls[aRolls.length-i-1]+","+dRolls[dRolls.length-i-1]);

                if(aRolls[aRolls.length-i-1] > dRolls[dRolls.length-i-1]){
                    System.out.println("\tdefenders minus 1");
                    defenders--;
                } else{
                    System.out.println("\tattackers minus 1");
                    attackers--;
                }
            }
            numRounds++;
        }

        // format: [0:attack won/1: defense won, num troops of winning side won]
        return new int[]{defenders<=0 ? 0 : 1,defenders<=0 ? attackers:defenders};
    }



    // 1-6
    public static int rollDice(){
        return (int)(Math.random()*6)+1;
    }
}
