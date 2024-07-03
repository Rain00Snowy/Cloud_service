package ynu.edu.domin;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Cart {

	@TableId(type = IdType.AUTO)
	private Integer cartId;
	private Integer foodId;
	private Integer businessId;
	private String userId;
	private Integer quantity;
	
	private Food food;
	private Business business;
	

	@Override
	public String toString() {
		return "Cart{" +
				"cartId=" + cartId +
				", foodId=" + foodId +
				", businessId=" + businessId +
				", userId='" + userId + '\'' +
				", quantity=" + quantity +
				", food=" + food.toString() +
				", business=" + business.toString() +
				'}';
	}
}
