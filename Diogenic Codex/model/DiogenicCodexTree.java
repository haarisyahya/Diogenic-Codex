package model;

/** This class stores and generates the Diogenic Codex Tree. 
  *
  * @author Haaris Yahya
  * @version 1.0 (06/08/2021)                                                        */

public class DiogenicCodexTree {
 
 private TreeNode root;
 private FrequencyTable frequencyTable;
 
 // the codes
 private String codes[];
 
 public DiogenicCodexTree(FrequencyTable frequencyTable) {
  this.frequencyTable = frequencyTable;
  createTree();
  generateCodes();
 }
 
 private void createTree() {
  // create a priority queue of nodes
  PriorityQueue priorityQueue = new PriorityQueue(frequencyTable);
  
  // generate the DiogenicCodexTree
  while( priorityQueue.getSize() > 1 ) {
   TreeNode left = priorityQueue.getMin();
   TreeNode right = priorityQueue.getMin();
   
   TreeNode newNode = new TreeNode('$', left.getFrequency() + right.getFrequency());
   newNode.setLeft(left);
   newNode.setRight(right);
   
   priorityQueue.add(newNode);
  }
  
  root = priorityQueue.getMin();
 }
 // method to generate the codes
 private void generateCodes() {
  codes = new String[frequencyTable.getNumCharacters()];
  for( int i=0; i<frequencyTable.getNumCharacters(); i++ ) {
   generateCodes(root, "");
  }
 }
 // makes the tree and traverses it
 private void generateCodes(TreeNode node, String code) {
  
  if( node.getLeft() != null ) {
   generateCodes(node.getLeft(), code + "0");
  }
  
  if( node.getRight() != null ) {
   generateCodes(node.getRight(), code + "1");
  }
  
  if( node.isLeafNode() ) {
   codes[ frequencyTable.getCharIndex( node.getCharacter() ) ] = code;
  }
 }
 //returns the value at a node
 public String getCode(char c) {
  if( frequencyTable.getCharIndex(c) == -1 )
   return "";
  return codes[ frequencyTable.getCharIndex(c) ];
 }
}

