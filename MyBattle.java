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
		Scanner scnr = new Scanner(System.in);
		
		//this.monster.toString();
		//this.player.toString();
		
		do {
			
			//Player's turn if statements!
			if (yourTurn && this.player.getHP() > 0) {
				System.out.println("Its your turn! Make your move...");
				move = scnr.next();
					//setting possible moves
					if (move.equalsIgnoreCase("attack")) {
						System.out.println("You violently slash the " + this.monster.getName() + 
								" causing them to stagger back in pain. \n You make " + this.player.getDamage() + " damage.");
						this.monster.takeDamage(this.player.getDamage()); //monster gets hit
					} else {
						if (move.equalsIgnoreCase("heal")) {
							if (this.player.getHP() == 100) { //If they already have full health they cant heal.. thats cheating!!
								System.out.println("You cannot heal, you have full health!");
							} else {
								System.out.println("You drink the magical potion you took on you journey, giving you " + this.player.getHealAmount() +
										" more HP!! \n You now have " + this.player.getHP() + " HP!!");
								this.player.heal();
							}
						}
						this.monster.toString();
						this.player.toString();
					}
				yourTurn = false;
				opponentTurn = true;
			}
			//End of player's turn if statements :)
			
			//Monster's turn if statements!
			if(opponentTurn && this.monster.getHP() > 0) {
				System.out.println("Monster's turn!");
				System.out.println(this.monster.getName() + " attacked you! You lose " + this.monster.getDamage() + " HP!");
				this.player.takeDamage(this.monster.getDamage()); //player gets hurt!
				System.out.println("Type anything and press enter to continue....");
				move = scnr.next();
				opponentTurn = false;
				yourTurn = true;
				
				this.monster.toString();
				this.player.toString();
			}
			
			//And when one of them dies... you either say you win or you lose!
			if (this.monster.getHP() <= 0) {
				System.out.println("You win!");
				break;
			} else if (this.player.getHP() <= 0) {
				System.out.println("You lose!");
				break;
			}

			if (this.monster.getHP() <= 0 || this.player.getHP() <= 0) {
				battleInProgress = false;
			}
		}while (battleInProgress = true);
		
		scnr.close(); //now close the scanner :)
		
	}

}
