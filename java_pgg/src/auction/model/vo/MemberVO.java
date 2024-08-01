package auction.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {
	private String me_id;
	private String me_password;
	private String me_name;
	private String me_address;
	private String me_contact;
}
