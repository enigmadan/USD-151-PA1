/**
 * File: Tree.java
 * @author
 * @version
 * Description: Class to display a Tree fractal.
 */

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

/**
 * Main class to get user input and get everything started.
 */
public class Tree
{
    public static void main(String[] args)
	{
		/*// Get user parameters.
Scanner keyboardInput = new Scanner(System.in);
System.out.println("Enter length of central trunk, "
+ "as an integer number of pixels: ");
final int size = keyboardInput.nextInt();
System.out.println("Enter depth of recursion "
+ "(0 represents just drawing the triangle): ");
final int maxLevelsOfRecursion = keyboardInput.nextInt();
System.out.println("Enter number of branches per branch: ");
final int numBranches = keyboardInput.nextInt();
System.out.println("Enter length of subbranch as a "
+ "fraction of the length of its parent: ");
final double lengthScaleFactor = keyboardInput.nextDouble();
System.out.println("Enter the angle that a subbranch "
+ "makes with its parent: ");
final double branchAngle = keyboardInput.nextDouble();
System.out.println("Print files (1) or not (0): ");
final int printFiles = keyboardInput.nextInt();
		 */

		// Get everything going.
		// Get user parameters.
		final int size = 300;
		final int maxLevelsOfRecursion = 4;
		final int numBranches = 4;
		final double lengthScaleFactor = .6;
		final double branchAngle = 7;
		final int printFiles = 0;

		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				TreeFrame frame = new TreeFrame(size,
						maxLevelsOfRecursion, numBranches, lengthScaleFactor,
						branchAngle, printFiles);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

/**
 * A frame containing a panel to display the Koch snowflake.
 */
class TreeFrame extends JFrame
{
	/** Initialize the frame that will contain the Koch snowflake.
	 * @param size The length of the triangle sides.
	 * @param maxLevelsOfRecursion The number of levels of recursion to
	 * to use in displaying the Koch snowflake. (If this parameter
	 * is 0, just the triangle is displayed.
	 * @param numBranches The number of subbranches to draw off of each
	 * branch.
	 * @param lengthScaleFactor The length of each subranch, as a fraction
of the length of the branch it is coming off of.
	 * @param branchAngle The angle each subbranch makes with the branch
	 * it is coming off of.
	 * @param printFiles 1 if jpeg files containing the fractal images
	 * should be drawn, and 0 if not.
	 */
	public TreeFrame(int size, int maxLevelsOfRecursion, int numBranches,
			double lengthScaleFactor, double branchAngle, int printFiles)
	{
		// Set parameters of the frame.
		setTitle("Fractal Tree");
		setSize(2 * size, 2 * size);

		// Add component to frame
		TreeComponent component = new TreeComponent(size, maxLevelsOfRecursion,
				numBranches, lengthScaleFactor,
				branchAngle, printFiles == 1);
		add(component);
	}
}

/**
 * A component with operations to display the Koch snowflake.
 */
class TreeComponent extends JComponent
{
	/** Initialize the component that will contain the Koch snowflake.
	 * @param size The length of the triangle sides.
	 * @param maxLevelsOfRecursion The number of levels of recursion to
	 * to use in displaying the Koch snowflake. (If this parameter
	 * is 0, just the triangle is displayed.
	 * @param numBranches The number of subbranches to draw off of each
	 * branch.
	 * @param lengthScaleFactor The length of each subranch, as a fraction
of the length of the branch it is coming off of.
	 * @param branchAngle The angle each subbranch makes with the branch
	 * it is coming off of.
	 * @param printFiles true if jpeg files containing the fractal images
	 * should be drawn.
	 */
	public TreeComponent(int size, int maxLevelsOfRecursion,
			int numBranches, double lengthScaleFactor,
			double branchAngle, boolean printFiles)
	{
		// Initialize fields.
		this.size = size;
		this.maxLevelsOfRecursion = maxLevelsOfRecursion;
		this.numBranches = numBranches;
		this.lengthScaleFactor = lengthScaleFactor;
		this.branchAngle = branchAngle;
		this.currentLevelOfRecursion = 0;
		this.printFiles = printFiles;

		// Set points of the tree trunk within the component.
		// Sort of center it.
		p1 = new Point2D.Double(size, size + POSITION_TRUNK * size);
		p2 = new Point2D.Double(size, POSITION_TRUNK * size);

		// Add mouse listener.
		addMouseListener(new MouseHandler());
	}

	/** Draw the component.
	 * @param g The Graphics object to paint to.
	 */
	public void paintComponent(Graphics g)
	{
		// Draw the Tree Fractal.
		drawFractalTree((Graphics2D) g);

		// Print the image to a file, if asked.
		if (printFiles)
		{
			BufferedImage bi = new BufferedImage(2 * size, 2 * size,
					BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = bi.createGraphics();
			g2.setColor(Color.white);
			g2.fillRect(0, 0, 2 * size, 2 * size);
			g2.setColor(Color.black);
			drawFractalTree(g2);
			try
			{
				ImageIO.write(bi, "JPEG", new File("Fractal Tree " +
						currentLevelOfRecursion + ".jpg"));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	public void drawFractalTree(Graphics2D g2){

		drawLine(g2, currentLevelOfRecursion, p1, p2);
	}


	public void drawLine(Graphics2D g2, int n, Point2D p1, Point2D p2)
	{
		double hyp = size * Math.pow(lengthScaleFactor, currentLevelOfRecursion-n+1);
		double imRad = (branchAngle) * Math.PI / 180;
		double angle = Math.atan(Math.abs((p2.getX() - p1.getX())/(p2.getY()-p1.getY())));
		Point2D	pB;
		g2.setColor(new Color(118-((currentLevelOfRecursion-n)*54/(currentLevelOfRecursion+1)),
				64+((currentLevelOfRecursion-n)*40/(currentLevelOfRecursion+1)),
				41-((currentLevelOfRecursion-n)*19/(currentLevelOfRecursion+1))));
		if (n != 0)
		{
			for(int i = 1;i <= numBranches;i++){
				
				Point2D pA = new Point2D.Double(p1.getX() + (i * (p2.getX() - p1.getX()) / (numBranches + 1)),
						p1.getY() + (i * (p2.getY() - p1.getY()) / (numBranches + 1)));
				double x;
				double y;
				
				if((p1.getX()-p2.getX() > 0)){
					
					x = pA.getX() + Math.sin(angle - Math.PI + (i % 2 == 0 ? -1 : 1) * imRad) * hyp;
				}else{
					x = pA.getX() + Math.sin(angle + (i % 2 == 0 ? -1 : 1) * imRad) * hyp;

				}
				
				if((p1.getY() - p2.getY() < 0)){
					
					y = pA.getY() - Math.cos(angle - Math.PI + (i % 2 == 0 ? -1 : 1) * imRad) * hyp;
				}else{
					y = pA.getY() - Math.cos(angle + (i % 2 == 0 ? -1 : 1) * imRad) * hyp;	
					
				}
					pB = new Point2D.Double(x, y);
					
				drawLine(g2, n-1, pA, pB);

			}

		}
		g2.draw(new Line2D.Double(p1, p2));

	}
	// Private fields.
	private int currentLevelOfRecursion;
	private final int size;
	private final int maxLevelsOfRecursion;
	private final int numBranches;
	private final double lengthScaleFactor;
	private final double branchAngle;

	private final boolean printFiles;
	private final double POSITION_TRUNK = 0.7;

	// The the points of the central trunk.
	private final Point2D p1;
	private final Point2D p2;

	/** Class to handle mouse events.
	 */
	private class MouseHandler extends MouseAdapter
	{
		/**
		 * Update the current levels of recursion. If a single click, then
		 * increment current levels by one, unless it is already the max level,
		 * and then reset to 0. If a double click, jump to max levels
		 * of recursion. Then redraw the Koch snowflake.
		 * @param event The mouse event.
		 */
		public void mouseClicked(MouseEvent event)
		{
			if (event.getClickCount() == 1)
				currentLevelOfRecursion =
					currentLevelOfRecursion == maxLevelsOfRecursion ? 0 :
						currentLevelOfRecursion + 1;
			else
				currentLevelOfRecursion = maxLevelsOfRecursion;

			repaint();
		}
	}
}
