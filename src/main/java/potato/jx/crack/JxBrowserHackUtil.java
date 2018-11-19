package potato.jx.crack;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

/**
 * Author     : zh_zhou
 * Create at  : 2017/12/31 16:02
 * Description:
 */
public class JxBrowserHackUtil {



    static boolean hacked = false;

    private static final Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void hack(JxVersion version) {
        if (hacked) {
            return;
        }
        try {
            HackClass target = getTargetClass(version);
            SimpleDateFormat df = target.getDateFormat();
            MySimpleDateFormat mySimpleDateFormat = new MySimpleDateFormat(df);
            setFinalStatic(target.getDateFormatField(), mySimpleDateFormat);
            System.setProperty("teamdev.license.info", "true");
            hacked = true;
        } catch (Exception e) {
            e.printStackTrace();
            hacked = false;
        }

    }

    public static void setFinalStatic(Field field, Object newValue) throws Exception {


        final Object base = unsafe.staticFieldBase(field);
        //this is an 'offset'
        final long offset = unsafe.staticFieldOffset(field);

        unsafe.putObject(base, offset, newValue);
    }

    static HackClass getTargetClass(JxVersion version) throws ClassNotFoundException {
        String className = "com.teamdev.jxbrowser.chromium.ay";
        String fieldName = "a";
        switch (version) {
            case V6_09:
                className = "com.teamdev.jxbrowser.chromium.ay";
                fieldName = "a";
                break;
            case V6_18:
                className = "com.teamdev.jxbrowser.chromium.ba";
                fieldName = "a";
                break;
            case V6_22:
                className ="com.teamdev.jxbrowser.chromium.bc";
                fieldName = "a";
                break;
        }
        Class t = Class.forName(className);
        return new HackClass(t, fieldName);
    }

}
