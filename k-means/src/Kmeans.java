import java.util.ArrayList;

/**
 * Impl�mentation de la m�thode de clustering
 * 0-Initialiser le nombre de clusters
 * 1-Choisir de n sommets al�atoires = centres des clusters
 * 2-Classer les points dans les clusters 
 * 3-Calculer des nouveaux centres des clusters 
 * 
 * @author Olfa
 *
 */
public class Kmeans {
	
	/** Liste des Donn�es*/
	private ArrayList <Record>records;
	
	/**nombre des groupes*/
	private int k;
	
	/**liste des groupes*/
	private ArrayList<Cluster>clusters;
}
