package com.occu.mapper;

import java.util.List;
import com.occu.vo.PostVo;

public interface PostMapper {
	
	 // 게시물 작성
    void insertPost(PostVo postVo);

    // 모든 게시물 조회
    List<PostVo> selectAllPosts();

}
