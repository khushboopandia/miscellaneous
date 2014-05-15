package edu.khush.dsalgos.practice;

public class Node {
	
	
	int prefixCount;
	int wordCount;
	Node[] edges;
	
	public Node()
	{
		this.prefixCount=0;
		this.wordCount=0;
		this.edges=new Node[26];
	}
	

}
