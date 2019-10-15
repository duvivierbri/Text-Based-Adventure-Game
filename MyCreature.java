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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void takeDamage(int damage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String toString(){
		return ""; //Just for now... not yet set
	}
	

}
