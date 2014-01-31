

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Lire les données à partir du fichier
 *	
 * @author Olfa
 *
 */

public class Reader {
	
	 /** nom du fichier */
    private String fileName;
    
    /**ligne début de lecture dans le fichier*/
    int Nligne;
    
    /** separateur */
    private final String separator = "\t";
   
    /**Matrice des données*/

    public Reader(String fileName,int Nligne) {
        this.fileName = fileName;
        this.Nligne=Nligne;
    }


    public ArrayList <Record> readData(){
    	
    	ArrayList<Record> records = new ArrayList<Record>();
    
    	try{
    		File file = new File(fileName);
    		FileReader FR=new FileReader(file);
    		BufferedReader BR = new BufferedReader(FR);   
    		
    		try {	
    			String line=BR.readLine();
            	int i=1;
            	/**passer les lignes qui ne contiennet pas des données*/
            	while (i<this.Nligne){
            		line = BR.readLine();
            		i++;
            	}
                  
                while (line != null) {
                	extractData(records,line);
                    line = BR.readLine();
                	
                	}
                BR.close();
                FR.close();
            }  catch (IOException exception)
            {
                System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
            }
        }
        catch (FileNotFoundException exception)
        {
            System.out.println ("Le fichier n'a pas été trouvé");
        }
        
    return records;
    }
    
	/**
	 * 
	 */
    private void extractData(ArrayList<Record>records,String line){
    
    	/**extraires les différents champs d'une ligne*/
    	String[] strRecord=line.split(separator);
    	double[] record=new double[strRecord.length];
    	for (int i=0;i<strRecord.length;i++){
    		record[i]=Double.parseDouble(strRecord[i]);
    	}
    	
    	try {
	    	 	Record r;
				r = new Record(record);
				records.add(r);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	   	
    }
    
    
}
