public class Cluster {
	
	/**le centre du groupe*/
	private double[] center;
	
	/**identifiant*/
	private int id;
	
	/**Le constructeur initialisation 
	 * le centre de la classe 
	 * l'identifiant de chaque classe*/
	Cluster(int id,double [] center){
		this.center=center;
		this.id=id;
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

	public void setId(int id) {
		this.id = id;
	}
	
}