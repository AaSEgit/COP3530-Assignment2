/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author scobo
 */
public class Node{
  //data
  Object i;
  // next node in the list
  Node next;
  // previous node in the list
  Node prev;
  Node(Object i){
   this.i = i;
  }

  public void displayData(){
    System.out.print(i.toString() + " ");
 }
}
