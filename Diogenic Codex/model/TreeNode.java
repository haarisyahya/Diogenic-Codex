package model;

/** This class stores the nodes for the trees
  *
  * @author Haaris Yahya
  * @version 1.0 (06/08/2021)                                                        */

public class TreeNode implements Comparable<TreeNode> {
 
 // the character and the frequency
 private int frequency;
 private char character;
 
 // the left and the right children
 private TreeNode left;
 private TreeNode right;
 
 // The constructor that will allow the data to be stored and has the link to the next node
 public TreeNode(char character, int frequency) {
  this.character = character;
  this.frequency = frequency;
  
  left = null;
  right = null;
 }
 
// The below methods are getters and setters that access and update the value of the variables 
 public TreeNode getLeft() {
  return left;
 }

 public void setLeft(TreeNode left) {
  this.left = left;
 }

 public TreeNode getRight() {
  return right;
 }

 public void setRight(TreeNode right) {
  this.right = right;
 }

 public int getFrequency() {
  return frequency;
 }

 public char getCharacter() {
  return character;
 }
 // Boolean method that determines whether a node is a leaf
 public boolean isLeafNode() {
  return left == null && right == null;
 }
 
 // Method to compare tree nodes
 @Override
 public int compareTo(TreeNode o) {
  if( this.frequency == o.frequency )
   return this.character - o.character;
  return this.frequency - o.frequency;
 }
}
