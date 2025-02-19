package ynu.edu.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CommonResult<T> implements Serializable {
    private Integer code;
    private String message;
    private T result;
}
