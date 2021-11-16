package Classes;

import Colors.Colors;

public class GSOsatellite extends Satellite {

    private int finalPosition ; 

    public GSOsatellite(int finalPosition){
        this.finalPosition = finalPosition ; 
    }
    
    @Override
    public int sendMessage() {
        System.out.println(Colors.RED+"GSOsatellite 0 thread : "+Colors.GREEN+"This is GSOsatellite 0. sending message to LEOSatellite "+finalPosition/2+Colors.RESET );
        return finalPosition/2 ; 
    }
    @Override
    public void receiveMessage() {
        
    }
}
