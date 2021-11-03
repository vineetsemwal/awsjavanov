package genericsdemo;

public class Store<T> {
   private  T  value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
