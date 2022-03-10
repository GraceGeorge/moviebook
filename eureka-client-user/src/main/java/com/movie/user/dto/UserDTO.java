package com.movie.user.dto;


public class UserDTO {
	
		private Integer userId;
		private String userName;
		private String password;
		private String phoneNo;
		private String emailId;
		private String role;
		
		public UserDTO(Integer userId, String userName, String password, String phoneNo, String emailId, String role ) {
			super();
			this.userId=userId;
			this.userName=userName;
			this.password=password;
			this.phoneNo=phoneNo;
			this.emailId=emailId;
			this.role=role;
		}
		
		public Integer getUserId() {
			return userId;
		}



		public void setUserId(Integer userId) {
			this.userId = userId;
		}



		public String getUserName() {
			return userName;
		}



		public void setUserName(String userName) {
			this.userName = userName;
		}



		public String getPassword() {
			return password;
		}



		public void setPassword(String password) {
			this.password = password;
		}



		public String getPhoneNo() {
			return phoneNo;
		}



		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}



		public String getEmailId() {
			return emailId;
		}



		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}



		public String getRole() {
			return role;
		}



		public void setRole(String role) {
			this.role = role;
		}



		@Override
		public String toString() {
			return "User [userId="+ userId +"userName=" + userName + ", password=" + password + 
					"phoneNo="+phoneNo+"email="+emailId+"role="+role+ "]";
		}
		
}
