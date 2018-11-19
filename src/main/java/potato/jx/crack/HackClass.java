package potato.jx.crack;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

/**
 * Author     : zh_zhou
 * Create at  : 2018/1/2 9:42
 * Description:
 */
public class HackClass {
    final Class t;
    final String fieldName;
    public HackClass(Class t, String fieldName) {
        this.t = t;
        this.fieldName = fieldName;
    }

    public Class getT() {
        return t;
    }

    public String getFieldName() {
        return fieldName;
    }

    public SimpleDateFormat getDateFormat() throws IllegalAccessException, NoSuchFieldException {
        Field field=getDateFormatField();
        field.setAccessible(true);
        return (SimpleDateFormat) field.get(null);
    }

    public Field getDateFormatField() throws NoSuchFieldException {
        return t.getField(fieldName);
    }
}
