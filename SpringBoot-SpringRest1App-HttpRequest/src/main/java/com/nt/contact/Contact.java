package com.nt.contact;



import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
	
	private Integer contactId;
	private String contactName;
	private Long contactNum;
	private String contactAddrs;
	

}
