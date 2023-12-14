package site.sac.service;

import java.util.List;
import java.util.Map;

public interface RankingService {
    List<String> getTopicRanking();
    Map<String, Object> getPassionRanking();
}
