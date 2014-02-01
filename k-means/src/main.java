import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		//Reader r=new Reader("ListeDesMoyennes.txt",2);
		Reader r=new Reader("exemple2.txt",1);

		ArrayList <Record>records=r.readData();

		Kmeans k= new Kmeans (records,5);
		k.clustering();
		k.afficher();

//		for(int i=0;i<records.size();i++){
//			double tab[]= records.get(i).getData();
//			for(int j=0;j<tab.length;j++)
//				System.out.println(tab[j]);
//			System.out.println("\n");
//		}

	}

}
