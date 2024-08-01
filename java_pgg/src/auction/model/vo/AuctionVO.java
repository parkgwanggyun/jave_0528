package auction.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuctionVO {
	private String au_num;
	private String au_name;
	private String au_date;
	private int au_start_price;
	private int au_winning_bid;
	private String au_me_id;
}
