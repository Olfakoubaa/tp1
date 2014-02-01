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
	/**condition d'arret :
	 * la diff�rence entre deux centres < 10 ^ -5
	 * ou
	 * aucun d�placement n'a �t� fait pendant une it�ration*/
	static boolean stop=false;
	/** Liste des Donn�es*/
	private ArrayList <Record>records=new ArrayList <Record>();

	/**nombre des groupes*/
	private int k=0;

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

	 /**retourne l'indice de l'�lement minimal d'un tableau*/
	 public int searchMin(double [] T){

		 int min=0;
		 for (int i=0;i<T.length;i++){
			 if (T[i]<T[min])
				 min=i;
		 }
		 return min;
	 }


	/**classer les points dans les clusters*/
	/** 0-parcourir tt les records 
	 *  1-calculer la distance par rapport a tt les centres
	 *  2-chercher le min 
	 *  3-d�placer l'�lement
	 *  Si aucun d�placement n'a �tait fait :: d�clencher la condition d'arret
	 * */
	 public void iteration(){	

		 //it=1 si au moin une  it�ration est faite 	
		 int it=0;
		 for(int i=0;i<this.records.size();i++){
			 double[]distances=new double[this.k];	

			 for(int j=0;j<this.k;j++){
				 //calculer la distance par rapport � tt les centres
				 distances[j]=calculateDistance(this.records.get(i).getData(),this.clusters[j].getCenter());
				//prendre la distance minimale 
				 int min=searchMin(distances);
				 //d�placer l'�lement dans la classe correspendante 

				 if(min!=this.records.get(i).getCorrectClass()){
//					 System.out.println("je suis dans le if car min = "+min + " <> "+ this.records.get(i).getCorrectClass());
					 this.records.get(i).setCorrectClass(min);
					 it=1;
//					 System.out.println("corect class of ["+ records.get(i).getData()[0]+","+records.get(i).getData()[1]+"] is "+ records.get(i).getCorrectClass());
				 }

//				 System.out.println("je suis pas dans le if car min = "+min + " = "+ this.records.get(i).getCorrectClass());
//				 System.out.println("******");
//				 for (int l=0; l<this.k;l++){
//					 System.out.print(distances[l]+"\t");
//				 }
//				 System.out.println("\nmin= "+min);
			 }
		 }
		 if (it==0) this.stop=true;
	 }

	 /**retourne les �l�ments d'une classe*/
	 public ArrayList <Record> getElements (Cluster clus){
		 ArrayList<Record>rec=new ArrayList();	
		 for(int j=0;j<this.records.size();j++){
			 if (this.records.get(j).getCorrectClass()==clus.getId()){
				 rec.add(records.get(j));
				 }
			 } 
		 return rec;
	 }


	 /**calcul des centre des clusters*/
	 public void calculateCenters(){
//		 int m;
//		 System.out.println("les anciens centres:");
//		 for (m=0;m<this.k;m++){
//			 System.out.println("classe:"+m+"\t"+clusters[m].getCenter()[0]+","+clusters[m].getCenter()[1]);
//		 }
		 int it=0;
		 //parcour de toutes les clusters
		 for (int i=0;i<this.k;i++){
			 //prendre les �lement
			 ArrayList<Record>rec=getElements(this.clusters[i]);
			 //le nouveau centre 
			 double [] newCenter =new double[this.clusters[0].getCenter().length];

			 for (int j=0;j<this.clusters[0].getCenter().length;j++){
			 newCenter[j]=0;
			 	for (int l=0;l<rec.size();l++){
			 		newCenter[j]+=rec.get(l).getData()[j];
			 	}
			 	newCenter[j]=(float)newCenter[j]/rec.size();
		 } 
			 //remplacer le centre 
			 boolean egal=true;
			 for (int h=0;h<this.clusters[0].getCenter().length;h++){
				 //System.out.println("diff="+(newCenter[h]-clusters[i].getCenter()[h]));
					egal=egal&&(newCenter[h]-clusters[i].getCenter()[h])<(1e-3);
			 }
			 if (!egal){
				 clusters[i] .setCenter(newCenter); 
				 it=1;
			 }
		 }		 
//		 System.out.println("les new ones:");
//		 for (m=0;m<this.k;m++){
//			 System.out.println("classe:"+m+"\t"+clusters[m].getCenter()[0]+","+clusters[m].getCenter()[1]);
//		 }
		if(it==0) this.stop=true;
	 }

	/**algoritme kmean*/
	 public void clustering(){

		 /**initialiser les classes*/
		 initClusters();
		 /**faire une premi�re it�ration*/
		 iteration();

		 /**condition d'arret : aucune it�ration n'a �t� effectu�e*/

		 while (!stop){

			 //calculer les nouveau centres
			 calculateCenters();
			 //faire une it�ration
			 iteration();
			 this.affiche();
		 }
		 this.afficher();
//		 System.out.println(stop);
	 }

public void affiche(){

	System.out.println("nouvelle it�ration");
	 for(int i=0;i<this.k;i++){
			ArrayList <Record> r= getElements(this.clusters[i]);

			System.out.println("Classe "+this.clusters[i].getId()+"\t centre: ["+this.clusters[i].getCenter()[0]+","+
			this.clusters[i].getCenter()[1]+"]");	

			System.out.println("Elements: ");
			for (int j=0;j<r.size();j++){
				System.out.print("["+r.get(j).getData()[0]+","+r.get(j).getData()[1]+"]");
			}
			System.out.println();
	 }
	 System.out.println();
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
	
		
		for(int i=0;i<clusters.length;i++){
			zone.ajouterObjet(clusters[i]);
			
		}
	}


}