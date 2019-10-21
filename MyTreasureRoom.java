package gamepackage;

public class MyTreasureRoom extends MyRoom implements TreasureRoom{

	private String treasure;

	public MyTreasureRoom() {
		super();//roomindex, description and monster
		treasure = "";
	}
	
	public MyTreasureRoom(int RI, String desc, MyMonster monster, String trea) {
		super(RI,desc,monster);
		this.treasure = trea;
	}
	
	@Override
	public void enter(Player player) {
		super.enter(player);
		
		if (super.getMonster().getHitPoints() <= 0) {
			System.out.println("Congratulations! You've obtained the " + this.treasure);
		}
	}
	
}
