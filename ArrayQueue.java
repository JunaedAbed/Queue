public class ArrayQueue implements Queue{
    int size;
    Object [] data;
    int head;
    int top;
    
    public ArrayQueue(){
        size = 0;
        data = new Object[5];
        head = -1;
        top = -1;
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
        if(size == data.length) throw new QueueOverflowException();
        
        else if(size == 0){
            size++;
            head = 0;
            top = 0;
            data[head] = 0;
        }
        else{
            size++;
            top ++;
            data[top] = o;
        }
    }
    
//remove item to the array queue
    public Object dequeue() throws QueueUnderflowException{
        Object removed = null;
        if(size == 0)throw new QueueUnderflowException();
        
        else if(size == 1){
            removed = data[head];
            data[head] = null;
            size--;
            head = -1;
            top = -1;
        }
        else{
            removed = data[head];
            size--;
            data[head] = null;
            head++;
        }
        return removed;
    }
    
//[x y z] format
    public String toString(){
        String s = " ";
        if(size == 0) return "[" + " ]";
        
        for(int i = head, c = 0; c < size; i++, c++){
            s += data[i] + " ";
        }
        return "[ " + s + " ]";
    }
    
//returns array  
    public Object[] toArray(){
        Object [] a = new Object[size];
        for(int i = head, c = 0; c < size; c++){
            a[c] = data[i + c];
            
        }
        return a;
    }
    
//search the item in the stack and return the offset
    public int search(Object o){
        for(int i = head, c = 0; c < size; i++, c++){
            if(data[i] == o){
                return c;
            }
        }
        return -100;
    }
}