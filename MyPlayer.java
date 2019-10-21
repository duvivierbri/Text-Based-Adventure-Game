package gamepackage;

public class MyPlayer extends MyCreature implements Player{
	
	private int healAmount;
	
	public MyPlayer() {
		super(); //brings down name,description,hitpoints,damage, and room
		healAmount = 0;
	}
	
	public MyPlayer(String name, String description, int HP, int damage, int room, int healamount) {
		super(name,description,HP,damage,room);
		this.healAmount = healamount;
	}

	@Override
	public void heal() { //increases HP or life bar
		int newHP;
		int thisHP = super.getHP();
		newHP = thisHP += this.healAmount;
		System.out.println(newHP);
	}
	
	public int getHealAmount() {
		return this.healAmount;
	}
	
	public void setHealAmount(int heal) {
		this.healAmount = heal;
	}
}
