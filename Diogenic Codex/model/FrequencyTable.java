package model;

/** This class stores the frequency table.
  *
  * @author Haaris Yahya
  * @version 1.0 (06/08/2021)                                                        */

public class FrequencyTable {
 
 // the maximum number of characters
 private static final int MAX_NUM_CHARS = 256;

 // the list of the characters
 private char characters[];
 
 // the list of the frequencies
 private int frequencies[];
 
 // the number of characters
 private int numCharacters;
 
 // the text 
 private String text;
 
 // the constructor
 public FrequencyTable(String text) {
  this.text = text;
  
  characters = new char[MAX_NUM_CHARS];
  frequencies = new int[MAX_NUM_CHARS];
  numCharacters = 0;
  
  createTable();
 }
 // Method to generate the table
 private void createTable() {
  for( int i=0; i<text.length(); i++ )
   addChar( text.charAt(i) );
 }
 // Method to add the characters in the table
 private void addChar(char c) { 
  int charIndex = getCharIndex(c);
  if( charIndex == -1 ) {
   characters[numCharacters] = c;
   frequencies[numCharacters] = 1;
   numCharacters++;
  }
  else {
   frequencies[charIndex]++;
  }
 }
 // Method to get the index of the characters
 public int getCharIndex(char c) {
  for( int i=0; i<numCharacters; i++ ) {
   if( c == characters[i] )
    return i;
  }
  return -1;
 }
 //Method to get the frequency of occurence of the characters
 public int getFrequency(char c) {
  int index = getCharIndex(c);
  if( index == -1 )
   return -1;
  return frequencies[index];
 }
 // Method to fetch the characters
 public char getCharacter(int i) {
  if( i<0 || i>=numCharacters )
   return 0;
  return characters[i];
 }
// Method to get the number of characters
 public int getNumCharacters() {
  return numCharacters;
 }
 
}
