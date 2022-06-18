package LinkedList;

public class LinkedList {
  Node head;
  public void insert(int data) {
   Node node=new Node();
   node.data=data;
   node.next=null;
   if(head==null){
     head=node;
   }else{
     Node current=head;
     while(current.next!=null){
       current=current.next;
     }
     current.next=node;
   }
  }
  public void show() {
    Node current=head;
    while(current.next!=null) {
      System.out.println(current.data);
      current=current.next;
    }
    System.out.println(current.data);
  }
}
