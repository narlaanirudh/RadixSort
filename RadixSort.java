import java.util.*;

public class RadixSort
{
	public static Scanner sc = new Scanner(System.in);
	public static void main(String []args)
	{
		int radix,n,i=1;
		char ch,c = 'n';
		System.out.print("Enter Radix between 2..36 :\t");
                do
                {
                    c = 'n';
                    radix = sc.nextInt();
                    if(radix<2 || radix>36)
                    {
                        c = 'y';
                        System.out.print("Invalid Input. Enter again :\t");
                    }
                }while(c == 'y');
                List num = new List();
		//enters the elements in the list
		do
		{
			System.out.print("Enter number :\t");
			n = sc.nextInt();
			num.insert(n);
			i++;
			System.out.print("Do you want to enter another number(y/n) :\t");
			ch = sc.next().charAt(0);
		}while(ch == 'y');
		int d = num.maxDigit(radix);
		num.printList();
		List sorted = radixSort(num,radix,d);
                System.out.println("The numbers in radix "+radix+" in descending order :");
                sorted.printList1(radix);
                System.out.println("The numbers in radix 10 :");
		sorted.printList();
	}
	
	//sorting the list using radix sort
	public static List radixSort(List L, int radix, int numFields)
	{
		List[] buckets = new List[radix];
		List newL;
		newL = L;
		char ch,c;
		for ( int i = 0; i < numFields; i++)//numFields is the maximum number of digits of the elements in the list
		{
				for(int j = 0; j < radix; j++)
					buckets[j]=new List();

				distribute(newL, buckets, radix, i);
				System.out.print("Do you want to view the bucket after "+(i+1)+"th digit :\t");
				ch = sc.next().charAt(0);
				if(ch == 'y')
				{
					System.out.println("1.Base "+radix);
					System.out.println("2.Base 10");
                                        System.out.print("Enter the desired Format(1/2) :\t");
					c = sc.next().charAt(0);
					switch(c)
					{
						case '1'://displays the elements of the buckets in base - radix 
							for(int j=0;j<radix;j++)
							{
								if(j<=9)
									System.out.println("Bucket:"+j);
								else
									System.out.println("Bucket:"+(char)(j-10+65));
								buckets[j].printList1(radix);
							}
							break;
						case '2'://displays the elements of the buckets in base - 10 
							for(int j=0;j<radix;j++)
							{
								System.out.println("Bucket:"+j);
								buckets[j].printList();
							}
							break;
						default:System.out.println("Invalid input");
					}
				}
				newL = combine(buckets, radix);
		}
		return newL;
	}
	
	//distribustes the elements of the list in its respective buckets according to the i-th digit
	public static void distribute(List L, List[] buckets, int radix, int i)
	{
		int x;
		int []index = new int[radix];
		ListNode cur = L.getHead();
		while (cur!=null)
		{

			x = cur.getItem();
			int b = right_dig(x,i,radix);
			index[b]++;
			buckets[b].insert(x);
			cur = cur.getNext();
		}
	}

	//finds the i-th digit from the right
	public static int right_dig(int no, int i, int r)
	{
		int t = 0;
		for(int j=0;j<=i;j++)
		{
			t = no%r;
			no/=r;
		}
		return t;
	}

	//combies the elements from the buckets and puts it in a list
	public static List combine(List [ ] buckets, int radix)
	{
		int b;
		List L, remBucket;
		L = new List();

		ListNode cur;
		
		
		for (b = radix - 1; b >= 0; b--)
		{
			remBucket = buckets[b];
			cur = remBucket.getHead();
			if(L.isEmpty()&&cur!=null)
			{
			L.head = cur;
			L.tail = remBucket.tail;
			L.numItems++;
			}
			else if (cur!=null)
			{

				L.tail.setNext(remBucket.head);
				L.tail = remBucket.tail;
				L.numItems+=remBucket.numItems;

			}
		}
		return L;
	}
}