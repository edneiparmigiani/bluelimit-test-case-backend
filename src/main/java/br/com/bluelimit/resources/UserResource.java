package br.com.bluelimit.resources;

import br.com.bluelimit.entities.UserEntity;
import br.com.bluelimit.repositories.UserRepository;
import br.com.bluelimit.twetter.TwitterUtils;
import br.com.bluelimit.vo.UserTopFiveWithMoreFollowersVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserResource {
    private Logger logger = LoggerFactory.getLogger(TwitterUtils.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserRepository userRepository;

    //@ApiOperation(value = "Retorna os 5 Usuários com mais seguidores")
    @RequestMapping(value = "/user-top-five", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UserTopFiveWithMoreFollowersVO>> getFiveUsersWithMoreFollowers() {
        List<UserEntity> users = userRepository.findTop5ByOrderByFollowersDesc();

        List<UserTopFiveWithMoreFollowersVO> usersVO = new ArrayList<>();
        users.forEach(u ->
                usersVO.add(new UserTopFiveWithMoreFollowersVO(u.getId(), u.getScreenName(), u.getFollowers()))
        );

        logger.info(String.format("resource [/user-top-five] has been accessed [remoteAddr: %s]", request.getRemoteAddr()));
        return new ResponseEntity<List<UserTopFiveWithMoreFollowersVO>>(usersVO, HttpStatus.OK);
    }

}