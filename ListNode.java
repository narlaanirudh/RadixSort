public class ListNode
{
	private int     item;
	private ListNode    next;
	public ListNode(int o)
	{
		item = o;
		next = null;
	}
	public ListNode(int o, ListNode newNext)
	{
		item = o;
		next = newNext;
	}
	public int getItem()
	{
		return item;
	}
	public ListNode getNext()
	{
		return next;
	}
	public void setR(int o)
	{
		item = o;
	}
	public void setNext(ListNode newNext)
	{
		next = newNext;
	}
}