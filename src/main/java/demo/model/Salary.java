package demo.model;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
/*
 * not required as of now. As we are not working with any db
 * 
 */
@Getter
@Setter
@Slf4j
@NoArgsConstructor
public class Salary {

	private String message;
	private Date currentDate;
	private String remainingDays;
	
	
}
