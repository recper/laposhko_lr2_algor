/**
 * Created with IntelliJ IDEA.
 * User: Сергей
 * Date: 27.10.13
 * Time: 11:26
 * To change this template use File | Settings | File Templates.
 */
public class MyDoublyLinkedList {
    InsideDCList list;

    public void AddLast(int x) {
        if (list == null) {
            list = new InsideDCList(x);
            return;
        }
        InsideDCList i = list;
        for (; i.next != null; i = i.next) ;
        i.next = new InsideDCList(x);
        i.next.prev = i;
    }

    public void AddFirst(int x) {
        InsideDCList t = new InsideDCList(x);
        t.next = list;
        list.prev = t;
        list = t;
    }

    public boolean AddAfter(int x, int n) {
        InsideDCList i = list;
        for (int k = 0; k < n; k++, i = i.next) {
            if (i == null)
                return false;
        }
        InsideDCList t = new InsideDCList(x);
        t.next = i.next;
        i.next.prev = t;
        t.prev = i;
        i.next = t;
        return true;
    }

    public boolean Remove(int x) {
        AddCap(list);
        list = list.prev;
        for (InsideDCList i = list; i != null; i = i.next) {
            if (i.next.data == x) {
                i.next = i.next.next;
                if(i.next == null) {
                    list = list.next;
                    list.prev = null;
                    return true;
                }
                i.next.prev = i;
                list = list.next;
                list.prev = null;
                return true;
            }
        }
        list = list.next;
        list.prev = null;
        return false;
    }

    public int Find(int k) {
        int j = 0;
        for (InsideDCList i = list; i != null; i = i.next, j++) {
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
        InsideDCList elem1 = null, elem2 = null;
        int j = 0;
        for (InsideDCList i = list; i != null; i = i.next, j++) {
            if (j == first) {
                elem1 = i;
            }
            if (j == second) {
                elem2 = i;
            }
        }
        if(elem2 == null){
            return;
        }
        boolean firstCapIsAdded = AddCap(elem1);
        boolean secondCapIsAdded = AddCap(elem2);
        InsideDCList prev1 = CutElem(elem1);
        InsideDCList prev2 = CutElem(elem2);
        InsertElemAfter(prev1, elem2);
        InsertElemAfter(prev2, elem1);
        if(firstCapIsAdded){
            elem2.prev = null;
            list = elem2;
        }
        if(secondCapIsAdded){
            elem1.next = null;
        }
    }

    private boolean AddCap(InsideDCList elem) {
        if(elem.next == null){
            elem.next = new InsideDCList(10);
            elem.next.prev = elem;
            return true;
        }
        if(elem.prev == null){
            elem.prev = new InsideDCList(10);
            elem.prev.next = elem;
            return true;
        }
        return false;
    }

    private void InsertElemAfter(InsideDCList prev, InsideDCList elem) {
        elem.next = prev.next;
        prev.next.prev = elem;
        prev.next = elem;
        elem.prev = prev;
    }

    private InsideDCList CutElem(InsideDCList elem) {
        InsideDCList res = elem.prev;
        elem.prev.next = elem.next;
        elem.next.prev = elem.prev;
        return res;
    }

    public void Print() {
        for (InsideDCList i = list; i != null; i = i.next) {
            System.out.print(i.data + ", ");
        }
    }

    public void PrintFromEnd() {
        InsideDCList i = list;
        for (; i.next != null; i = i.next) ;
        for (; i != null; i = i.prev) {
            System.out.print(i.data + ", ");
        }
    }
}
