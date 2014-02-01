import java.util.ArrayList;
import java.util.Random;

import java.util.Iterator;
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
	
	/** Liste des Données
	 * chaque ligne du fichier est 
	 * stocker en tant qu'un ckuster*/
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
	
	/**Calcul de la distance */
	 public double calculateDistance(double [] x1, double [] x2) {
	     
		 /**si les deux elements ne sont pas de la meme taille*/  
		 if (x1.length != x2.length) {
	            throw new IllegalArgumentException(
	                    "Vectors should be of equal length: x1 length = "
	                            + x1.length + " x2 length = " + x2.length);
	        }
		 
		 /**formule : dist= racine(produit (xi-yi))*/
	        double val = 0;
	        double temp;
	        for (int i = 0; i < x1.length; i++) {
	            temp = x1[i] - x2[i];
	            temp *= temp;
	            val += temp;
	        }

	        return Math.sqrt(val);
	    }
	
	 /**retourne l'indice de l'élement minimal d'un tableau*/
	 public int searchMin(double [] T){
		 
		 int min=0;
		 for (int i=0;i<T.length;i++){
			 if (T[i]<T[min])
				 min=i;
		 }
		 return min;
	 }
	 
	 
	/**classer les points dans les clusters*/
	 public void iteration(){	 
		 double[]distances=new double[k];
		 for(int i=0;i<records.size();i++){
			 for(int j=0;j<k;j++){
				//calculer la distance par rapport à tt les centres
				 distances[k]=calculateDistance(records.get(i).getData(),clusters[i].getCenter());
				//prendre la distance minimale 
				 int min=searchMin(distances);
				 //déplacer l'élement dans la classe correspendante 
				 if(min!=records.get(i).getCorrectClass()){
					 records.get(i).setCorrectClass(min);
				 }
			 }
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

	public void afficher(){
		ZoneGraphique zone = new ZoneGraphique("K means");
		//Iterator<Cluster> iter = this.clusters.iterator();
		
		for (int i=0;i<clusters.length;i++)
		{
			zone.ajouterObjet((ObjetDessinable) clusters[i]);
					}
	}
	
}
