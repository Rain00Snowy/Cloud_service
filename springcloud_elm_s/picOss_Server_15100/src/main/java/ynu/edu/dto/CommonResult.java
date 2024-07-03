package ynu.edu.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CommonResult {
    /**
     * 0 成功
     */
    private Integer code;
    private String msg;
    private Object data;
}
