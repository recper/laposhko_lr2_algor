/**
 * Created with IntelliJ IDEA.
 * User: Сергей
 * Date: 26.10.13
 * Time: 22:40
 * To change this template use File | Settings | File Templates.
 */
public class InsideSCList {
    public int data;
    public InsideSCList next;


    InsideSCList()
    {
        data = 0;
        next = null;
    }
    InsideSCList(int x)
    {
        this();
        data = x;
    }
}
