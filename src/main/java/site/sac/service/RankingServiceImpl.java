package site.sac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.sac.mapper.RankingMapper;

import java.util.List;

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
    public List<String> getPassionRanking() {
        List<String> list = rankingMapper.rankPassion();
        return list;
    }
}
