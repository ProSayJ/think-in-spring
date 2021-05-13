package prosayj.spring.transfer.pojo;

import lombok.Data;

/**
 * 通用返回体
 *
 * @author yangjian
 * @date 2021-05-13
 */
@Data
public class Result {
    private String status;
    private String message;
}
