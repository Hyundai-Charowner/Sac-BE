package site.sac.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.sac.mapper.RankingMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Service
public class RankingServiceImpl implements RankingService{

    @Autowired
    private RankingMapper rankingMapper;
    @Override
    public List<String> getTopicRanking() {
        List<String> list = rankingMapper.rankTopic();
        return list;
    }

    @Override
    public Map<String, Object> getPassionRanking() {
        log.info("---");
        List<Map<String,Object>> list = rankingMapper.rankPassion();
        Map<String, Object> result = new HashMap<>();
        result.put("user", list);
        return result;
    }
}
