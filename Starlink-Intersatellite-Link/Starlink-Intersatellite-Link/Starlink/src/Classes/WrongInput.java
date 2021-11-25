package Classes;

public class WrongInput extends Exception{
    private String str ; 
    public WrongInput(String str){
        this.str = str; 
    }

    public String toString(){
        return ("Wrong Input! : " + str);
    }
}
