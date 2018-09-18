package spike;

import annotation.CacheLock;
import annotation.LockedObject;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-09-05
 */
public interface SpikeInterface {

    @CacheLock(lockedPrefix = "TEST_PREFIX")
    public void spike(String userId, @LockedObject Long commodityId);
}
