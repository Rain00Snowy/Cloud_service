package ynu.edu.domin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("deliveryAddress")
@Data
public class DeliveryAddress {

	@TableId(type = IdType.AUTO)

	private Integer daId;
	private String contactName;
	private Integer contactSex;
	private String contactTel;
	private String address; 
	private String userId;
	


	@Override
	public String toString() {
		return "DeliveryAddress{" +
				"daId=" + daId +
				", contactName='" + contactName + '\'' +
				", contactTel='" + contactTel + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}
