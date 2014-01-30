
public class Record {

	
    /**  tableau des données d'une ligne  */
    private double []data;
    
    /** le groupe auquel appartient la ligne */
    private int correctClass;
 
    Record(double[]data){
    	this.data=data;
    	this.correctClass=0;
    }
    
    public double[] getData() {
        return data;
    }

	public int getCorrectClass() {
		return correctClass;
	}

	public void setCorrectClass(int correctClass) {
		this.correctClass = correctClass;
	}

	public void setData(double[] data) {
		this.data = data;
	}
    
}
