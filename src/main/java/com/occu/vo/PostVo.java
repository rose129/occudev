package com.occu.vo;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class PostVo {
	
		// 필드
	  	private String id; // user id
	  	private int postNo; // post no.
	    private int userNo;  // user no.
	    private String content; // text content
	    private Timestamp createDate; // 글작성 날짜
	    public String imgfile; // 이미지,동영상 파일 경로
	    public String img1; // 이미지 이름
	    
	    // 시간 필드
	    
	    private int seq;
	    private String dateWrite; //스트링형으로 저장시간을 변경 시간(게시판에 출력되는 "방금전", "5분전" 등)
	    
	   

		// 생성자
	    public PostVo() {
	    }
	   
		// 테스트용 아이디, 컨텐츠, 파일, 생성날짜
		public PostVo(String id, String content, Timestamp createDate, String imgfile) {
			
			this.id = id;
			this.content = content;
			this.createDate = createDate;
			this.imgfile = imgfile;
		}

		public PostVo(String id, String content, Timestamp createDate) {
			
			this.id = id;
			this.content = content;
			this.createDate = createDate;
		}
		
		
	    public PostVo(String id, int postNo, int userNo, String content, Timestamp createDate, String imgfile) {
			this.id = id;
			this.postNo = postNo;
			this.userNo = userNo;
			this.content = content;
			this.createDate = createDate;
			this.imgfile = imgfile;
		}

	    public PostVo(String id, String content, Timestamp createDate, String img1, int seq, String dateWrite) {
	 
	    	this.id = id;
	    	this.content = content;
	    	this.createDate = createDate;
	    	this.img1 = img1;
	    	this.seq = seq;
	    	this.dateWrite = dateWrite;
	    }
		
		// 메소드



		public String getImgfile() {
	    	return imgfile;
	    }
	    
	    
	    
	    public int getSeq() {
			return seq;
		}

		public void setSeq(int seq) {
			this.seq = seq;
		}

		public String getDateWrite() {
			
			 	long createDate = this.createDate.getTime(); // 데이터베이스에서 가지고온 시간
		        long current_time = System.currentTimeMillis(); // 현재시간
		        long getTime = (current_time - createDate) / 1000; // (현재시간 - 데이터베이스에서 가지고온 시간) / 1000
		        if (getTime < 60) {
		            return "방금 전";
		        } else if (getTime < 300) {
		            return "5분 전";
		        } else if (getTime < 600) {
		            return "10분 전";
		        } else if (getTime < 900) {
		            return "15분 전";
		        } else if (getTime < 1200) {
		            return "20분 전";
		        }else if (getTime < 1800) {
		            return "30분 전";
		        } else if (getTime < 3600) {
		            return "1시간 전";
		        } else if (getTime < 43200) {
		            return "12시간 전";
		        } else if (getTime < 86400) {
		            return "1일 전";
		        } else if (getTime < 172800) {
		            return "2일 전";
		        } else if (getTime < 259200) {
		            return "3일 전";
		        } else {
		            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		            return sdf.format(new Date(createDate));
		        }
		}

		public void setDateWrite(String dateWrite) {
			this.dateWrite = dateWrite;
		}

		public String getImg1() {
			return img1;
		}



		public void setImg1(String img1) {
			this.img1 = img1;
		}



		public void setImgfile(String imgfile) {
	    	this.imgfile = imgfile;
	    }

		public int getPostNo() {
			return postNo;
		}

		public void setPostNo(int postNo) {
			this.postNo = postNo;
		}

		
		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}

		public int getUserNo() {
			return userNo;
		}

		public void setUserNo(int userNo) {
			this.userNo = userNo;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Timestamp getCreateDate() {
			return createDate;
		}

		public void setCreateDate(Timestamp createDate) {
			this.createDate = createDate;
		}

		// 출력
		@Override
		public String toString() {
			return "PostVo [ id :" + id + ", content: "+ content+ ", createDate: " + createDate  + "imgfile: " + imgfile + "img1: " + img1 + " ]";
		}
		

}
