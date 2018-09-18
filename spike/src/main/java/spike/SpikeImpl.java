package spike;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-09-05
 */
public class SpikeImpl implements SpikeInterface{
    static Map<Long, Long> inventory;
    static {
        inventory = new HashMap<Long, Long>();
        inventory.put(10000000001L, 10000l);
        inventory.put(10000000002L, 10001l);
    }

    public void spike(String userId, Long commodityId) {
        reduce(commodityId);
    }

    public Long reduce(Long commodityId) {
        inventory.put(commodityId, inventory.get(commodityId) -1);
        return inventory.get(commodityId);
    }
}
