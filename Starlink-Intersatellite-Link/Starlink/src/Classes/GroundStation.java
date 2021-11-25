package Classes;
import Colors.Colors;

public class GroundStation implements CommunicationInterface , Runnable {

    private int intialPosition ; 
    private int finalPosition ; 

    public GroundStation(int intialPosition , int finalPosition){
        this.intialPosition = intialPosition ; 
        this.finalPosition = finalPosition ; 
    }

    @Override
    public void run() {
        System.out.println("GroundStation thread created");
    }

    @Override
    public int sendMessage() {
        if(intialPosition%2 == 0){
            System.out.println(Colors.RED+"GroundStation "+intialPosition+" thread : "+Colors.GREEN+"This is GroundStation "+ intialPosition+ " sending message to LEOsatellite " +intialPosition/2 + Colors.RESET);
            return intialPosition/2; 
        } 
        else{
            System.out.println(Colors.RED+"GroundStation "+intialPosition+" thread : "+Colors.GREEN+"This is GroundStation "+intialPosition+ " sending message to LEOsatellite " +(intialPosition-1)/2 + Colors.RESET);
            return (intialPosition-1)/2 ;
        }
        
    }

    
    public void receiveMessage() {
        System.out.println(Colors.RED+"GroundStation "+finalPosition+" thread :"+Colors.GREEN+" This is GroundStation "+finalPosition+". recieved message."+Colors.RESET);
    }
}
