package com.occu.mapper;

import java.util.List;
import com.occu.vo.PostVo;

public interface PostMapper {
	
	 // �Խù� �ۼ�
    void insertPost(PostVo postVo);

    // ��� �Խù� ��ȸ
    List<PostVo> selectAllPosts();

}
