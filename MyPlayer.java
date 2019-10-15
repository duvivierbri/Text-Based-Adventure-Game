package gamepackage;

public class MyPlayer extends MyCreature implements Player{
	
	private int healAmount;
	private String name;
	private String description;
	private int hitPoints;
	private int damage;
	private int room;
	
	public MyPlayer() {
		healAmount = 0;
		name = "";
		description = "";
		hitPoints = 0;
		damage = 0;
		room = 0;
	}
	
	public MyPlayer(String name, String description, int hp, int damage, int room, int healamount) {
		this.name = name;
		this.description = description;
		this.hitPoints = hp;
		this.damage = damage;
		this.room = room;
		this.healAmount = healamount;
	}

	@Override
	public void heal() { //increases HP or life bar
		this.hitPoints += this.healAmount;
		System.out.println(this.hitPoints);
	}

}
