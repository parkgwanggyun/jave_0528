package auction.controller;

import java.util.Scanner;

import auction.service.AuctionService;
import auction.service.AuctionServiceImp;



public class AuctionController {
	private AuctionService auctionService = new AuctionServiceImp();
	private Scanner scan;
	
	public AuctionController(Scanner scan) {
		this.scan = scan;
	}
}
