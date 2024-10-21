public class Pilha {
    int elementos[];
    int topo;

    public Pilha() {
       elementos = new int[10];
        topo = -1;
    }

    public  void push(int e){
        if (isFull()){
            System.out.println("Pilha está cheia!");
        }
        topo ++;
        elementos[topo] = e;
    }
    public  int pop(){
        if (isEmpty()){
            System.out.println("A pilha está vazia");
        }
        int e;
        e = elementos[topo];
        topo --;
        return e;
    }
    public boolean isEmpty(){
        return (topo == -1);
    }
    public  boolean isFull(){
        return (topo == 9);
    }

    public int top(){
        if (isEmpty()){
            throw new RuntimeException("A pilha está vazia!");
        }
        return elementos[topo];
    }
}
