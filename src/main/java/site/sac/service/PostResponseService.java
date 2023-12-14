package site.sac.service;

import java.util.Map;

public interface PostResponseService {

    Map<String,Object> getPagingPost(long pageNum);
}
