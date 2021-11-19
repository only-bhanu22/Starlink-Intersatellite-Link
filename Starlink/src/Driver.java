import java.util.*;

import Colors.Colors;
import Classes.GroundStation; 
import Classes.LEOsatellite; 
import Classes.GSOsatellite;


public class Driver {

    static int numberOfMessages ;    
    public static void main(String[] args){

        System.out.println("\n"+Colors.PURPLE+"Enter the number of messages you want to send from one groundstation station to another"+Colors.RESET+"\n");
        Scanner scr = new Scanner(System.in)  ; 
        numberOfMessages = scr.nextInt() ; 

        while(numberOfMessages -->0){
            System.out.println(Colors.ANSI_YELLOW+"Enter the intial ground station and final ground station"+Colors.RESET);
            int initialGroundStation = scr.nextInt() ; 
            int finalGroundStation = scr.nextInt() ; 

            GroundStation groundStation = new GroundStation(initialGroundStation , finalGroundStation);

            // Thread t = new Thread(groundStation) ; 
            // t.start();
            // System.out.println(t.isAlive());
            LEOsatellite [] leoSatellites = new LEOsatellite[5] ;

            int transferToLEO = groundStation.sendMessage(); 

            leoSatellites[transferToLEO] = new LEOsatellite(finalGroundStation , transferToLEO);

            int transferFromLEO = leoSatellites[transferToLEO].sendMessage();

            if(transferFromLEO==-1){
                groundStation.receiveMessage();
            }
            
            if(transferFromLEO == 0){
                leoSatellites[transferFromLEO+1] = new LEOsatellite(finalGroundStation, transferToLEO+1) ;
                leoSatellites[transferFromLEO+1].sendMessage();

                groundStation.receiveMessage();
            }

            if(transferFromLEO == 1){
                 GSOsatellite gsoSatellite = new GSOsatellite(finalGroundStation) ;
                 transferToLEO = gsoSatellite.sendMessage();

                 leoSatellites[transferFromLEO]=new LEOsatellite(finalGroundStation, transferToLEO);
                 leoSatellites[transferFromLEO].sendMessage();
                 
                 groundStation.receiveMessage();
            }
            
            System.out.println();
            
        }


        scr.close();
    }
}
