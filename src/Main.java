import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Сергей
 * Date: 26.10.13
 * Time: 21:45
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static void testSimplyConnectedList() {
        MySimplyConnectedList list = new MySimplyConnectedList();
        list.AddLast(2);
        list.AddLast(3);
        list.AddLast(5);
        list.AddLast(6);
        list.AddLast(7);
        list.AddLast(8);
        list.AddAfter(4, 1);
        list.AddFirst(1);
        list.Print();
        System.out.print("\n");
        list.Swap(0, 2);
        list.Print();
        System.out.print(" Swap 0 2 \n");
        list.SwapElements();
        list.Print();
        System.out.print(" Swap All elements(3.7)\n");
        list.MoreLessB(2).Print();
        System.out.print(" More and less then 2nd(3.4)\n");
        list.SwapElements();
        list.Remove(8);
        list.RemoveId(6);
        list.Print();
        System.out.print(" -  7 and 8 remove\n" + list.Find(5) + " - Index of 5\n");
        list.ClearFromEven();
        list.Print();
        System.out.print(" Cleared from even(3.1)\n");
        list.MaxMinSwap();
        list.Print();
        System.out.print(" Max and min are swaped(3.5)\n");
        list = new MySimplyConnectedList();
        list.AddLast(2);
        list.AddLast(3);
        list.AddLast(5);
        list.AddLast(6);
        list.AddLast(7);
        list.AddLast(8);
        list.AddAfter(4,1);
        list.AddFirst(1);
        list.EvenOdd().Print();
        System.out.print(" Even and odd(3.2)\n");

    }

    static void testDoublyConnectedList() {
        MyDoublyLinkedList list = new MyDoublyLinkedList();
        list.AddLast(2);
        list.AddLast(3);
        list.AddLast(5);
        list.AddLast(6);
        list.AddFirst(1);
        list.AddAfter(4, 2);
        list.Print();
        System.out.print("\n");
        list.Swap(0, 2);
        list.Print();
        System.out.print("0 2 Swaped\n");
        list.PrintFromEnd();
        System.out.print("Printed from end\n");
        list.Remove(3);
        list.Print();
        System.out.print("3 is removed\n");
        list.PrintFromEnd();
        System.out.print("Printed from end\n"+list.Find(5)+" - index of 5");
    }

    static void testMyStack(){
        MyStack stack = new MyStack(10);
        Scanner scan = new Scanner(System.in);
        char[] s = scan.next().toCharArray();
        for (int i = 0; i<5; i++){
            stack.Push(s[i]);
        }
        try{
            stack.Pop();
            stack.Pop();
        }
        catch (Exception e){

        }
        stack.Print();


    }

    static void  testMyQueue(){
        MyQueue queue = new MyQueue(5);
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i<5; i++){
            queue.Push(scan.nextInt());
        }
        queue.Print();
        System.out.print("\n");
        queue.Pool();
        queue.Pool();
        queue.Print();
        System.out.print("2xPool\n");
        queue.Push(1);
        queue.Push(1);
        System.out.print("2xPush(1)\nPush(10) - "+queue.Push(10)+" - очередь полна.\n2xPool()\nPush(11) - ");
        queue.Pool();
        queue.Pool();
        queue.Push(11);
        queue.Print();
        System.out.print(" - 11 находится в начале массива.");
    }

    static boolean testBrackets(String brackets) throws Exception {
        MyStack stack = new MyStack(80);
        char[] s = brackets.toCharArray();
        for(int i = 0; i< brackets.length(); i++){
            if(s[i] == '(' || s[i] == '[' || s[i] == '{'  ){
                stack.Push(s[i]);
                continue;
            }
            if(s[i] == ')' || s[i] == ']' || s[i] == '}'  ){
                char t = stack.Pop();
                if(s[i]!=t){
                    return false;
                }
                continue;
            }
        }
        return true;
    } //3.3
    static int CountingMan(int n, int m){
        InsideSCList inside = new InsideSCList(1);
        MySimplyConnectedList list = new MySimplyConnectedList(inside);
        for(int i =2; i<=n ; i++){
            inside.next = new InsideSCList(i);
            inside = inside.next;
        }
        inside.next = list.list;
        int i = 1;
        while (inside.next!=null && inside.next!=inside){
            if(i==m){
                inside.next = inside.next.next;
                i = 1;
            }
            else {
                inside = inside.next;
                i++;
            }
        }
        return inside.data;
    }    //3.6

    public static void main(String[] args) {
        testMyQueue();
    }
}
