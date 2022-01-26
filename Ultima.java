/**
 * Ultima 0.1 Main game loop
 * 
 * @author Keith Vertanen
 * @author Michele Van Dyne - added commenting
 *
 */
package ultima;

import java.awt.Font;

public class Ultima 
{	
	/**
	 * The main method for the Ultima game loop
	 */
	public static void main(String [] args)
	{
		final String level = "30x20.txt"; //change level file here
		final String boss = "BOSS.txt";
		
//		if (args.length <= 0)
//		{
//			System.out.println("Must specify a level file!");
//			return;
//		}
		final int SLEEP_MS = 100;
		
//		World world = new World(args[0]);
		World world = new World(level);
				
		StdDraw.show(0);
		world.draw();
		
		// Keep looping as long as avatar hasn't died
		while (world.avatarAlive() && world.getNumMonsters() > 0)
		{
			if (StdDraw.hasNextKeyTyped())
            {				
                char ch = StdDraw.nextKeyTyped();
                world.handleKey(ch);
            }
            
			// Redraw everything and then sleep for a bit
			StdDraw.clear();
			world.draw();
			StdDraw.show(SLEEP_MS);			
		}
		
		StdDraw.setFont(new Font("SansSerif", Font.BOLD, 40));
		
		if(world.avatarAlive() == false) {
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.text(700, 500, "YOU DIED");
			StdDraw.show();

		} else {
			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.text(700, 500, "LEVEL UP");
			StdDraw.show();
		}
		
		
		if (world.getNumMonsters() == 0) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			StdDraw.clear();
			
			World bossLvl = new World(boss);
			
			StdDraw.show(0);
			bossLvl.draw();
			
			// Keep looping as long as avatar hasn't died
			while (bossLvl.avatarAlive() && bossLvl.getNumMonsters() > 0)
			{
				if (StdDraw.hasNextKeyTyped())
	            {				
	                char ch = StdDraw.nextKeyTyped();
	                bossLvl.handleKey(ch);
	            }
	            
				// Redraw everything and then sleep for a bit
				StdDraw.clear();
				bossLvl.draw();
				StdDraw.show(SLEEP_MS);			
			}
			
			StdDraw.setFont(new Font("SansSerif", Font.BOLD, 40));
			
			if(bossLvl.avatarAlive() == false) {
				StdDraw.setPenColor(StdDraw.RED);
				StdDraw.text(500, 500, "YOU DIED");
				StdDraw.show();

			} else {
				StdDraw.setPenColor(StdDraw.GREEN);
				StdDraw.text(500, 500, "YOU WIN!!");
				StdDraw.show();
			}
			
		}
	}
}
