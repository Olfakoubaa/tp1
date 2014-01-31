import java.util.ArrayList;
import java.util.Random;

/**
 * Impl�mentation de la m�thode de clustering
 * 0-Initialiser le nombre de clusters
 * 1-Choisir de n sommets al�atoires parmis les donn�es = centres des clusters
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
	private Cluster []  clusters;
	
	/**constructeur*/
	Kmeans(ArrayList<Record>records, int k){		
		this.k=k;
		this.clusters=new Cluster[k];
		this.records=records;
	}

	/**m�thode qui renvoi k ombres al�atoires */
	
	private int [] alea(){
		/**choix de k nombres al�atoires distincts */
		int tabAl�a[]=new int[this.k];
		Random rd=new Random();	
		for(int i=0;i<this.k;i++){		
			//nombre al�atoire
			int r=rd.nextInt(10);
			//chercher s'il exite 
			int j=0;	
				while (j<i){
					while(tabAl�a[j]==r){
						r=rd.nextInt(10);
						j=0;
					}
					j++;
				}	
			tabAl�a[i]=r;	
		}
		return tabAl�a;
	}
	
	/**initialisation des groupes*/
	public void initClusters (){		
		
		int tabAl�a[]=alea();	
		/**initialiser les �l�ments et les classes*/

		for(int i=0;i<k;i++){
			//ajouter l'�lement al�atoire  � la classe
			records.get(tabAl�a[i]).setCorrectClass(k);
			//initialiser les classe : centre = l'�lement , id = i 
			clusters[i]=new Cluster(i,records.get(tabAl�a[i]).getData());
			
			//affichage
			System.out.print("Classe "+clusters[i].getId() +"\telement: "+ tabAl�a[i]+"\t");
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
