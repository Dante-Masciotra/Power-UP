import java.util.*;
public class Game {

	
	static int money;
	static String userName;
	static Scanner in = new Scanner (System.in);
	static Random random = new Random();
	
	
	public static void main (String[] args) {
	System.out.println("Please entre username...");
	userName =in.nextLine();
	System.out.println("Welcome " + userName + "!");
	
	money = 1000;
	rollDice();
	
	
	
	
	
	
	
	
}


	public  static void rollDice() {
		System.out.println("You have: $" + money);
		System.out.println("What number would you like to bet on? (1-6)" );
		int betRoll = in.nextInt();
		System.out.println("How much would you like to bet?");
		int betMoney = in.nextInt();
		
			while (betMoney > money) {
				System.out.println("You don't have that much money!!"); 
				System.out.println("how much do you want to bet?");
				betMoney = in.nextInt();}
			 int dice;
			 dice = random.nextInt(6) +1;
			 
			 if(betRoll == dice)
			 {
				 System.out.println("you have won! you win: $" + betMoney*6);
				 money = money + (betMoney*6);
			 }
			 else {
				 
				 System.out.println("you have lost:(");
				 money = money - betMoney;
			 }
			 if(money<=0) {

				 System.out.println("Your broke");
				 
			 
			 //d@nte was here
			 }
			 else {
				 rollDice();
			 }}
			 }