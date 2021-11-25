import java.util.*;

import Colors.Colors;
import Classes.GroundStation; 
import Classes.LEOsatellite; 
import Classes.GSOsatellite;
import Classes.WrongInput;


public class Driver {

    static int numberOfMessages ;    
    public static void main(String[] args){

        System.out.println("\n"+Colors.PURPLE+"Enter the number of messages you want to send from one groundstation station to another"+Colors.RESET+"\n");
        Scanner scr = new Scanner(System.in)  ; 
        numberOfMessages = scr.nextInt() ; 

        
        while(numberOfMessages -->0){
            

            System.out.println(Colors.YELLOW+"Enter the intial ground station and final ground station"+Colors.RESET);
            int initialGroundStation = scr.nextInt() ; 
            int finalGroundStation = scr.nextInt() ; 


            try {
                if(initialGroundStation>9||initialGroundStation<0||finalGroundStation>9||finalGroundStation<0){
                    throw new WrongInput(Colors.CYAN+"Invalid Input Entered By User"+Colors.RESET);
                }
            } catch (WrongInput e) {
                System.out.println(e);
                continue;
            }


            GroundStation groundStation = new GroundStation(initialGroundStation , finalGroundStation);

            Thread groundThread = new Thread(groundStation) ;

            LEOsatellite [] leoSatellites = new LEOsatellite[5] ;
            groundThread.run();

            try {
                groundThread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            } 
            
            int transferToLEO = initialGroundStation/2 ; 

            leoSatellites[transferToLEO] = new LEOsatellite(finalGroundStation , transferToLEO);

            int transferFromLEO = leoSatellites[transferToLEO].sendMessage();

            if(transferFromLEO==1){
                groundStation.receiveMessage();
            }
            
            if(transferFromLEO ==2){
                leoSatellites[transferFromLEO+1] = new LEOsatellite(finalGroundStation, transferToLEO+1) ;
                leoSatellites[transferFromLEO+1].sendMessage();

                groundStation.receiveMessage();
            }
            if(transferFromLEO ==3){
                leoSatellites[transferFromLEO-1] = new LEOsatellite(finalGroundStation, transferToLEO-1) ;
                leoSatellites[transferFromLEO-1].sendMessage();
                groundStation.receiveMessage();
            }

            if(transferFromLEO == 4){
                 GSOsatellite gsoSatellite = new GSOsatellite(finalGroundStation) ;
                 transferToLEO = finalGroundStation/2;
                 Thread gsoThread = new Thread(gsoSatellite) ;
                 gsoThread.run(); 
                 try {
                     gsoThread.sleep(500);
                 } catch (Exception e) {
                     System.out.println(e);
                 }
                 leoSatellites[transferFromLEO]=new LEOsatellite(finalGroundStation, transferToLEO);
                 leoSatellites[transferFromLEO].sendMessage();
                 
                 groundStation.receiveMessage();
            }
            
            System.out.println();
            
        }


        scr.close();
    }
}
