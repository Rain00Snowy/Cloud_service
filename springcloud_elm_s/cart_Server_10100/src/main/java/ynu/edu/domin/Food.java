package ynu.edu.domin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Food {

	@TableId(type = IdType.AUTO)


	private Integer foodId;
	private String foodName;
	private String foodExplain;
	private String foodImg;
	private Double foodPrice;
	private Integer businessId;
	private String remarks;
	


	@Override
	public String toString() {
		return "Food{" +
				"foodId=" + foodId +
				", foodName='" + foodName + '\'' +
				", businessId=" + businessId +
				'}';
	}
}
