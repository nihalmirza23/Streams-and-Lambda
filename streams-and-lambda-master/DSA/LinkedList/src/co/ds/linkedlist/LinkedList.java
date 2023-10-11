package co.ds.linkedlist;


class Node{
	int value;
	Node next;
	
	public Node(int value) {
		this.value = value;
	}
}


public class LinkedList {
	
	/*
	 * Made this public only to avoid to create the getters for this
	 */
	public Node head;
	public Node tail;
	public int length;
	
	public LinkedList() {
		
	}

	public LinkedList(int value) {
		Node node = new Node(value);
		head = node;
		tail = node;
		length++;
	}
	
	// Print the LinkedList
	public void printList() {
		if(length==0) {
			System.out.println("List is empty");
			return;
		}
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.value + "  ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	// Append the value at the last
	public void append(int value) {
		Node node = new Node(value);
		if(head == null) {
			head = node;
			tail = node;
		}else {
			// adding the new node to the last node
			tail.next = node;
			// making the new node as a last node
			tail = node;
		}
		length++;
	}
	
	/*
	 * remove last element
	 */
	public Node removeLast() {
		if(length==0) return null;
		// Creating two nodes that will help to iterate to the list 
		// temp will check for that last element
		Node temp = head;
		// pre will be the previous node of that last node
		Node pre = head;
		// This is checking for the last node and assigning the previous node to the pre
		// and checking for next node
		while(temp.next!=null) {
			pre = temp;
			temp = temp.next;
		}
		// assigning the previous last node to the tail and making next as null so
		// last element will be removed
		tail = pre;
		tail.next=null;
		length--;
		// This condition is for if only one element is present in the list
		// Then the tail will redirect to the same element 
		// so we need to have this condition for that only
		if(length ==0 ) {
			head = null;
			tail=null;
		}
		return  temp;
	}
	
	public void prepend(int value) {
		Node node = new Node(value);
		if(length==0) {
			head=node;
			tail=node;
		}else {
			node.next= head;
			head = node;
		}
		length++;
	}
	
	
	public Node removeFirst() {
		if(length ==0 ) return null;
		Node temp = head;
		head = head.next;
		temp.next=null;
		length--;
		if(length ==0) {
			tail =null;
		}
		return temp;
	}
	
	public Node get(int index) {
		if(index<0 || index >length) {
			return null;
		}
		Node temp = head;
		for(int i=0;i<index;i++) {
			temp= temp.next;
		}
		return temp;
	}
	
	
	public boolean set(int index,int value) {
		Node temp = get(index);
		if(temp!=null) {
			temp.value=value;
			return true;
		}
		return false;
	}
	
	public boolean insert(int index,int value) {
		if(index<0 || index>length) {
			return false;
		}
		if(index ==0) {
			prepend(value);
			return true;
		}
		
		if(index ==length) {
			append(value);
			return true;
		}
		Node newNode = new Node(value);
		Node temp = get(index-1);
		newNode.next = temp.next;
		temp.next= newNode;
		length++;
		return true;
	}
	
	public boolean remove(int index) {
		if(index<0 || index>length-1) {
			return false;
		}
		if(index==0) {
			removeFirst();
			return true;
			
		}
		if(index==length-1) {
			removeLast();
			return true;
		}
		Node pre = get(index-1);
		Node temp = pre.next;
		pre.next = temp.next;
		temp.next = null;
		length--;
		return true;
	}
	
	public void reverse() {
		Node temp = head;
		head = tail;
		tail = head;
		// to reverse the linked list we need three variable
		// before , temp , after
		Node after = temp.next;
		Node before = null;
		for(int i=0;i<length;i++) {
			after = temp.next;
			temp.next= before;
			before = temp;
			temp = after;
		}
	}
	
	
	
	
	// printing all the attributes
	public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List values:");
        if (length == 0) {
            System.out.println("list is empty");
        } else {
            printList();
        }
    }
    
	// make list empty
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }
}
