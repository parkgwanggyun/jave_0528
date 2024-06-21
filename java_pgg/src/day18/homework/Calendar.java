package day18.homework;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Calendar implements Serializable{
	
	private String name;
	private String schedule;
	private String detail;
}
