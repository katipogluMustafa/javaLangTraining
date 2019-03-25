package PlayGround;

public class Pair<T> {
    private T first;
    private T second;

    public Pair(){
        this.first = null;
        this.second = null;
    }

    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst(){ return this.first; }
    public T getSecond(){return this.second; }

    public void setFirst(T first){ this.first = first; }
    public void setSecond(T second){ this.second = second; }

}
