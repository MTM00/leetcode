import java.util.Comparator;
import java.util.PriorityQueue;

public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode backup;
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(
				new Comparator<ListNode> (){
					@Override
					public int compare(ListNode o1, ListNode o2) {
						if(o1.val > o2.val)
							return 1;
						else if(o1.val == o2.val)
							return 0;
						else return -1;
					}
					
				});
		for(ListNode ln : lists) {	
			 if(ln != null) {
				 ListNode temp = ln;
		         do {
				     pq.add(temp);
			     } while((temp = temp.next) != null);
			 }
		}
		
		backup = pq.peek();
		ListNode node = backup;
		if(backup != null) {
			pq.remove();
			while(!pq.isEmpty()) {
				node.next = pq.peek();
				pq.remove();
				node = node.next;
			}
			node.next = null;
		}	
		return backup;
    }
	
	
	public static void main(String[] aegs) {
		ListNode temp;
		Solution s = new Solution();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(-2);
		ListNode l3 = new ListNode(-1);
		ListNode l4 = new ListNode(-1);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = null;
		

		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(6);

		l5.next = l6;
		l6.next = null;
		
		ListNode l7 = null;
		ListNode[] lists = {l1,l5,l7};
		ListNode ln = s.mergeKLists(lists);
		temp = ln;
		while(temp != null) {
			System.out.println(temp.val);
			
			temp = temp.next;
		}
		
	}
}
