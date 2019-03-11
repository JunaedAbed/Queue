import java.util.Scanner;
public class WRM{
    int id = 0;
    public Queue q;
    int choice;
    int a ;
    int id_count = 1;
    Patient p;
    
    Scanner in = new Scanner(System.in);
    
    public WRM(){
        System.out.println("Enter 1 for array and 2 for List");
        while(true){
            try{  
                
                a = in.nextInt();
                if(a != 1 && a != 2){
                    System.err.println("Wrong input!");
                    
                }
                else if(a == 1){
                    q = new ListQueue();
                    break;
                }
                else if(a == 2){
                    q = new ArrayQueue();
                    break;
                }
            }
            catch(Exception e){
                System.err.println("wrong input. please try again");
                in.next();
            }
        }
    }
    
    public void RegisterPatient(){
        try{System.out.println("Enter patient name");
            String n = in.next();
            System.out.println("Enter patient's Blood Group");
            String bg = in.next();
            System.out.println("Enter patient age");
            int a = in.nextInt();
            id++;
            int i = id;
            
            p = new Patient(n, bg, a, i);
            q.enqueue(p);
            System.out.println("___Patient registered___");
        }
        catch(Exception e){
            System.out.println("Queue is full");
        }
    }
    
    public void ServePatient(){
        
        try{
            q.dequeue();
            
            int id_track = id - (id - id_count);
             
            System.out.println( "___ID:"+ id_track +" patient Served____");
            id--;
            if(id != 0) id_count++;
    
        }
        catch(Exception e){
            System.out.println("Queue is empty");
        }
    }
    
    public void ShowAllPatient(){
        if(q.size() == 0){
            System.out.println("No patient left");
            
        }
        
        Object [] arr = q.toArray();
        System.out.println("____Showing all patients____");
        for(int i = 0; i < arr.length; i++){
            System.out.println(((Patient)arr[i]).name);
        }
    }
    public void CancelAll(){
        while(!q.isEmpty()){
            try{
                q.dequeue();
            }
            catch(Exception e){
                System.out.println("Queue is full");
            }
        }
        System.out.println("___All appointments are cancelled___");
    }
    
    public void CanDoctorGoHome(){
        if(q.isEmpty()){
            System.out.println("____Doctor can go home____");
        }
        else{
            System.out.println("Doctor cannot go home");
        }
    }
}