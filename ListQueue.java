public class ListQueue implements Queue{
    int size;
    Node head;
    Node top;
    public ListQueue(){
        size = 0;
        head = null;
        top = null;
    }
    
    //number of items int the array queue
    public int size(){
        return size;
    }
    
    //returns true if the array is empty
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }
    
    //add new item to the array queue
    public void enqueue(Object o) throws QueueOverflowException{
        if(size == 0){
            size++;
            head = new Node(o, null);
            top = head;
        }
        else{
            size++;
            Node n = new Node(o, null);
            top.next = n;
            top = n;
        }
    }
    
    //remove item to the array queue
    public Object dequeue() throws QueueUnderflowException{
        Object removed = null;
        if(size == 0)throw new QueueUnderflowException();
        else{
            removed = head;
            head.next = head;
            size--;
        }
        return removed;
    }
    
//[x y z] format
    public String toString(){
        String s = " ";
        if(size == 0) return "[" + " ]";
        
        for(Node i = head; i != null; i = i.next){
            s += i.val + " ";
        }
        return "[ " + s + " ]";
    }
    
//returns array  
    public Object[] toArray(){
        Object [] a = new Object[size];
        int c = 0;
        for(Node i = head; i != null; i = i.next){
            a[c] = i.val;
            c++;
        }
        return a;
    }
    
//search the item in the stack and return the offset
    public int search(Object o){
        int c = 0;
        for(Node i = head; i != null; i = i.next){
            if(i.val == o){
                return c;
            }
        }
        return -100;
    }
}