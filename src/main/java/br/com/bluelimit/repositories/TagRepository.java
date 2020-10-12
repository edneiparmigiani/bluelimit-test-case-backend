package br.com.bluelimit.repositories;

import br.com.bluelimit.entities.TagEntity;
import br.com.bluelimit.vo.TweetByTagByUserIdiomVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, String> {
    @Query("SELECT new br.com.bluelimit.vo.TweetByTagByUserIdiomVO(count(tag.tweet), tag.tag, tag.tweet.user.idiom) " +
            "FROM TagEntity tag GROUP BY tag.tag, tag.tweet.user.idiom ORDER BY 1, tag.tweet.user.idiom")
    public List<TweetByTagByUserIdiomVO> listTweetAmountByTagsByUser();
}