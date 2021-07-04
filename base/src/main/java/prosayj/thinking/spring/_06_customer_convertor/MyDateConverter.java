package prosayj.thinking.spring._06_customer_convertor;

import lombok.Data;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MyDateConverter
 *
 * @author yangjian
 * @date 2021-01-02 下午 10:24
 * @since 1.0.0
 */
@Data
class MyDateConverter implements Converter<String, Date> {
    private String pattern;

    @Override
    public Date convert(String source) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            date = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
