/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This code is from Tech Tutorials and posts about Java
 * https://netjs.blogspot.com/2019/03/deque-implementation-in-java-using-doubly-linked-list.html
 */
public class LinkedListDeque {
 private Node head;
 private Node tail;
 private int count = 0;
 

 // constructor
 public LinkedListDeque(){
  this.head = null;
  this.tail = null;
 }
 
 public boolean isEmpty(){
  return head == null;
 }
 
 public void insertFirst(int i){
  //Create a new node
  Node newNode = new Node(i);
  // if first insertion tail should
  // also point to this node
  if(isEmpty()){
   tail = newNode;
  }else{
   head.prev = newNode;
  }
  newNode.next = head;
  head = newNode;
 }

 public void insertFirst(String i){
  //Create a new node
  Node newNode = new Node(i);
  // if first insertion tail should
  // also point to this node
  if(isEmpty()){
   tail = newNode;
  }else{
   head.prev = newNode;
  }
  newNode.next = head;
  head = newNode;
 }
 

 public void insertLast(int i){
  Node newNode = new Node(i);
  // if first insertion head should
  // also point to this node
  if(isEmpty()){
   head = newNode;
  }else{
   tail.next = newNode;
   newNode.prev = tail;
  }
  tail = newNode;
 }
 
 public Node removeFirst(){
  if(head == null){
   throw new RuntimeException("Deque is empty");
  }
  Node first = head;
  if(head.next == null){
   tail = null;
  }else{
   // previous of next node (new first) becomes null
   head.next.prev = null;
  }
  head = head.next;
  return first;
 }
 
 public Node removeLast(){
  if(tail == null){
   throw new RuntimeException("Deque is empty");
  }
  Node last = tail;
  if(head.next == null){
   head = null;
  }else{
   // next of previous node (new last) becomes null
   tail.prev.next = null;
  }
  tail = tail.prev;
  return last;
 }
 
 public Object getFirst(){
  if(isEmpty()){
   throw new RuntimeException("Deque is empty");
  }
  return head.i.toString();
 }
 
 public Object getLast(){
  if(isEmpty()){
   throw new RuntimeException("Deque is empty");
  }
  return tail.i.toString();
 }
 
 // Method for forward traversal
 public void displayForward(){
  Node current = head;
  while(current != null){
   current.displayData();
   current = current.next;
  }
  System.out.println("");
 }
 
 // Method to traverse and display all nodes
 public void displayBackward(){
  Node current = tail;
  while(current != null){
   current.displayData();
   current = current.prev;
  }
  System.out.println("");
 }

 public int length(){
  Node current = head;
  while(current != null){
   count++;
   current = current.next;
  }
  return count;
 }

 /*
 
 public static void main(String[] args) {
  LinkedListDeque deque = new LinkedListDeque(); 
  //deque.getLast();
  deque.insertFirst(2);  
  deque.insertFirst(1);
  deque.insertLast(3);
  deque.insertLast(4);
  deque.displayForward();
  Node node = deque.removeFirst();
  System.out.println("Node with value "+ node.i + " deleted");
  deque.displayForward();
  System.out.println("First element in the deque " + deque.getFirst());
  System.out.println("Last element in the deque " + deque.getLast());
  System.out.println(deque.isEmpty());
 }

 */

}


