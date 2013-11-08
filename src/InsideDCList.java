/**
 * Created with IntelliJ IDEA.
 * User: Сергей
 * Date: 27.10.13
 * Time: 11:28
 * To change this template use File | Settings | File Templates.
 */
public class InsideDCList {
    public int data;
    public InsideDCList next;
    public InsideDCList prev;


    InsideDCList() {
        data = 0;
        next = null;
        prev = null;
    }

    InsideDCList(int x) {
        this();
        data = x;
    }
}