package gamepackage;

public class MyMonster extends MyCreature implements Monster{
	//attributes specifically for monsters
	private int enrageThreshold;
	
	public MyMonster() {
		super(); //brings down the name,description, hitpoints,damage and room
		enrageThreshold = 0;
	}
	
	public MyMonster(String name, String description, int HP, int damage, int room, int et) {
		super(name,description,HP,damage,room);
		this.enrageThreshold = et; //phone home
	}
	
	
	public int getEnrage() {
		return this.enrageThreshold;
	}
	
	public void setThreshhold(int num) {
		this.enrageThreshold = num;
	}
	
	@Override
	public void enrage() {
		int newDamage;
		int damage = this.getDamage();
		if (canEnrage()) {
			newDamage = damage *2;
			System.out.println(newDamage);
		} else {
			System.out.println("Cannot enrage");
		}
		
	}

	@Override
	public boolean canEnrage() {
		if (this.getHP() < this.enrageThreshold) {
			System.out.println("True");
			return true;
		}else {
			System.out.println("False");
			return false;
		}
	}

}
