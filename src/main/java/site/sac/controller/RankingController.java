package site.sac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.sac.service.RankingService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ranking")
public class RankingController {
    @Autowired
    private RankingService rankingService;

    @GetMapping("/topic")
    public ResponseEntity<List<String>> getTopicRanking() throws DataAccessException {
        List<String> result = rankingService.getTopicRanking();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/passion")
    public ResponseEntity<Map<String, Object>> getPassionRankingt() throws DataAccessException, NullPointerException {
        Map<String, Object> result = rankingService.getPassionRanking();
        return ResponseEntity.status(200).body(result);
    }
}
