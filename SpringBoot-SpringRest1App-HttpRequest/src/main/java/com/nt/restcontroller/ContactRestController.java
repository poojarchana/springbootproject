package com.nt.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.nt.contact.Contact;
import com.nt.contact.Contacts;

@RestController
public class ContactRestController {
	
	//Get request method returning single object
	@GetMapping(value="/contact/{cid}",
			produces= {"application/json","application/xml"}
			)
	public Contact getContact(@PathVariable("cid") Integer cid) {
		Contact c=new Contact();
		c.setContactId(101);
		c.setContactName("Paro");
		c.setContactAddrs("Hyd");
		c.setContactNum(67657654l);
		return c;
	}
		
//Get request method returning multiple objects
 @GetMapping(value="/contacts",
		 produces= {"application/json","application/xml"}
 )		
  public Contacts getAllContacts() {
	  Contacts contacts=new Contacts();
	  List<Contact> listContact=new ArrayList();
	  Contact c1=new Contact(102,"John",574456476l,"Hyd");
	  Contact c2=new Contact(103,"Ashok",574456476l,"Odisha");
	  listContact.add(c1);
	  listContact.add(c2);
	  contacts.setContacts(listContact);
	  return contacts;
       }

//RespnseEntity is used to construct resource 
  //method response to client
@GetMapping(value="/contacts/{cid}",
             produces= {"application/json","application/xml"})
public ResponseEntity<Contact> getContactById1(@PathVariable("cid") Integer cid){
	Contact c=new Contact();
	c.setContactId(104);
	c.setContactName("Khusi");
	c.setContactNum(85754545l);
	c.setContactAddrs("Hyd");
	ResponseEntity<Contact> response=new ResponseEntity<Contact>(c,HttpStatus.OK);
	return response;
}
//HttpPost to receive one object
@PostMapping(value="/addContact",
              consumes= {"application/xml","application/json"})
 public ResponseEntity<String> addContact(@RequestBody Contact c){
	System.out.println(c);
	String respMsg="Contact saved successfully";
	return new ResponseEntity<>(respMsg,HttpStatus.CREATED);
}
//HttpPost to receive multiple objects

@PostMapping(value="/addContacts",
consumes= {"application/xml","application/json"})
public ResponseEntity<String> addContacts(@RequestBody Contacts contacts)
	{
		List<Contact> contactList=contacts.getContacts();
		contactList.forEach(contact->{
			System.out.println(contact);
		});
		String respMsg="Contacts added successfully";
		return new ResponseEntity<>(respMsg,HttpStatus.CREATED);
	}
//RequestHeader
@GetMapping("/header")
public String readHeader(@RequestHeader("Secret-key") String secretKey){
	System.out.println(secretKey);
	return "ok";
	
}
@GetMapping("/header")
public String readHeader1(@RequestHeader("Secret-key") String secretKey){
	System.out.println(secretKey);
	return "ok";
	
}
	
}


	
	
	
	
	


