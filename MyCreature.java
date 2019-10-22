package gamepackage;

public class MyCreature implements Creature{
	
	private String name;
	private String description;
	private int hitPoints;
	private int damage;
	private int room;
	
	public MyCreature(){ //default constructor
		name = "no name";
		description = "no description";
		hitPoints = 0;
		damage = 0;
		room = 0;
	}
	
	public MyCreature(String name, String description, int HP, int damage, int room) {
		this.name = name;
		this.description = description;
		this.hitPoints = HP;
		this.damage = damage;
		this.room = room;
	}

	@Override
	public void attack(Creature creature) {
		System.out.println(this.name + " attacks " + creature + " dealing " + this.damage + ".");
		
	}

	@Override
	public void takeDamage(int damage) {
		this.hitPoints = this.hitPoints - damage;
		
	}

	@Override
	public boolean isAlive() {
		if (this.hitPoints > 0) {
			System.out.println("It's still alive");
			return true;
		} else {
			System.out.println("It's dead");
			return false;
		}
	}
	
	@Override
	public String toString(){
		System.out.printf("name %15s, description %20s, hitPoints %03d, damage %02d \n",this.name, this.description,this.hitPoints,this.damage);
		return "";
	}
	

	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String dsc) {
		this.description = dsc;
	}
	
	public void setHP(int HP) {
		this.hitPoints = HP;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public void setRoom(int room) {
		this.room = room;
	}
	
	public int getHP() {
		return this.hitPoints;
	}
	
	public int getDamage() {
		return this.damage;
		
		if (this.hitPoints < 0){
			this.hitPoints = 0;
		}
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getRoom() {
		return this.room;
	}
	

}
