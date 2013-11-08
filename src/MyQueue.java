/**
 * Created with IntelliJ IDEA.
 * User: Сергей
 * Date: 26.10.13
 * Time: 22:17
 * To change this template use File | Settings | File Templates.
 .
 Аналогично стеку реализуйте очередь на базе массива.
 */
public class MyQueue {
    public int[] mass;
    int first, last; // First - на первый элемент, Last - на первую пустую ячейку
    int quantity;
    public int length = 20;

    MyQueue()
    {
        mass = new int[length];
        quantity = 0;
        first = 0;
        last=0;
    }
    MyQueue(int length)
    {
        this();
        mass = new int[length];
    }

    private boolean isFull() {
        return quantity == mass.length;
    }
    private boolean isEmpty() {
        return quantity == 0;
    }

    boolean Push(int x)
    {
        if(isFull())
            return false;
        mass[last] = x;
        last++;
        last%=mass.length;
        quantity++;
        return true;
    }

    int Pool()
    {
        if(isEmpty()) {
            return Integer.parseInt(null);
        }
        int res = mass[first];
        first++;
        first %= mass.length;
        quantity--;
        return res;
    }
    public void Print(){
        int j = 0;
        for(int i = first; j<quantity; i++,j++){
            i %=mass.length;
            System.out.print(mass[i]+", ");
        }
    }

}
