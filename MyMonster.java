package gamepackage;

public class MyMonster extends MyCreature implements Monster{
	
	private String name;
	private String description;
	private int hitPoints;
	private int damage;
	private int room;
	//attributes specifically for monsters
	private int enrageThreshold;
	
	public MyMonster() {
		name = "";
		description = "";
		hitPoints = 0;
		damage = 0;
		room = 0;
		enrageThreshold = 0;
	}
	
	public MyMonster(String name, String dcrp, int hp, int damage, int room, int et) {
		this.name = name;
		this.description = dcrp;
		this.hitPoints = hp;
		this.damage = damage;
		this.room = room;
		this.enrageThreshold = et; //phone home
	}
	
	public int getHitPoints() {
		return this.hitPoints;
	}
	
	@Override
	public void enrage() {
		if (this.hitPoints < this.enrageThreshold) {
			this.damage = this.damage *2;
		}
		
	}

	@Override
	public boolean canEnrage() {
		if (this.hitPoints < this.enrageThreshold) {
			return true;
		}else {
			return false;
		}
	}

}
