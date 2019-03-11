import java.util.Scanner;
public class Tester{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        WRM w = new WRM();
        
        
        
        while(true){ 
            System.out.println("Insert 1 to Register Patient");
            System.out.println("Insert 2 to Serve Patient");
            System.out.println("Insert 3 to Cancel all Patient's appoinment");
            System.out.println("Insert 4 to check Can doctor go home");
            System.out.println("Insert 5 to Show all Patients");
            
            try{
                int n = sc.nextInt();
                if(n == 1){
                    w.RegisterPatient();
                }
                else if(n == 2){
                    w.ServePatient();
                }
                else if(n == 3){
                    w.CancelAll();
                }
                else if(n == 4){
                    w.CanDoctorGoHome();
                }
                else if(n == 5){
                    w.ShowAllPatient();
                    
                }
                else{
                    System.err.println("Invalid index, try again");
                    
                }
                System.out.println();
            }
            catch(Exception e){
                System.err.println("Invalid input, try again");
                sc.next();
            }
        }
    }
}