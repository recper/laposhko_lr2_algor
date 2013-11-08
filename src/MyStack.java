/**
 * Created with IntelliJ IDEA.
 * User: Сергей
 * Date: 26.10.13
 * Time: 22:00
 * To change this template use File | Settings | File Templates.
 */
/*
* Реализуйте стек на основе массива и операции POP, PUSH. В цикле
запишите в стек 5 элементов, введенных с клавиатуры. Затем
вытолкните из стека два элемента. Распечатайте остаток стека.
*
* */
public class MyStack{
    public char[] mass;
    public int length = 20;
    int top;

    public MyStack()
    {
        mass = new char[length];
        top = 0;
    }
    public MyStack(int length)
    {
        this();
        if(length>2)
            mass = new char[length];
    }

    boolean isEmpty()
    {
        return top == 0;
    }

    char Pop() throws Exception {
        if(isEmpty())
            throw new Exception();
        return mass[--top];
    }

    boolean Push(char x)
    {
        if(top == mass.length)
            return false;
        mass[top++] = x;
        return true;
    }

    public void Print(){
        for(int i = 0; i< top; i++){
            System.out.print(mass[i]+", ");
        }
    }


}
