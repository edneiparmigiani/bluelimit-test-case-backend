package br.com.bluelimit.resources;

import br.com.bluelimit.repositories.TweetRepository;
import br.com.bluelimit.vo.TweetCountByHourOfDayVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TweetResource {

    @Autowired
    private TweetRepository tweetRepository;

    //@ApiOperation(value = "Retorna a quantidade de Postagens por Hora do dia")
    @RequestMapping(value = "/tweet-group-hours", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<TweetCountByHourOfDayVO>> getTweetCountByHourOfDay() {
        List<TweetCountByHourOfDayVO> tweets = tweetRepository.listTweetCountByHourOfDay();
        return new ResponseEntity<List<TweetCountByHourOfDayVO>>(tweets, HttpStatus.OK);
    }

}
