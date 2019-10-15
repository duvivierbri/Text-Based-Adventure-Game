package gamepackage;

public class TesterClass {

	public static void main(String [] args) {
		MyPlayer playerObject = new MyPlayer("Bobby", "Big boi", 100, 20, 2, 30);
		MyCreature creatureObject = new MyCreature("Sammy", "Small Boy", 100, 10, 2);
		MyMonster monster = new MyMonster("Boogie Monster", "", 40, 4, 2, 30);
		monster.canEnrage();
	}
}
