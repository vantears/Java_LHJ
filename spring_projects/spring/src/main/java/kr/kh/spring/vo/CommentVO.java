package kr.kh.spring.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.*;

@Data
public class CommentVO {
	int co_num; 
	String co_contents; 
	int co_bo_num; 
	String co_me_id;
	private Date co_reg_date;
	
	public String getCo_reg_date_str() {
		if(co_reg_date == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(co_reg_date);
	}
}