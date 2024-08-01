package auction.controller;

import java.util.Scanner;

import auction.service.BidService;
import auction.service.BidServiceImp;

public class BidController {
	private BidService bidService = new BidServiceImp();
	private Scanner scan;
	
	public BidController(Scanner scan) {
		this.scan = scan;
	}
}
