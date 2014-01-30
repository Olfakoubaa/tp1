import java.util.ArrayList;

/**
 * Implémentation de la méthode de clustering
 * 0-Initialiser le nombre de clusters
 * 1-Choisir de n sommets aléatoires = centres des clusters
 * 2-Classer les points dans les clusters 
 * 3-Calculer des nouveaux centres des clusters 
 * 
 * @author Olfa
 *
 */
public class Kmeans {
	
	/** Liste des Données*/
	private ArrayList <Record>records;
	
	/**nombre des groupes*/
	private int k;
	
	/**liste des groupes*/
	private ArrayList<Cluster>clusters;
}
