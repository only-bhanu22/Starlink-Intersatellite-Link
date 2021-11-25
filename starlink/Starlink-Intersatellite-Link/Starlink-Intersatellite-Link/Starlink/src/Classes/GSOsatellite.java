package Classes;

import Colors.Colors;

public class GSOsatellite extends Satellite implements Runnable {

    private int finalPosition ; 

    @Override
    public void run() {
        sendMessage();
    }

    public GSOsatellite(int finalPosition){
        this.finalPosition = finalPosition ; 
    }
    
    @Override
    public int sendMessage() {
        System.out.println(Colors.RED+"GSOsatellite 0 thread : "+Colors.GREEN+"This is GSOsatellite 0. sending message to LEOSatellite "+finalPosition/2+Colors.RESET );
        return finalPosition/2 ; 
    }

}
