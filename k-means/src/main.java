import java.util.ArrayList;


public class main {

	public static void main(String[] args) {
		//Reader r=new Reader("ListeDesMoyennes.txt",2);
		Reader r=new Reader("exemple1.txt",1);

		ArrayList <Record>records=r.readData();
		
		Kmeans k= new Kmeans (records,10);
		k.initClusters();
//		for(int i=0;i<records.size();i++){
//			double tab[]= records.get(i).getData();
//			for(int j=0;j<tab.length;j++)
//				System.out.println(tab[j]);
//			System.out.println("\n");
//		}
		k.afficher();

	}

}
