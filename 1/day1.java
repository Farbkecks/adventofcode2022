import java.io.*;

class Three{
	int nummer1;
	int nummer2;
	int nummer3;

	public Three(){
		nummer1 = 0;
		nummer2 = 0;
		nummer3 = 0;
	}

	public boolean addNummer(int nummer){
		if(nummer > nummer1){
			nummer3 = nummer2;
			nummer2 = nummer1;
			nummer1 = nummer;
			return true;
		}
		if(nummer > nummer2){
			nummer3 = nummer2;
			nummer2 = nummer;
			return true;
		}
		if(nummer > nummer3){
			nummer3 = nummer; 
			return true;
		} 
		return false;
	}

}

class day1{
	public static void main(String[] args) throws Exception{
		FileReader fr = new FileReader("./input.txt");		
		int i;
		boolean newInventory = false;
		String currentNumber = "";
		int number = 0;
		Three maxNumbers = new Three();
		int maxCount = 0;
		int countInventory = 1;
		while ((i = fr.read()) != -1){
			if((char) i == '\n'){
				if(newInventory){
					if(maxNumbers.addNummer(number)){
						maxCount = countInventory;
					} 
					number = 0;
					countInventory++;
					newInventory = false;
					continue;
				}
				else{
					newInventory = true;

					number += Integer.parseInt(currentNumber);
					currentNumber = "";
					continue;
				}
			}
			else{
				newInventory = false;
			}
			currentNumber += (char) i;

			// if((char) i != '\n'){
			// 	System.out.print((char)i);
			// }
		}
		number += Integer.parseInt(currentNumber);
		if(maxNumbers.addNummer(number)){
			maxCount = countInventory;
		}
		System.out.println("es gibt " + countInventory);
		int sum = maxNumbers.nummer1 + maxNumbers.nummer2 + maxNumbers.nummer3;
		System.out.println("" + sum);
	}
}

