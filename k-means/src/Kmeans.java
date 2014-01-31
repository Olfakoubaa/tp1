import java.util.ArrayList;
import java.util.Random;

/**
 * Implémentation de la méthode de clustering
 * 0-Initialiser le nombre de clusters
 * 1-Choisir de n sommets aléatoires parmis les données = centres des clusters
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
	
	Kmeans(ArrayList records, int k){		
		this.k=k;
		this.clusters=new ArrayList<Cluster>();
		this.records=records;
	}

	/**initialisation des groupes*/
	private void initClusters (){		
		/**choix de k nombres aléatoires distincts */
		int tabAléa[]=new int[k];
		Random rd=new Random();	
		
		for(int i=0;i<k;i++){		
			//nombre aléatoire
			int r=rd.nextInt(10);
			//chercher s'il exite 
			int j=0;	
				while (j<i){
					while(tabAléa[j]==r){
						r=rd.nextInt(10);
						j=0;
					}
					j++;
				}	
			tabAléa[i]=r;	
		}
	
		//clusters.add()
		/**ajouter les*/
		
	}
	
	
	
	public ArrayList<Record> getRecords() {
		return records;
	}

	public void setRecords(ArrayList<Record> records) {
		this.records = records;
	}

	public ArrayList<Cluster> getClusters() {
		return clusters;
	}

	public void setClusters(ArrayList<Cluster> clusters) {
		this.clusters = clusters;
	}
	
}
