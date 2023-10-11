package co.ds.linkedlist;

public class MainClass {
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList(1);
		//append values
		
//		list.append(3);
//		list.append(2);
//		list.append(2);
//		list.append(2);

//		list.printList();
		
		System.out.println("Remove last element");
		// Remove last element;
		list.append(2);
		//removes 2
		System.out.println(list.removeLast().value);
		
		//removes 1
		System.out.println(list.removeLast().value);
		
		// null list test
		System.out.println(list.removeLast());
		
		
		//prePend 
		System.out.println("\nprePend the element");
		list.printList();
		list.prepend(3);
		list.printList();
		list.prepend(5);
		list.printList();
		
		
		System.out.println("\nRemove first elemnt");
		System.out.println(list.removeFirst().value);
		System.out.println(list.removeFirst().value);
		System.out.println(list.removeFirst());
		
		System.out.println("\nGet element as per index");
		list.append(0);
		list.append(1);
		list.append(2);
		list.append(3);
		list.printList();
		System.out.println(list.get(2).value);
		System.out.println(list.get(1).value);
		list.printList();
		
		
		System.out.println("\nSet new value as per index");
		list.printList();
		list.set(1, 6);
		list.printList();
		list.set(2, 4);
		list.printList();
		
		System.out.println("\nInsert value at particular index");
		list.printList();
		System.out.println(list.insert(2, 1));
		list.printList();
		System.out.println(list.insert(0, 1));
		list.printList();
		
		System.out.println("\nRemove value at particular index");
		list.printList();
		System.out.println(list.remove(1));
		list.printList();
		System.out.println(list.remove(2));
		list.printList();
		System.out.println(list.remove(4));
		
		
		System.out.println("\nreverse the linked list");
		list.printList();
		list.reverse();
		list.printList();
	}
}
