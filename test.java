package edu.sdsu.cs;

import edu.sdsu.cs.util.CSVReader;
import edu.sdsu.cs.util.CSVReader.Game;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class test {

	
	public test(String inFile, String outFile) {
	     try {
	    	 	
			PrintWriter writer = new PrintWriter(outFile, "UTF-8");
			List<Game> results = LoadIncidentFromCSV(inFile);
			
			writer.println("Top 5 and Low 5 Based on Global Sales");
                writer.println((results.get(i)).toString());
            }
            writer.println("...");
            for(int i = results.size()-5; i<results.size(); i++) {
                writer.println(results.get(i).toString());
            }
            writer.close();	
            
            
		}
		
		catch (IOException e) {
            System.out.println("Could not write to file.");
        }
	}
	 
	private static List<Game> LoadIncidentFromCSV(String filename) throws IOException {
        CSVReader csv = new CSVReader(filename);
        return csv.getList();
    }
	
	public static void main(String[] args) {
		if(args.length != 2){
			System.out.printf("You entered: %s argument(s)\n", args.length );
            System.out.printf("Correct Usage: [INFile] [OUTFile]\n");
        }
        else {
            new test(args[0], args[1]);
        }

        System.out.println("Complete!");

	}

}
