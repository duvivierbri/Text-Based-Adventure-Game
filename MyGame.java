package gamepackage;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyGame implements Game{
	private MyRoom [] dungeon;
	private MyPlayer player = new MyPlayer();
	FileHandler handle = new FileHandler();
	
	
	
	public MyGame() throws IOException{ //default
		
		FileInputStream fileStream = null;
		Scanner outStream = null;
		FileHandler handler = new FileHandler();
		handler.createNewFile("PlayerInfo.txt"); //For the player info
		handler.createNewFile("SaveFile.txt"); //For the save file.. everything will go here
		handler.writeToNewFile("PlayerInfo.txt", "Faith\na powerful warrior who wants to save her dog who was stolen by the Evil Witch\n100\n20\n50");
		fileStream = new FileInputStream("PlayerInfo.txt");
		outStream = new Scanner(fileStream);
		String name = "";
		String description = "";
		int HP;
		int damage;
		int healing;
		name = outStream.nextLine();
		description = outStream.nextLine();
		HP = outStream.nextInt();
		damage = outStream.nextInt();
		healing = outStream.nextInt();
		
		this.player.setName(name);
		this.player.setDescription(description);
		this.player.setHP(HP);
		this.player.setDamage(damage);
		this.player.setHealAmount(healing);
		
		outStream.close();
		
		
		//Now lets make the rooms with monsters in them~~~~~~~~~~~~~~~~
		
		this.dungeon = new MyRoom[3]; //assign this dungeon to 3
		
		//MyMonster(String name, String description, int HP, int damage, int room, int et)
		MyMonster monster1 = new MyMonster("Puffle","small ball of pink fur",30,5,0,0);
		MyMonster monster2 = new MyMonster("The Blob", "Green goo that can consume you if you touch it", 45, 10, 1, 20);
		MyMonster monster3 = new MyMonster("Evil Witch", "Old woman who loves magic and dogs for some reason",60, 12, 2, 15);

		//Creating the rooms
		
		MyRoom room1 = new MyRoom(0, "forest of corrupted Puffles", monster1);
		MyRoom room2 = new MyRoom(1, "stinky swamp of lost souls who have been turned into Blobs", monster2);
		MyTreasureRoom room3 = new MyTreasureRoom(2, "a cold, dark,eerie basement in a cobblestone castle", monster3,"Mellow");
		
		this.dungeon[0] = room1;
		this.dungeon[1] = room2;
		this.dungeon[2] = room3;

	}
	
	@Override
	public void play() {
		FileHandler handler = new FileHandler();
		
		Scanner scnr = new Scanner(System.in);
		String initiate = "";
		String answer;
		System.out.println("Hello! Welcome to Faith's Adventure! :) \nYour dog Mellow has been stolen by the evil witch!\nIt's your job to get him back!\nAre you ready? \n[Type yes when you're ready.]");
		
		do {
		answer = scnr.next();
		System.out.println("Please type 'yes' to begin! :)");
		} while(!answer.equalsIgnoreCase("yes"));
		
		handler.writeToNewFile("SaveFile.txt", "Your name is " + this.player.getName() + ", " + this.player.getDescription()); //ensures the file starts over when starting a new game
		System.out.println("Your name is " + this.player.getName() + " and you are " + this.player.getDescription());
		System.out.println("Determined and heartbroken, you pack your apples and set off to save your stolen dog.");
		
		do {
			int i = 0;
			MyBattle battle = new MyBattle();
			for(i = 0; i < 3; i++) {
				//Ensures if you replay, the HP returns to normal :)
				if(i==0) {
					this.dungeon[i].getMonster().setHP(30);
				} else if (i==1) {
					this.dungeon[i].getMonster().setHP(45);
				} else if (i==2) {
					this.dungeon[i].getMonster().setHP(60);
				}
					handler.appendToFile("SaveFile.txt", "You entered room " + i);
					this.dungeon[i].enter(this.player);
					System.out.println(this.dungeon[i].getMonster().toString());
					battle = new MyBattle(this.player, this.dungeon[i].getMonster());
					battle.run();
					if (this.player.isAlive() == false) {
						handler.appendToFile("SaveFile.txt", "You lost in room" + i +" :(");
						break;
					} else if (this.dungeon[i].isComplete()) {
						System.out.println("You defeated " + this.dungeon[i].getMonster().getName() + "!");
						handler.appendToFile("SaveFile.txt", "You completed room " + i + " by defeating " + this.dungeon[i].getMonster().getName() + "!");
						if (i == 2) {
							handler.appendToFile("SaveFile.txt", "You got the treasure and won the game!");
							System.out.println("You won! Would you like to play again?");
							initiate = scnr.next();
							if (initiate.equalsIgnoreCase("yes")) {
								this.player.setHP(100);
								handler.appendToFile("SaveFile.txt", "You decided to play again!");
							}
						}
					}
			}
			
			if (this.player.getHP() <= 0 ) {
				System.out.println("Would you like to play again?");
				initiate = scnr.next();
				if (initiate.equalsIgnoreCase("yes")) {
					this.player.setHP(100);
					handler.appendToFile("SaveFile.txt", "The angels have revived you!");
				}
			}
			
		}while(initiate.equalsIgnoreCase("Yes"));
		
		System.out.println("Thank you for playing!\n             ~THE END~");
	}
	
	public static void main(String[] args) throws IOException {
		MyGame game = new MyGame();
		game.play();
	}
	


}
