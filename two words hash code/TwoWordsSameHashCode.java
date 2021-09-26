import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.HashMap;

/**
   Searches for words with the same hash code
   based on the filename.
*/
public class TwoWordsSameHashCode
{
   
    /**
      Makes a hash code to string map based on the words in the specified file
      @param filename the filename to read words from
      @return a hash map mapping hash values to words found in the filename
   */
   public static Map< Integer, HashSet<String> > generateHashMap(String filename)
   { 
      Map< Integer, HashSet<String> > strings = new HashMap< Integer, HashSet<String> >();
      try (Scanner in = new Scanner(new File(filename))){
         while (in.hasNext())
         {
            String word = in.next();
            
            Integer hash = word.hashCode();
            
            if (strings.containsKey(hash) == true)
               strings.get(hash).add(word); 
               
            if (strings.containsKey(hash) == false)
            {
               strings.put(hash, new HashSet<String>());
               strings.get(hash).add(word); 
            }
         }

      
        
        
        
      }
      
      catch (FileNotFoundException e){
         System.out.println("Cannot open: " + filename);
      }
      
      return strings;
   }


   

   /**
      Prints all the words with the same hash codes
      @param hashCodes the map to print from
   */
   public static void printSameCodes(Map<Integer, HashSet<String>> hashCodes)
   {
       Map strings = hashCodes;
       
       for (Object key : strings.keySet()) 
            if (strings.get(key).size() > 1) 
            System.out.println(key + ": " + strings.get(key));

   }
}
