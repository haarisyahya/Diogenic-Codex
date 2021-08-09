package enc;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import model.DiogenicCodexTree;
import model.FrequencyTable;

/** This class encrypts the message in the testing file.
  *
  * @author Haaris Yahya
  * @version 1.0 (06/08/2021)                                                        */

public class Encrypter {
 
 // the file names
 private static final String INPUT_FILE = "testing.txt";
 private static final String OUTPUT_FILE = "encrypted.txt";
 
 private static FrequencyTable createFrequencyTable(String inputFileName) {
  // get the text
  String text = "";
  try {
   Scanner scanner = new Scanner(new File(inputFileName));
   text = scanner.nextLine();
   scanner.close();
  }
  catch(FileNotFoundException fnfe) {
   System.out.println("Cannot open input file " + inputFileName);
   System.exit(1);
  }
  
  // create the frequency table
  FrequencyTable frequencyTable = new FrequencyTable(text);
  return frequencyTable;
 }
 
 private static void createOutputFile(String outputFileName, String inputFileName, 
   FrequencyTable frequencyTable, DiogenicCodexTree diogenicCodexTree) {
  
  // get the text
  // initialize the scanner
  try {
   PrintWriter printWriter = new PrintWriter(new File(outputFileName));
   Scanner scanner = new Scanner(new File(inputFileName));
   
   for( int i=0; i<frequencyTable.getNumCharacters(); i++ ) {
    char c = frequencyTable.getCharacter(i);
    printWriter.print(c + "\t");
    printWriter.println(diogenicCodexTree.getCode(c));
   }
   printWriter.println("---");
   
   String text = scanner.nextLine();
   
   for( int i=0; i<text.length(); i++ ) {
    char c = text.charAt(i);
    printWriter.print(diogenicCodexTree.getCode(c) + "\t");
   }
   
   printWriter.close();
   scanner.close();
  }
  catch(FileNotFoundException fnfe) {
   System.out.println("Cannot open output file " + outputFileName);
   System.exit(2);
  }
 }
 // main method
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
  
  // read the file into the table
  FrequencyTable frequencyTable = createFrequencyTable(inputFileName);
  
  // create the tree
  DiogenicCodexTree diogenicCodexTree = new DiogenicCodexTree(frequencyTable);
  
  // create output file
  createOutputFile(outputFileName, inputFileName, frequencyTable, diogenicCodexTree);
 }
}