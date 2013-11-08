/**
 * Created with IntelliJ IDEA.
 * User: Сергей
 * Date: 26.10.13
 * Time: 22:37
 * To change this template use File | Settings | File Templates.
 * Создать функции для работы с односвязным списком: добавление
 * элемента после заданного, в начало и в конец, удаление элемента по
 * значению, поиск элемента по значению, обмен двух элементов списка
 * местами, распечатка списка. Список представлен в динамической
 * памяти.
 */
public class MySimplyConnectedList {
    InsideSCList list;

    MySimplyConnectedList(){
        list = null;
    }
    MySimplyConnectedList(InsideSCList list){
        this.list = list;
    }

    public void AddLast(int x) {
        if (list == null) {
            list = new InsideSCList(x);
            return;
        }
        InsideSCList i = list;
        for (; i.next != null; i = i.next) ;
        i.next = new InsideSCList(x);
    }
    public void AddFirst(int x) {
        InsideSCList t = new InsideSCList(x);
        t.next = list;
        list = t;
    }
    public boolean AddAfter(int x, int n) {
        InsideSCList i = list;
        for (int k = 0; k < n; k++, i = i.next) {
            if (i == null)
                return false;
        }
        InsideSCList t = new InsideSCList(x);
        t.next = i.next;
        i.next = t;
        return true;
    }
    public boolean Remove(int x) {
        if(list.data == x){
            list = list.next;
        }
        for (InsideSCList i = list; i != null; i = i.next) {
            if (i.next.data == x) {
                i.next = i.next.next;
                return true;
            }
        }
        return false;
    }
    public boolean RemoveId(int i){
        int k = 0;
        if(i==0){
            list = list.next;
            return true;
        }
        for(InsideSCList j = list; j!=null;j=j.next,k++ ){
             if(k==i-1){
                 j.next = j.next.next;
                 return true;
             }
        }
        return false;
    }
    public int Find(int k) {
        if(list.data == k){
            return 0;
        }
        int j = 0;
        for (InsideSCList i = list; i != null; i = i.next, j++) {
            if (i.data == k) {
                return j;
            }
        }
        return -1;
    }
    public void Swap(int first, int second) {
        if (first > second) {
            int t = second;
            second = first;
            first = t;
        }
        if (first < 0) {
            return;
        }
        InsideSCList beforeFirst = null, beforeSecond = null;
        int j = 0;
        for (InsideSCList i = list; i != null; i = i.next, j++) {
            if (j == first - 1) {
                beforeFirst = i;
            }
            if (j == second - 1) {
                beforeSecond = i;
            }
        }
        if (first == 0) {
            beforeFirst = new InsideSCList();
            beforeFirst.next = list;
        }
        if (beforeFirst == null || beforeSecond == null)
            return;
        InsideSCList linkKeeper = new InsideSCList();
        linkKeeper.next = beforeSecond.next;
        beforeSecond.next = beforeFirst.next;
        beforeFirst.next = linkKeeper.next;
        linkKeeper.next = beforeFirst.next.next;
        beforeFirst.next.next = beforeSecond.next.next;
        beforeSecond.next.next = linkKeeper.next;
        if (first == 0) {
            list = beforeFirst.next;
        }
    }
    public void Print() {
        for (InsideSCList i = list; i != null; i = i.next) {
            System.out.print(i.data + ", ");
        }
    }

    public void ClearFromEven() {
        for (InsideSCList i = list; i.next != null;) {
            if(i.next.data%2 == 0){
                i.next = i.next.next;
            }
            else {
                i=i.next;
            }
        }
    }
    public MySimplyConnectedList EvenOdd(){
        InsideSCList list1 = new InsideSCList();
        MySimplyConnectedList res = new MySimplyConnectedList(list1);
        InsideSCList firstEven = list1;
        for(InsideSCList i = list; i!=null;i=i.next){
            if(i.data%2!=0){
                res.AddLast(i.data);
            }
            if(i.data%2 == 0){
                InsideSCList t = new InsideSCList(i.data);
                t.next = firstEven.next;
                firstEven.next = t;
                firstEven = t;
            }
        }
        res.RemoveId(0);
        return  res;
    }
    public MySimplyConnectedList MoreLessB(int j){
        int k = 0;
        InsideSCList b = null;
        for(InsideSCList i=list; i!=null;i=i.next,k++){
            if(k==j){
                b=i;
                break;
            }
        }
        if(b==null)
            return null;
        InsideSCList list1 = new InsideSCList();
        MySimplyConnectedList res = new MySimplyConnectedList(list1);
        InsideSCList lastLessB = list1;
        InsideSCList lastEqualsB = list1;
        for(InsideSCList i = list; i!=null;i=i.next){
            if(i.data>b.data){
                res.AddLast(i.data);
            }
            if(i.data<b.data){
                InsideSCList t = new InsideSCList(i.data);
                t.next = lastLessB.next;
                lastLessB.next = t;
                lastLessB = t;
            }
            if(i.data == b.data){
                InsideSCList t = new InsideSCList(i.data);
                t.next = lastEqualsB.next;
                lastEqualsB.next = t;
                lastEqualsB = t;
            }
        }
        res.RemoveId(0);
        return res;
    }
    public void MaxMinSwap(){
        int imax=0, imin=0;
        int valmax = list.data, valmin = list.data;
        int j = 0;
        for(InsideSCList i = list; i!=null; i = i.next,j++){
            if(i.data>valmax){
                valmax = i.data;
                imax = j;
            }
            if(i.data<valmin){
                valmin = i.data;
                imin = j;
            }
        }
        Swap(imax,imin);
    }
    public void SwapElements(){
        InsideSCList prev = null;
        InsideSCList nextElem = list;
        InsideSCList current = list;
        while (nextElem!=null){
            nextElem =  nextElem.next;
            current.next = prev;
            prev = current;
            current = nextElem;
        }
        list = prev;
    }
}
