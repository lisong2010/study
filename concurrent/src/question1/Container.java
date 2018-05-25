package question1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lisong(OF2016)
 *         company qianmi.com
 *         Date    2018-05-25
 */
public class Container {

    private volatile List list = new ArrayList();

    public int size() {
        return list.size();
    }

    public void add(Object obj) {
        list.add(obj);
    }
}
