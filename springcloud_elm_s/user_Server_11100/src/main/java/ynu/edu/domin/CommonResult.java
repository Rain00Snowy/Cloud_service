package ynu.edu.domin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult {
    /**
     * 0 成功
     */
    private Integer code;
    private String msg;
    private Object data;
}
