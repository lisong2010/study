import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-16
 */
public class ServiceId {

    public static void main(String[] args) {
        long delta = 12345678901L;
        NumberFormat numberFormat = new DecimalFormat();
        numberFormat.setGroupingUsed(false);
        numberFormat.setMaximumIntegerDigits(3);
        numberFormat.setMinimumIntegerDigits(3);
        System.out.println(numberFormat.format(delta));
    }
}
