import java.io.File;
import java.util.Scanner;

class day3{

    private static int getPriorities(char a){
        if(Character.isUpperCase(a)){
            return a -64+26;
        }
        else{
            return a-96;
        }
    }

    private static char findDouble(String halfOne, String halfTow){
        for(char i: halfOne.toCharArray()){
            if(halfTow.indexOf(i) != -1) return halfTow.charAt(halfTow.indexOf(i));
        }
        return '-';
    }

    public static void main(String[] args) throws Exception{
        File file = new File("./input.txt");		
		Scanner sc = new Scanner(file);

        String halfOne;
        String halfTow;
        int score = 0;
        
		while (sc.hasNextLine()){
            String line = sc.nextLine(); 
            int half = (int) (line.length() / 2);
            halfOne = line.substring(0, half);
            halfTow = line.substring(half, line.length());
            score += getPriorities(findDouble(halfOne, halfTow));
        }
        System.out.println(score);
    }
}