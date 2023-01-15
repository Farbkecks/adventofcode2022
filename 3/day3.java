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

    private static char findDouble(String halfOne, String halfTow,String line){
        for(char i: halfOne.toCharArray()){
            if(halfTow.indexOf(i) != -1 && line.indexOf(i) != -1){
                return halfTow.charAt(halfTow.indexOf(i));
            }
        }
        return '-';
    }

    public static void main(String[] args) throws Exception{
        File file = new File("./input.txt");		
		Scanner sc = new Scanner(file);

        String line;
        String one = "";
        String tow = "";
        int count = 0;
        int score = 0;
        
		while (sc.hasNextLine()){
            line = sc.nextLine(); 
            if(count == 0){
                one = line;
            }
            else if(count == 1){
                tow = line;
            }
            else if(count == 2){
                count = -1;
                score += getPriorities(findDouble(one, tow, line));
            }
            count++;
        }
        System.out.println(score);
    }
}