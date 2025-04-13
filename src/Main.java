public class Main {
    public static void main(String[] args) {
        Match test1 = new Match(10,10);
        for(int i:test1.simulateBattle()){
            System.out.println(i);
        }
    }
}