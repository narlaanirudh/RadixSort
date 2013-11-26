import java.io.*;
import java.util.*;
 public class List 
   {
      public ListNode	head;
      public ListNode	tail;
      protected int		numItems;
       public List() 
      {	
         head = null;
         numItems = 0;
      }
       public boolean isEmpty() 
      {
         return (numItems == 0) ? true : false;
      }
       public int size() 
      {
         return numItems;
      }
		
		 public ListNode getHead() 
      {
         return head;
      }
      
       public int getItem(int index) 
      {
         if (index > numItems) 
            return 0;
         return find(index).getItem();
      }
      
       protected ListNode find(int index) 
      {
         ListNode	cur = head;
         if (index > numItems) 
            return null;
         for (int count=1; count<index; count++) 
            cur = cur.getNext();
         return cur;
      }
       public boolean insert( int newItem) 
      {
         
                  
         if(numItems==0)
         {
        	 head = new ListNode(newItem);
        	 tail=head;
        	 numItems++;
        	 return true;
         }
         else
         {
         tail.setNext(new ListNode(newItem));
         tail=tail.getNext();
         }
         
                  
         numItems++;
         
         return true;
         
      }
       public void remove(int from) 
      {
         ListNode	pre, cur;
         numItems--;
         if (from == 1) 
         {
            if (numItems == 0) 
               head = null;
            else 
               head = head.getNext();
         }
         else
         {
            pre = find(from-1);
            cur = pre.getNext();
            pre.setNext(cur.getNext());
         }
      }
       public void printList() 
      {
         ListNode	cur = head;
         while (cur != null) 
         {
          	System.out.print(cur.getItem()+" ");
            cur = cur.getNext();
         }
         System.out.println();
      }
		
		 public void printList1(int radix) 
      {
         ListNode	cur = head;
         String temp;
         while (cur != null) 
         {
				temp=convert(cur.getItem(),radix);
          	System.out.print(temp+" ");
            cur = cur.getNext();
         }
         System.out.println();
      }
		public String convert(int n,int r)
		{
			String s="";
			int t;
			while(n!=0)
			{
				t=n%r;
				if(t<=9)
					s+=t;
				else
					s+=(char)((t-10)+65);
				n=n/r;
			}
			String a=rev(s);
			return a;
		}
		public String rev(String s)
		{
			String t="";
			for(int i=(s.length()-1);i>=0;i--)
				t+=s.charAt(i);
			return t;
		}
    public int maxDigit(int radix)
	{ 
		ListNode	cur = head;
         int max=0;
			int d;
         while (cur != null) 
         {
          	d=noDigit(cur.getItem(),radix);
				if(d>max)
					max=d;
            cur = cur.getNext();
         }
		return max;
	}
 	public int noDigit(int n,int radix)
	{
		int dig=0;
		while(n!=0)
		{
			dig++;
			n/=radix;
		}
		return dig;
	}
}
	