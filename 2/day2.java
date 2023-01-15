
import java.io.File;
import java.util.Scanner;
import java.util.HashMap;

class day2{

    private static char convert(char i){
        switch(i){
            case 'X': return 'A';
            case 'Y': return 'B';
            case 'Z': return 'C';
            default:{
                System.out.println("Es wurde probeirt nicht XYZ zu converitern");
                System.exit(1);
                return '1';
            }
        }
    }

    /**
     * 6 player winner 
     * 3 draw
     * 0 computer winner
     */

     /*
     A: Rock
     B: Paper
     C: Scissors
     */
    private static int checkWinner(char player, char computer){
        if(player == computer) return 3;
        if(helperWinner(player, computer)) return 6;
        if(helperWinner(computer, player)) return 0;
        System.out.println("Fehler bei CheckWinner");
        System.exit(1);
        return -100;
    }

    /**
     * true a winner
     */
    private static boolean helperWinner(char a, char b){
        if(a == 'A'){
            if(b == 'B') return false;
            if(b == 'C') return true;
        }
        if(a == 'B'){
            if(b == 'A') return true;
            if(b == 'C') return false;
        }
        if(a == 'C'){
            if(b == 'A') return false;
            if(b == 'B') return true;
        }
        System.out.println("Fehler bei helperWinner");
        System.exit(1);
        return false;
        }

    public static void main(String[] args) throws Exception{
        File file = new File("./input.txt");		
		Scanner sc = new Scanner(file);

        int score = 0;
        char[] line;
        
		while (sc.hasNextLine()){
            line = sc.nextLine().toCharArray(); 
            score += checkWinner(convert(line[2]), line[0]);
            switch(convert(line[2])){
                case 'A': score += 1; break;
                case 'B': score += 2; break;
                case 'C': score += 3; break;
                default:{
                    System.out.println("Fehler");
                    System.exit(1);
                }
            }
        }
        System.out.println(score);
    }
}