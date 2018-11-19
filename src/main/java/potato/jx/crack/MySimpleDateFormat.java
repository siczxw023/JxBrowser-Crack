package potato.jx.crack;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Author     : zh_zhou
 * Create at  : 2017/12/31 16:02
 * Description:
 */
public class MySimpleDateFormat extends SimpleDateFormat {
    private static final long serialVersionUID = -2680960935177697658L;
    private final SimpleDateFormat df;

    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
    public MySimpleDateFormat(SimpleDateFormat df){
        this.df=df;
    }

    public MySimpleDateFormat(String pattern, Locale locale) {
        super(pattern, locale);
        df=null;
    }

    @Override
    public Date parse(String source) throws ParseException {

        Date date=df.parse(source);
        Date crackedExpire=df.parse("12-06-2217");
        String formated=dt.format(date);
        if("0012-06-16".equalsIgnoreCase(formated)||"0012-06-17".equalsIgnoreCase(formated)||"2017-06-12".equalsIgnoreCase(formated)||"12-06-2017".equalsIgnoreCase(formated)||"16-06-0012".equalsIgnoreCase(formated)){
            date=crackedExpire;
        }
        System.out.println("+++++++++++Parse Date => "+source +"<=>"+formated+" <= +++++++++++");
        return date;
    }




}

