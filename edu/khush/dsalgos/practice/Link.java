package edu.khush.dsalgos.practice;

public class Link {
	
	public int data;
	public Link next;
	public Link previous;
	public Link child;
	
	
	public Link(int data){
		this.data=data;
	}
	
	public Link(int data,Link next){
		this.data=data;
		this.next=next;
	}
	
	@Override
	public boolean equals(Object o){
		
		if (this.data==((Link)o).data)
				return true;
		
		return false;
	}

}
