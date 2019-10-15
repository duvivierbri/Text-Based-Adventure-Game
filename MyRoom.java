package gamepackage;

public class MyRoom implements Room{

	private int roomIndex;
	private String description;
	private MyMonster monster = new MyMonster();
	
	@Override
	public boolean isComplete() {
		if (this.monster.getHitPoints() <= 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void enter(Player player) {
		System.out.println("You have now entered room " + roomIndex + ", " + description + " with a " + monster + ". \n"
				+ "FIGHT!!");
		
	}
	
	@Override 
	public String toString() { //ask about and complete later...
		return "";
	}

}
