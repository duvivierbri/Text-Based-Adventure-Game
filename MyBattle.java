package gamepackage;
import java.util.Scanner;

//Doesnt work but I kind of have the concept down and know what to do OVERRIDED CONSTRUCTOR
public class MyBattle implements Battle{
	private MyPlayer player = new MyPlayer();
	private MyMonster monster = new MyMonster();
	private String move;
	private boolean yourTurn;
	private boolean opponentTurn;
	private boolean battleInProgress; //This variable would help keep track of when the battle has ended
	
	public MyBattle(){
		this.yourTurn = true; //always start a battle with it being your turn
		this.opponentTurn = false;
		this.move = "";
	}
	
	public MyBattle(MyPlayer player, MyMonster monster) { //overrided constructor
		this();
		this.player = player;
		this.monster = monster;
	}
	
	@Override
	public void run() {
		
		do {
			Scanner scnr = new Scanner(System.in);
			//Player's turn if statements!
			if (yourTurn && this.player.getHP() > 0) {
				System.out.println("Its your turn! Make your move...");
				move = scnr.next();
					//setting possible moves for the player
					if (move.equalsIgnoreCase("attack")) {
						System.out.println("You violently slash the " + this.monster.getName() + 
								" causing them to stagger back in pain. \n You make " + this.player.getDamage() + " damage.");
						this.monster.takeDamage(this.player.getDamage()); //monster gets hit
					} else {
						if (move.equalsIgnoreCase("heal")) {
							if (this.player.getHP() == 100) { //If they already have full health they can't heal.. thats cheating!!
								System.out.println("You cannot heal, you have full health!");
							} else {
								System.out.println("You eat one of the apples you took on your journey, giving you " + this.player.getHealAmount() +
										" more HP!! \n You now have " + this.player.getHP() + " HP!!");
								this.player.heal();
							}
						}
						this.monster.toString();
						this.player.toString();
					}
					
					if (this.monster.getHP() <= 0) {
						System.out.println("You win!");
						battleInProgress = false;
						break;
					} 
					
				yourTurn = false;
				opponentTurn = true;
			}
			//End of player's turn if statements :)
			
			//Monster's turn if statements!
			if(opponentTurn && this.monster.getHP() > 0) {
				int damage = this.monster.getDamage();
				int enragedDamaged = damage * 2;
				System.out.println("Monster's turn!");
					if (this.monster.getHP() > this.monster.getEnrage()) {
						System.out.println(this.monster.getName() + " attacked you! You lose " + damage + " HP!");
						this.player.takeDamage(damage); //player gets hurt!
					} else {
						System.out.println(this.monster.getName() + " is enraged and attacked you! You lose " + enragedDamaged + " HP!");
						this.player.takeDamage(enragedDamaged); //player gets hurt!
					}
				System.out.println("Type anything and press enter to continue....");
				move = scnr.next();
				opponentTurn = false;
				yourTurn = true;
				
				if (this.player.getHP() <= 0) {
					System.out.println("You lose!");
					battleInProgress = false;
					break;
				}
				
				this.monster.toString();
				this.player.toString();
			}
			
			//And when one of them dies... you either say you win or you lose!
			

			if (this.monster.getHP() <= 0 || this.player.getHP() <= 0) {
				battleInProgress = false;
			}
			
			if (battleInProgress = false) {
				scnr.close();
				break;
			}
			
		}while (battleInProgress = true);
		 //now close the scanner :)
	}

}
