package ynu.edu.domin;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data
public class Orders {

	@TableId(type = IdType.AUTO)


	private Integer orderId;
	private String userId;
	private Integer businessId;
	private String orderDate;
	private Double orderTotal;
	private Integer daId;
	private Integer orderState;
	
	//多对一
	private Business business;
	//一对多
	private List<OrderDetailet> list;
	


	@Override
	public String toString() {
		return "Orders{" +
				"orderId=" + orderId +
				", userId='" + userId + '\'' +
				", businessId=" + businessId +
				", orderDate='" + orderDate + '\'' +
				", orderTotal=" + orderTotal +
				", daId=" + daId +
				", orderState=" + orderState +
				", businessName=" + business.getBusinessName() +
				", list=" + list.toString() +
				'}';
	}
}
