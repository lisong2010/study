package lock;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-09-05
 */
public class RedisLock {
    private String lockedPrefix;
    private String value;
    private int MILLI_NANO_TIME = 5;
    private boolean lock;

    public RedisLock(String lockedPrefix, String value) {
        this.lockedPrefix = lockedPrefix;
        this.value = value;
    }

    public boolean lock(long timeout, int expire) {
        long nanoTime = System.nanoTime();
        timeout *= MILLI_NANO_TIME;
        return lock;
    }

    public void unlock() {
        if(this.lock) {
//            redisClient.delKey(key);
        }
    }
}
