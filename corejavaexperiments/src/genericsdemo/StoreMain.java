package genericsdemo;

public class StoreMain {



    public static void main(String args[]){
        Store<Integer> store=new Store<>();
        store.setValue(300);
       int val=store.getValue();
    }
}
