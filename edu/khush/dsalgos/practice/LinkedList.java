package edu.khush.dsalgos.practice;

import java.util.Stack;




public class LinkedList {

	private Link first;
	private Link last;
	
	public static void main(String[] args){
		
		
		LinkedList l=new LinkedList();
		l.insertFirst(60);
		l.insertFirst(50);
		l.insertFirst(40);
		l.insertFirst(30);
		l.insertFirst(20);
		l.insertFirst(10);


		Link link=l.first;
		
		while(link!=null)
		{
			System.out.println(link.data);
			link=link.next;
		}
	
		LinkedList reversedL=rotateList(l,4);
		
		link=reversedL.first;
		
		while(link!=null)
		{
			System.out.println(link.data);
			link=link.next;
		}
		
		System.exit(0);
		
		LinkedList l2=new LinkedList();
		l2.insertFirst(11);
		l2.insertFirst(10);
		l2.insertFirst(9);
		l2.insertFirst(7);
		l2.insertFirst(5);
		l2.insertFirst(2);
		
		mergeSortedLists2(l, l2);
		
		//Link link=l.first;
		
		while(link!=null)
		{
			System.out.println(link.data);
			link=link.next;
		}
		
		//2->5->7->9->10->11

		System.exit(0);
		
		LinkedList l1=new LinkedList();
		l1.insertFirst(15);
		l1.insertFirst(19);
		
		
		
		
		//LinkedList l2=new LinkedList();
		l2.insertFirst(8);
		Link l22=l2.insertFirst(9);
		l22.child=l1.first;
		
		LinkedList l3=new LinkedList();
		l3.insertFirst(6);
		Link l32=l3.insertFirst(17);
		l32.child=l2.first;
		
		
		LinkedList l5=new LinkedList();
		l5.insertFirst(2);
		
		LinkedList l6=new LinkedList();
		l6.insertFirst(3);

		LinkedList l7=new LinkedList();
		Link l71=l7.insertFirst(16);
		l71.child=l6.first;
		
		LinkedList l4=new LinkedList();
		Link l41=l4.insertFirst(13);
		Link l42=l4.insertFirst(20);
		Link l43=l4.insertFirst(4);
		
		l41.child=l7.first;
		l42.child=l5.first;
	
		


		LinkedList l8=new LinkedList();
		l8.insertFirst(11);
		Link l82=l8.insertFirst(7);
		l82.child=l3.first;
		l8.insertFirst(12);
		l8.insertFirst(5);
		Link l8child1=l8.insertFirst(10);
		l8child1.child=l4.first;
		
		LinkedList l9=flattenList(l8);
		
		for (Link current=l9.first; current!=null;current=current.next)
		{
			System.out.println(current.data);
		}

		
	}
	
	
	public static  Link getCommonNode(LinkedList l,LinkedList r){
		
		int l1=0;
		Link current=l.first;
		
		while(current!=null)
		{
			l1++;
			current=current.next;
		}
		
		int l2=0;
		current=r.first;
		while(current!=null)
		{
			l2++;
			current=current.next;
		}
	
		int diff=l1>l2 ? l1-l2 : l2-l1;
		Link current1=l1>l2 ? l.first: r.first;
		Link current2=l1>l2 ? r.first: l.first;

		System.out.println(l1+","+l2+","+diff+","+current1.data);
		while(diff!=0){
			
			diff--;
			System.out.println(diff);
			current1=current1.next;
			
		}
		
		
		while (current1!=null){
			
			if(current1.equals(current2))
				return current1;
			else{
				current1=current1.next;
				current2=current2.next;

				
			}
		}
		
		
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public Link insertFirst(int key){
		
		if (first==null){
			Link firstLink=new Link(key);
			first=firstLink;
			last=firstLink;
			return firstLink;

		}
		else{
			
			Link newLink=new Link(key);
			newLink.next=first;
			first=newLink;
			return newLink;

		}
		
	}
	
	public Link insertFirst(Link newLink ){
		
		if (first==null){
			Link firstLink=newLink;
			first=firstLink;
			last=firstLink;
			return firstLink;

		}
		else{
			
			newLink.next=first;
			first=newLink;
			return newLink;

		}
		
	}
	
	public void insertLast(int key){
		
		Link lastLink=new Link(key);
		last.next=lastLink;
		last=lastLink;
		
	}
	
	public void insertLast(Link lastLink){
		
		last.next=lastLink;
		last=lastLink;
		
	}
	
	public Link deleteFirst(){
			
			Link temp=first;
			first=first.next;
			if(temp==last)
				last=null;
			return temp;
		
	}
	
	public boolean find(int key){
		
		Link current=first;
		
		while(current!=null){
			
			if (current.data==key)
				return true;
			current=current.next;
		}
		
		return false;
	}
	
	public Link reverseList(){
		Link prev=null;
		Link current=first;
		Link temp;
		
		while(current!=null){
			
			temp=current.next;
			current.next=prev;
			prev=current;
			current=temp;
			
		}
		
		return prev;
	}
	
	
	public static LinkedList mergeSortedLists1(LinkedList l,LinkedList f){
		
		Link ptr1=l.first;
		Link ptr2=f.first;
		LinkedList merged=new LinkedList();
		
		while (ptr1!=null && ptr2!=null){
			
			if (ptr1.data<ptr2.data){
				merged.insertFirst(ptr1.data);
				ptr1=ptr1.next;
			}
			else{
				merged.insertFirst(ptr2.data);
				ptr2=ptr2.next;
				
			}	
			
		}
		
		while (ptr1!=null){			
			merged.insertFirst(ptr1.data);
			ptr1=ptr1.next;		
		}
		
		while (ptr2!=null){			
			merged.insertFirst(ptr2.data);
			ptr2=ptr2.next;		
		}
		
		
		return merged;
	}
	
	public static  Link getCommonNode1(LinkedList l,LinkedList r){
		
		Link lp=l.first;
		int l1=0;
		
		while (lp!=null){
			l1++;
			lp=lp.next;
		}
		
		Link rp=r.first;
		int r1=0;
		
		while (rp!=null){
			r1++;
			rp=rp.next;
		}
		
		System.out.println(l1);
		System.out.println(r1);
		int diff=0;
		Link l_ptr=l.first;
		Link r_ptr=r.first;
		if (l1>r1){
			 diff=l1-r1;	
			 System.out.println(diff);
			 while (diff!=0)
			 {
				 l_ptr=l_ptr.next;
				 diff--;
			 }
			 //l_ptr=l_ptr.next;
		}
		
		
		if (l1<r1){
			 diff=r1-l1;
			 
			 while (diff!=0)
			 {
				 r_ptr=r_ptr.next;
				 diff--;
			 }
			 //r_ptr=r_ptr.next;
		}
		
		System.out.println(r_ptr.data);
		System.out.println(l_ptr.data);
			
		while (l_ptr!=null)
		{
			
			if(l_ptr.data==r_ptr.data)
				return l_ptr;
			else
			{
				l_ptr=l_ptr.next;
				r_ptr=r_ptr.next;
			}
			
		}
			
		return null;

	}
	
	
	public LinkedList removeDuplicates(LinkedList ll)
	{
		//1->2->3->4->2->6
		
		Link current=ll.first;	
		Link previous=current;
		
		while(current!=null)
		{	
			Link runner=ll.first;
			while (runner!=current)
			{
				if(runner.data==current.data)
				{
					Link temp=current.next;
					previous.next=temp;
					current=temp;
					break;					
					
				}
				
				runner=runner.next;
				
			}
			
			if(runner==current){
				previous=current;
				current=current.next;
			}
			
		}
		
		return ll;
	}
	
	
	public Link getNthToLast(int n)
	{
		
		Link ptr1=first;
		Link ptr2=first;
		
		int index=n;
		
		while(index!=0)
		{
			ptr1=ptr1.next;
			index--;
		}
		
		while(ptr1!=null)
		{
			ptr1=ptr1.next;
			ptr2=ptr2.next;
		}
		
		return ptr2;
		
	}
	
	public Link findNthToLast(LinkedList l,int n){
		
		Link p1=l.first;
		Link p2=l.first;
		
		for (int i=0;i<n-1;i++){
			
			p2=p2.next;
		}
		
		while(p2.next!=null){
			
			p1=p1.next;
			p2=p2.next;
		}
		
		return p1;
		
	}
	
	public LinkedList getSum(LinkedList l1, LinkedList l2)
	{
		
		Link digit1=l1.first;
		Link digit2=l2.first;
		int carry=0;
		int sum=0;
		LinkedList resultLL=new LinkedList();

		while(digit1!=null || digit2!=null || carry!=0)
		{
			if(digit1!=null){
				sum+=digit1.data;
				digit1=digit1.next;
			}
			if(digit2!=null){
				sum+=digit2.data;
				digit2=digit2.next;
			}
			sum+=carry;
			carry=sum/10;
			resultLL.insertFirst(sum%10);	
			sum=0;
			
		}
		
	
		return resultLL;
	}

	
	public LinkedList mergerSortedLists(LinkedList l1,LinkedList l2)
	{
		//1->3
		//2->4
		//1->2->3->4
		
		Link ptr1=l1.first;
		Link ptr2=l2.first;
		
		LinkedList res=new LinkedList();
		
		while(ptr1!=null && ptr2!=null)
		{
			if( ptr1.data<ptr2.data){
				res.insertFirst(ptr1.data);
				ptr1=ptr1.next;
			}
			else 
			{
				res.insertFirst(ptr2.data);
				ptr2=ptr2.next;
			}
			
			
		}
		
		while(ptr1!=null)
		{
			res.insertFirst(ptr1.data);
			ptr1=ptr1.next;	
		}
		
		while(ptr2!=null)
		{
			res.insertFirst(ptr2.data);
			ptr2=ptr2.next;	
		}
		
		
		
		return res;
	}
	
	public static LinkedList mergeSortedLists(LinkedList l,LinkedList f){
		
		Link prev=null;
		Link current=l.first;
		
		Link ptr=f.first;
		Link temp=null;
		while (current!=null){
			
			if (current.data<ptr.data)
			{
				System.out.println(current.data+","+ptr.data);
				prev=current;
				current=current.next;
				
			}
			else{
				System.out.println(current.data+","+ptr.data);
				temp=ptr.next;
				ptr.next=current;
				prev.next=ptr;
				ptr=temp;
			}
			
		}
		
		
		
		return l;
	
}
	
	
	public static LinkedList flattenList(LinkedList ll)
	{
		
		Link current=ll.first;
		
		while(current!=null)
		{
			if (current.child!=null)
			{
				Link temp=current.child;
				while(temp!=null)
				{
					ll.insertLast(temp);
					temp=temp.next;
				}		
				
			}
			current=current.next;
		}
		
		return ll;
	}
	
	public static LinkedList rotateList(LinkedList l,int k)
	{
		Link current=l.first;
		Link last=l.last;
		Link previous=null;
		int index=1;
		Link temp=null;
		
		while(index<=k)
			
		{
			
			temp=current.next;
			last.next=current;
			current.next=null;
			last=current;
			l.first=temp;
			current=temp;
			index--;
			
			
		}
		
		
		return l;
	}
	
	
	
	
	public LinkedList removeDups(LinkedList ll)
	{
		//1->2->3->2->6
		
		Link current=ll.first;
		Link previous=null;
		
		while(current!=null)
		{
			Link runner=ll.first;
			while(runner!=current)
			{
				
				if(runner.data==current.data)
				{
					Link temp=current.next;
					previous.next=temp;
					current=temp;
					break;
					
				}
				
				runner=runner.next;
				
			}
			
			if(runner==current)
			{
				previous=current;
				current=current.next;
			}
			
		}
		
		
		
		
		return ll;
	}
	
	public boolean deleteMiddleNode(Link l)
	{
		
		if(l==null || l.next==null)
			return false;
		
		Link lNext=l.next;
		l.data=lNext.data;
		l.next=lNext.next;
		
		lNext=null;
		return true;
		
		
	}
	
	
	public static LinkedList mergeSortedLists2(LinkedList l1,LinkedList l2){
		
		//1->3->4->6
		//2->5->7->9->10->11
		
		Link l1Ptr=l1.first;
		Link l2Ptr=l2.first;
		Link l1prev=null;
		Link temp=null;
		
		while (l1Ptr!=null && l2Ptr!=null)
		{

			if(l1Ptr.data>l2Ptr.data)
			{
				temp=l2Ptr;
				l2Ptr=l2Ptr.next;
				l1prev.next=temp;
				temp.next=l1Ptr;			
			}
			
			l1prev=l1Ptr;
			l1Ptr=l1Ptr.next;
			
		}
		
		while(l2Ptr!=null)
		{
			temp=l2Ptr;
			l2Ptr=l2Ptr.next;
			l1prev.next=temp;
			temp.next=null;	
			l1prev=temp;
		}
		
		return l1;
	
	
	}
	
	public static LinkedList reverseList2(LinkedList l){

		//1->2->3->4->null
		Link current=l.first;
		Link previous=null;
		Link temp=null;
		
		while(current!=null)
		{
			
			temp=current.next;
			current.next=previous;
			previous=current;
			current=temp;			
			
		}
		
		l.first=previous;
		return l;
	
	
	}
	
	public Link checkForOverlap(LinkedList l1,LinkedList l2)
	{
		
		
		int len1=0;
		Link l1Ptr=l1.first;
		
		while (l1Ptr!=null)
		{
			len1++;
			l1Ptr=l1Ptr.next;
			
		}
		
		int len2=0;
		Link l2Ptr=l2.first;
		
		while (l2Ptr!=null)
		{
			len2++;
			l2Ptr=l2Ptr.next;
			
		}
		
		l1Ptr=l1.first;
		l2Ptr=l2.first;
		
		if(len1>len2)
		{
			int d=len1-len2;
			while(d!=0)
				
			{
				d--;
				l1Ptr=l1Ptr.next;
			}
			
		}
		
		else if (len1<len2)
		{
			int d=len2-len1;
			while(d!=0)
				
			{
				d--;
				l2Ptr=l2Ptr.next;
			}
			
			
		}
		
		while(l2Ptr!=null)
		{
			if(l1Ptr.data==l2Ptr.data)
				return l1Ptr;
			
			l1Ptr=l1Ptr.next;
			l2Ptr=l2Ptr.next;
			
		}
		
		return null;
		
	}
	
	
	public static LinkedList revAndAppend(LinkedList l)
	{
		
		LinkedList even=new LinkedList();
		boolean isEven=false;
		
		Link current=l.first;
		Link previous=null;
		// 1 2 3 4 5 6
		while (current!=null)
		{
			if(!isEven)
			{
				isEven=true;
				previous=current;
				current=current.next;
			}
			else
			{
				isEven=false;
				even.insertFirst(current.data);
				previous.next=current.next;
				current=current.next;
				
			}
		}
		
		previous.next=even.first;
		
		return l;
	}
	
	
	public void sortListOf012(LinkedList l)
	{
		
		Link current=l.first;
		int countOne=0;
		int countTwo=0;
		int countZero=0;
		
		
		while(current!=null)
		{
			
			if(current.data==0)
				countZero++;
			else if (current.data==1)
				countOne++;
			else
				countTwo++;		
		}
		
		current=l.first;
		while(countZero!=0)
		{
			current.data=0;
			countZero--;			
		}
		
		while(countOne!=0)
		{
			current.data=1;
			countOne--;			
		}
		
		while(countTwo!=0)
		{
			current.data=2;
			countTwo--;			
		}
		
		
	}
	
	public LinkedList swapKthElements(LinkedList l,int k)
	{
		
		Link ptr1=l.first;
		Link ptr2=l.first;
		
		Link kFront=null;
		
		int i=k;
		while(i!=0)
		{
			ptr2=ptr2.next;
			i--;
			
		}
		kFront=ptr2;
		
		while(ptr2!=null)
		{
			ptr1=ptr1.next;
			ptr2=ptr2.next;
		}
		
		Link kBack=ptr1;
		
		int temp=kFront.data;
		kFront.data=kBack.data;
		kBack.data=temp;
		
		return l;
		
	}
	
	
}
