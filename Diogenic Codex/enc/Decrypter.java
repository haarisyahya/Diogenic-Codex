package enc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


/** This class decrypts the encrypted message.
  *
  * @author Haaris Yahya
  * @version 1.0 (06/05/2021)    
  */
public class Decrypter {
 
 // the file names
 private static final String INPUT_FILE = "encrypted.txt";
 private static final String OUTPUT_FILE = "recovered.txt";
 
 private static int getCodeIndex(String code, String codes[]) {
  for( int i=0; i<codes.length; i++ ) {
   if( codes[i].equals(code))
    return i;
  }
  return -1;
 }
 
 // the method to get the character and the codes
 static void process(String inputFileName, String outputFileName) {
  
  // count the number of characters
  try {
   char characters[] = null;
   String codes[] = null;
   int numCharacters = 0;
   
   // Initializes the scanner
   Scanner scanner = new Scanner(new File(inputFileName));
   PrintWriter printWriter = new PrintWriter(new File(outputFileName));
   
   while( scanner.hasNextLine() ) {
    String line = scanner.nextLine();
    if( line.equals("---"))
     break;
    numCharacters++;
   }
   scanner.close();
   
   characters = new char[numCharacters];
   codes = new String[numCharacters];
   
   // reopen the file
   scanner = new Scanner(new File(inputFileName));
   for( int i=0; i<numCharacters; i++ ) {
    String line = scanner.nextLine();
    
    char c = line.charAt(0);
    String code = line.substring(line.indexOf('\t') + 1);
    
    
    codes[i] = code;
    characters[i] = c;
   }   
   
   // skip lines
   scanner.nextLine();
   
   // decrypt
   while( scanner.hasNext() ) {
    String code = scanner.next();
    int codeIndex = getCodeIndex(code, codes);
    printWriter.print(characters[codeIndex]);
   }
   
   scanner.close();
   printWriter.close();
  }
  catch(FileNotFoundException fnfe) {
   System.out.println("Cannot open input file " + inputFileName);
   System.exit(3);
  }
 }
 // the main method
 public static void main(String args[]) {
  
  // the file names
  String inputFileName = "";
  String outputFileName = "";
  
  if( args.length == 0 ) {
   inputFileName = INPUT_FILE;
   outputFileName = OUTPUT_FILE;
  }
  else if( args.length == 1 ) {
   inputFileName = args[0];
   outputFileName = OUTPUT_FILE;
  }
  else {
   inputFileName = args[0];
   outputFileName = args[1];
  }
  
  process(inputFileName, outputFileName);
 }
}
