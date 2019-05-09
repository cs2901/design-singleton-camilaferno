public class ChocolateBoiler{
    private boolean empty;
    private boolean boiled;

    private static ChocolateBoiler instance;

    public static ChocolateBoiler getInstance() {
        if (instance == null){
            instance = new ChocolateBoiler();
            System.out.println("Creado");
        }
        else{
            System.out.println("No creado");
        }
        return instance;
    }

    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    public void fill(){
        if(isEmpty()){
            empty = false;
            boiled = false;
        }
    }

    public void drain(){
        if(isEmpty() && isBoiled()){
            //drain the boiled milk and chocolate
            empty = true;
        }
    }

    public void boil(){
        if(!isEmpty() && isBoiled()){
            //bring the contents to a boil
            boiled = true;
        }
    }

    public boolean isEmpty(){
        return empty;
    }

    public boolean isBoiled(){
        return boiled;
    }
}

public class CreateThread extends Thread{
    @Override
    public void run(){
        try {
            ChocolateBoiler CB = ChocolateBoiler.getInstance();
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted");

        }
        System.out.println("exiting.");

    }
}

public class Main{
    public static void main(String[] args) {

        CreateThread r = new CreateThread();
        r.start();
        CreateThread r2 = new CreateThread();
        r2.start();
        CreateThread r3 = new CreateThread();
        r3.start();

        try{
            r.join();
            r2.join();
            r3.join();
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

    }
}