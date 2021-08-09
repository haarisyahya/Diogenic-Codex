package model;

import java.util.ArrayList;
import java.util.Collections;

/** This class creates a priority queue for the nodes using ArrayLists.
  *
  * @author Haaris Yahya
  * @version 1.0 (06/08/2021)                                                        */

public class PriorityQueue {

 // the list of the nodes
 private ArrayList<TreeNode> nodes;
  
 public PriorityQueue(FrequencyTable frequencyTable) { 
  
  nodes = new ArrayList<>();
  for( int i=0; i<frequencyTable.getNumCharacters(); i++ ) {
   char c = frequencyTable.getCharacter(i);
   int frequency = frequencyTable.getFrequency(c);
   nodes.add(new TreeNode(c, frequency));
  }
 }
 
 public boolean hasNext() {
  return nodes.size() > 0;
 }
 // gets the size of the nodes
 public int getSize() {
  return nodes.size();
 }
 // get the min nodes
 public TreeNode getMin() {
  return nodes.remove(0);
 }
 //method to add a new node
 public void add(TreeNode newNode) {
  nodes.add(newNode);
  // make sure the minimum is at the index 0
  Collections.sort(nodes);
 }
}

