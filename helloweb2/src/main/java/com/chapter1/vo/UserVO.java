package com.chapter1.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
	private String userid;
	private String userpassword;
	private String username;
	private int    userage;
	private String useremail;
	
	private String userjob =null;
	private String userhobby=null;
	
	private String action=null;
}