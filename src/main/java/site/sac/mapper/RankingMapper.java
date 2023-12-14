package site.sac.mapper;

import java.util.List;
import java.util.Map;

public interface RankingMapper {
    List<String> rankTopic();

    List<Map<String,Object>> rankPassion();
}
