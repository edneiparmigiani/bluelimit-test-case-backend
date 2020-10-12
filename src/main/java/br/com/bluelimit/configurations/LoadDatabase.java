package br.com.bluelimit.configurations;

import br.com.bluelimit.entities.TagEntity;
import br.com.bluelimit.entities.TweetEntity;
import br.com.bluelimit.entities.UserEntity;
import br.com.bluelimit.repositories.TagRepository;
import br.com.bluelimit.repositories.TweetRepository;
import br.com.bluelimit.twetter.TwitterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.HashtagEntity;
import twitter4j.Status;

import java.util.*;

@Configuration
public class LoadDatabase {
    private Logger logger = LoggerFactory.getLogger(TwitterUtils.class);

    @Bean
    public CommandLineRunner initDatabase(TweetRepository tweetRepository, TagRepository tagRepository) {
        return args -> {
            List<String> hashs = new ArrayList<String>();
            //hashs.add("#openbanking");
            //hashs.add("#apifirst");
            //hashs.add("#devops");
            //hashs.add("#cloudfirst");
            //hashs.add("#microservices");
            //hashs.add("#apigateway");
            hashs.add("#oauth");
            hashs.add("#swagger");
            //hashs.add("#raml");
            //hashs.add("#openapis");

            TwitterUtils twitterUtils = new TwitterUtils();
            List<Status> statuses = twitterUtils.getStatusByHashtags(hashs);

            logger.info("load database started");
            for (Status s : statuses) {
                TweetEntity tweet = new TweetEntity();
                tweet.setId(s.getId());
                tweet.setCreatedAt(s.getCreatedAt());
                tweet.setUser(new UserEntity(s.getUser().getId(), String.format("@%s", s.getUser().getScreenName()), Long.valueOf(s.getUser().getFollowersCount()), s.getUser().getLang(), null));
                tweetRepository.save(tweet);

                HashtagEntity tags[] = s.getHashtagEntities();
                Arrays.stream(tags).filter(x -> hashs.contains("#" + x.getText().toLowerCase())).forEach(h -> {
                            TagEntity tagEntity = new TagEntity();
                            tagEntity.setId(1234l);
                            tagEntity.setTag(h.getText().toLowerCase());
                            tagEntity.setTweet(tweet);

                            tagRepository.save(tagEntity);
                        }
                );

            }
            logger.info("load database finished");
        };
    }

}
