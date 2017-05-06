
package edu.sdsu.cs.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    List<Game> contents;

    /**
     * Uses the filename user gave to load all its contents
     * @param filename
     * @throws IOException
     */
    public CSVReader(String filename) throws IOException {
        contents = loadCSV(filename);
    }

    /**
     * Return the contents from the list made by reading the .csv file the user gave.
     * @return the contents from the list made by reading the .csv file.
     */
    public List<Game> getList() {
        return contents;
    }

    /**
     *
     * @param filename
     * @return dictionary of inputs classified at
     * @throws IOException
     */
    public List<Game> loadCSV(String filename) throws IOException {
        String line;
        List<Game> dictionary = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            line = br.readLine();

            while((line = br.readLine()) != null) {
                String values[] = line.split(",");
                
                /**
                 * Finds the year and changes the string to an int
                 */
                int year = 0;
                if(values.length != 0) {

                    try {
                        year = Integer.parseInt(values[3]);
                    }
                    catch(NumberFormatException e) {
                        year = 0;
                    }
                }
                
                /**
                 * Finds the sales and changes the string to a double
                 * Sales are in millions
                 */
                double sales = 0;
                if(values.length != 0) {

                   try {
                       sales = Double.parseDouble(values[10]);
                   }
                   catch(NumberFormatException e) {
                       sales = 0;
                   }
                

                }   
					/**
                     * Creates new Games
                     * values[1] is the game name (String)
                     * values[2] is the platform (String)
                     * values[4] is the genre (String)
                     */
                    Game input = new Game(year,values[1],values[2],values[4],sales);
                    dictionary.add(input);
            	

                

            }
        }

        catch(IOException ioe) {
            ioe.printStackTrace();
        }

        return dictionary;
    }


    public class Game {
        public int year;
        public String game;
        public String platform;
        public String genre;
        public double sales;

       

		/**
         * Default constructor
         */
        public Game(int year, String game, String platform, String genre, double sales) {
            this.year = year;
            {if (game.length() > 10) game = game.substring(0, 10) + "...";} //shortens name up to 10 letters
            this.game = game;
            this.platform = platform;
            this.genre = genre;
            this.sales = sales;
        }

        /**
         * 
         * @return 
         */
        @Override
        public String toString() {
        	return year+" "+game+" "+platform+" "+genre+" "+sales;
        }
    }
}

