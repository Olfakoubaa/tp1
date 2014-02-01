import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
/***
 * c'est la classe qui   
 * 
 *
 */
public class Cluster implements ObjetDessinable{
	
	/**le centre du groupe*/
	private double[] center;
	
	/**identifiant*/
	private int id;
	
	/**
	* Liste des points du cluster
	*/
	private LinkedList<float[]> points;
	
	
	private Kmeans kmean;
	
	/**Le constructeur initialisation 
	 * le centre de la classe 
	 * l'identifiant de chaque classe*/
	Cluster(int id,double [] center){
		this.center=center;
		this.id=id;
		 points = new LinkedList<float[]>();
	        this.kmean = kmean;
	}
	/**les gtter and setter */
	public double [] getCenter() {
		return center;
	}

	public void setCenter(double [] center) {
		this.center = center;
	}

	public int getId() {
		return id;
	}
	public void setPoints(LinkedList<float[]> points) {
		this.points = points;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void dessinerObjet(Graphics g) {
		// TODO Auto-generated method stub
		if (this.center.length==2){
			// On plot les points du cluster
			Random alea = new java.util.Random(System.currentTimeMillis());
			Color couleur = new Color(Math.abs(alea.nextInt()) % 256,Math.abs(alea.nextInt()) % 256,Math.abs(alea.nextInt()) % 256);
			g.setColor(couleur);
			Iterator<float[]> iter = this.points.iterator();
			while (iter.hasNext()){
				float[] cluster = iter.next();
				int[] pointDessin= new int[2];
				pointDessin[0]= (int) cluster[0]*5;
				pointDessin[1]= (int) cluster[1]*5;
				g.fillRect(pointDessin[0],pointDessin[1],3,3);
			}
			g.fillRect((int)this.center[0]*5,(int)this.center[1]*5,5,5);
		}
	}
	
}