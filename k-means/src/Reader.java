

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**lire les données à partir du fichier*/
public class Reader {
	
	 /** nom du fichier */
    private String fileName;
   
    /** separateur */
    private final String separator = "\t";
   
    /** index des attributs à utiliser */
    private int[] usedAttributes;
    
    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public void setAttributesUsed(int[] usedAttributes) {
        this.usedAttributes = usedAttributes;
    }

    

    public ArrayList <Record> readData(){
    	
    	ArrayList<Record> records = new ArrayList<Record>();
    
    	try{
    		File file = new File(fileName);
    		FileReader FR=new FileReader(file);
    		BufferedReader BR = new BufferedReader(FR);   
     	
    		try {	
            	
                String line = BR.readLine();
                while (line != null) {
                   
                	System.out.println(line);
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
	
}
