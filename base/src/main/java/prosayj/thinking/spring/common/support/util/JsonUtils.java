package prosayj.thinking.spring.common.support.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * JsonUtils
 *
 * @author yangjian
 * @since 1.0.0
 */
public class JsonUtils {

    public final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        //反序列时，忽略未知字段
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //对象属性中为null的字段不谄谀序列化
        //OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static String toJson(Object value) {
        try {
            return OBJECT_MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String toPrettyJson(Object value) {
        try {
            // 转换为格式化的json.美化
            // OBJECT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
            return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T toBean(String content, Class<T> type) {
        try {
            return OBJECT_MAPPER.readValue(content, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T toBean(byte[] data, Class<T> type) {
        return toBean(new String(data, StandardCharsets.UTF_8), type);
    }

    public static <T> List<T> toArrayListBean(String json, Class<T> object) {
        try {
            CollectionType listType = OBJECT_MAPPER.getTypeFactory()
                    .constructCollectionType(ArrayList.class, object);
            return OBJECT_MAPPER.readValue(json, listType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> toListBean(String data, Class<T> type) {
        JavaType javaType = OBJECT_MAPPER.getTypeFactory()
                .constructParametricType(List.class, type);
        return toList(data, javaType);
    }


    private static <T> List<T> toList(String data, JavaType javaType) {
        try {
            return OBJECT_MAPPER.readValue(data, javaType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static <T> T toList(byte[] data, TypeReference<T> type) {
        try {
            return OBJECT_MAPPER.readValue(data, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JsonNode readTree(byte[] data) {
        try {
            return OBJECT_MAPPER.readTree(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JsonNode readTree(String data) {
        try {
            return OBJECT_MAPPER.readTree(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
