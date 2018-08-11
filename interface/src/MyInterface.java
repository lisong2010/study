/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-09
 */
public interface MyInterface {
    String name = null;

    default String getPathName() {
        return "test";
    }


    String getFileName();
}
