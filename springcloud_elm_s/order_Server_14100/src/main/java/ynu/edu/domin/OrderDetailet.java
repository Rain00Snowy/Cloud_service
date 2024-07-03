package ynu.edu.domin;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("orderDetailet")
public class OrderDetailet {

	@TableId(type = IdType.AUTO)

	private Integer odId;
	private Integer orderId;
	private Integer foodId;
	private Integer quantity;
	
	private Food food;

	@Override
	public String toString() {
		return "OrderDetailet{" +
				"odId=" + odId +
				", orderId=" + orderId +
				", foodId=" + foodId +
				", quantity=" + quantity +
				", food=" + food +
				'}';
	}
}
