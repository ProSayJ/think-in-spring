package prosayj.spring.mvc.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 自定义类型转换器
 * S：source，源类型
 * T：target：目标类型
 *
 * @author yangjian
 * @date 2021-05-19
 */
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        // 完成字符串向日期的转换
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
