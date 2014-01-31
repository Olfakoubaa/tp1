import java.util.ArrayList;


public class Cluster {
	
	/**le centre du groupe*/
	private double[] center;
	
	/**identifiant*/
	private int id;
	
	Cluster(int id,double [] center){
		this.center=center;
		this.id=id;
	}
	
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