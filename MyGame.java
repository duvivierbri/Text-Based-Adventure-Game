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
		
		
		// works up to here~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		
		//Now lets make the rooms with monsters in them~~~~~~~~~~~~~~~~
		
		FileInputStream filestream = new FileInputStream("DungeonDetails.txt");
		outStream = new Scanner(filestream);
		
		this.dungeon = new MyRoom[3]; //assign this dungeon to 3
		
		MyMonster monster1 = new MyMonster("BlipBlop","slimy creature",100,10,0,0);
		MyMonster monster2 = new MyMonster();
		MyMonster monster3 = new MyMonster();

		//Creating the rooms
		
		MyRoom room1 = new MyRoom(0, "a small room", monster1);
		MyRoom room2 = new MyRoom(1, "medium room", monster2);
		MyRoom room3 = new MyRoom(2, "large room", monster3);
		
		this.dungeon[0] = room1;
		this.dungeon[1] = room2;
		this.dungeon[2] = room3;

	}
	
	
	public void createFiles() {
		FileHandler handler = new FileHandler();
		handler.createNewFile("DungeonDetails.txt"); //For the dungeon info
		handler.createNewFile("PlayerInfo.txt"); //For the player info
		handler.createNewFile("SaveFile.txt"); //For the save file.. everything will go here
		handler.appendToFile("SaveFile.txt", "Your name is " + this.player.getName() + ", " + this.player.getDescription());
		handler.appendToFile("PlayerInfo.txt", "Kratos\na powerful warrior\n100\n15\n30");
		handler.appendToFile("DungeonDetails.txt", "orc\ndead\n0\n10\n0\n0\nskeleton\nstink\n35\n10\n6\n1"
				+ "\ndragon\nlarge\n100\n20\n30\n2\ntrue\nhuge room\na large pile of gold");
		this.player.toString();
	
	}
	
	@Override
	public void play() {
		this.player.setRoom(0);
		Scanner scnr = new Scanner(System.in);
		String initiate;
		System.out.println("Hello! Welcome to the game :) Are you ready?");
		initiate = scnr.next();
		do {
			
			System.out.println("Your name is " + this.player.getName() + "...");
			
			if (this.player.getRoom() == 0) {
				System.out.println("You enter the first room. You get attacked by a" + this.dungeon[0].getMonster().getName());
				MyBattle battle1 = new MyBattle(this.player, this.dungeon[0].getMonster());
				battle1.run();
			}
			
			break;
			
			
		}while(initiate.equals("yes"));
	}
	


}
