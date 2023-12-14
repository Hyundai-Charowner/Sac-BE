package site.sac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.sac.service.RankingService;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {
    @Autowired
    private RankingService rankingService;

    @GetMapping("/topic")
    public ResponseEntity<List<String>> getTopicRanking() throws DataAccessException {
        List<String> result = rankingService.getTopicRanking();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/passion")
    public ResponseEntity<List<String>> getPassionRankingt() throws DataAccessException, NullPointerException {
        List<String> result = rankingService.getPassionRanking();
        return ResponseEntity.status(200).build();
    }
}
