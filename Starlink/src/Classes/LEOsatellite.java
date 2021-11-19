package Classes;

import Colors.Colors;

public class LEOsatellite extends Satellite implements Runnable {

    private int finalPosition ; 
    private int LEOsatelliteID ;

    public LEOsatellite(int finalPosition , int LEOsatelliteID){
        this.finalPosition = finalPosition ; 
        this.LEOsatelliteID = LEOsatelliteID ;
    }

    @Override
    public void run() {
        System.out.println("LEO Satellite thread created");
    }

    @Override
    public int sendMessage() {
        if((finalPosition == 2*LEOsatelliteID) || (finalPosition==2*LEOsatelliteID+1)){
            System.out.println(Colors.RED+"LEOsatellite "+LEOsatelliteID+" thread : "+Colors.GREEN+"This is LEOsatellite "+LEOsatelliteID+" sending message to GroundStation "+finalPosition+Colors.RESET);

            return -1 ; 
        }
        else if(finalPosition == 2*LEOsatelliteID+2 || finalPosition == 2*LEOsatelliteID+3 || finalPosition == 2*LEOsatelliteID-1 || finalPosition == 2*LEOsatelliteID-3){
            System.out.println(Colors.RED+"LEOsatellite "+LEOsatelliteID+" thread : "+Colors.GREEN+"This is LEOsatellite "+LEOsatelliteID+" sending message to LEOsatellite "+(LEOsatelliteID+1)+Colors.RESET);
            return 0 ;
        }
        else{
            System.out.println(Colors.RED+"LEOsatellite "+LEOsatelliteID+" thread : "+Colors.GREEN+"This is LEOsatellite "+LEOsatelliteID+" sending message to GSOsatellite "+Colors.RESET);
            return 1 ;
        }
    }



}
