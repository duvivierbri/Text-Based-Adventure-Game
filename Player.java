package gamepackage;

public interface Player extends Creature {



	/**

	 * 

	 * This method will increase the <code>hitPoints</code> for <code>this Player</code> by <code>this.healAmount</code>.

	 * <br>

	 * <br>

	 * This method will also display the message:

	 * <br>

	 * <br>

	 * "<code>this.name</code> is healed by <code>this.healAmount</code>"

	 * 

	 */

	public void heal();

	

}