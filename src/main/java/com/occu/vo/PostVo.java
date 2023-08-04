package com.occu.vo;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class PostVo {
	
		// �ʵ�
	  	private String id; // user id
	  	private int postNo; // post no.
	    private int userNo;  // user no.
	    private String content; // text content
	    private Timestamp createDate; // ���ۼ� ��¥
	    public String imgfile; // �̹���,������ ���� ���
	    public String img1; // �̹��� �̸�
	    
	    // �ð� �ʵ�
	    
	    private int seq;
	    private String dateWrite; //��Ʈ�������� ����ð��� ���� �ð�(�Խ��ǿ� ��µǴ� "�����", "5����" ��)
	    
	   

		// ������
	    public PostVo() {
	    }
	   
		// �׽�Ʈ�� ���̵�, ������, ����, ������¥
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
		
		// �޼ҵ�



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
			
			 	long createDate = this.createDate.getTime(); // �����ͺ��̽����� ������� �ð�
		        long current_time = System.currentTimeMillis(); // ����ð�
		        long getTime = (current_time - createDate) / 1000; // (����ð� - �����ͺ��̽����� ������� �ð�) / 1000
		        if (getTime < 60) {
		            return "��� ��";
		        } else if (getTime < 300) {
		            return "5�� ��";
		        } else if (getTime < 600) {
		            return "10�� ��";
		        } else if (getTime < 900) {
		            return "15�� ��";
		        } else if (getTime < 1200) {
		            return "20�� ��";
		        }else if (getTime < 1800) {
		            return "30�� ��";
		        } else if (getTime < 3600) {
		            return "1�ð� ��";
		        } else if (getTime < 43200) {
		            return "12�ð� ��";
		        } else if (getTime < 86400) {
		            return "1�� ��";
		        } else if (getTime < 172800) {
		            return "2�� ��";
		        } else if (getTime < 259200) {
		            return "3�� ��";
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

		// ���
		@Override
		public String toString() {
			return "PostVo [ id :" + id + ", content: "+ content+ ", createDate: " + createDate  + "imgfile: " + imgfile + "img1: " + img1 + " ]";
		}
		

}
