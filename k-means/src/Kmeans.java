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
	private Cluster []  clusters;
	
	/**constructeur*/
	Kmeans(ArrayList<Record>records, int k){		
		this.k=k;
		this.clusters=new Cluster[k];
		this.records=records;
	}

	/**méthode qui renvoi k ombres aléatoires */
	
	private int [] alea(){
		/**choix de k nombres aléatoires distincts */
		int tabAléa[]=new int[this.k];
		Random rd=new Random();	
		for(int i=0;i<this.k;i++){		
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
		return tabAléa;
	}
	
	/**initialisation des groupes*/
	public void initClusters (){		
		
		int tabAléa[]=alea();	
		/**initialiser les éléments et les classes*/

		for(int i=0;i<k;i++){
			//ajouter l'élement aléatoire  à la classe
			records.get(tabAléa[i]).setCorrectClass(k);
			//initialiser les classe : centre = l'élement , id = i 
			clusters[i]=new Cluster(i,records.get(tabAléa[i]).getData());
			
			//affichage
			System.out.print("Classe "+clusters[i].getId() +"\telement: "+ tabAléa[i]+"\t");
				double [] T=clusters[i].getCenter();
				for(int j=0;j<T.length;j++)
					System.out.print(T[j]+"\t");
				System.out.println("\n");
		}

	}
	
	
	
	public ArrayList<Record> getRecords() {
		return records;
	}

	public void setRecords(ArrayList<Record> records) {
		this.records = records;
	}

	public Cluster[] getClusters() {
		return clusters;
	}

	public void setClusters(Cluster[] clusters) {
		this.clusters = clusters;
	}

	
	
}
