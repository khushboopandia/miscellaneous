package edu.khush.dsalgos.practice;

public class TreeNode {
	
	private TreeNode left; 
	private TreeNode right;
	private int value;
	
	public TreeNode( TreeNode left, TreeNode right, int value )
	{
	this.left = left;
	this.right = right;
	this.value = value;
	}
	public TreeNode getLeft() { 
		return left; 
	} 
	
	public TreeNode getRight() {
		return right;
	} 
	
	public int getValue() {
		return value; 
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	

}
