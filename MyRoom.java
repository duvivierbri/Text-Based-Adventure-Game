package gamepackage;

public class MyRoom implements Room{

	private int roomIndex;
	private String description;
	private MyMonster monster = new MyMonster();
	
	public MyRoom() { //default constructor - default values
		int roomIndex = 0;
		String description = "no room description";
		MyMonster aMonster = new MyMonster();
	}
	
	public MyRoom(int RI, String desc, MyMonster monster) { //overloaded
		this.roomIndex = RI;
		this.description = desc;
		this.monster = monster;
		
	}
	
	public MyMonster getMonster() {
		return this.monster;
	}
	
	@Override
	public boolean isComplete() {
		if (this.monster.getHitPoints() <= 0) {
			System.out.println("The monster has died");
			return true;
		} else {
			System.out.println("The monster has NOT died");
			return false;
		}
	}

	@Override
	public void enter(Player player) {
		System.out.println("You have now entered room " + roomIndex + ", " + description + " with a " + monster.getName() + ". \n"
				+ "FIGHT!!");
		
	}
	
	@Override 
	public String toString() { //ask about and complete later...
		System.out.printf("Room index %2d, description %20s, monster name %20s", roomIndex, description, monster.getName());
		return "";
	}
	
	public void setMonster(MyMonster monster) {
		this.monster = monster;
	}

}
