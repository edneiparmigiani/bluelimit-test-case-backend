package br.com.bluelimit.repositories;

import br.com.bluelimit.entities.TweetEntity;
import br.com.bluelimit.vo.TweetCountByHourOfDayVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<TweetEntity, Long> {
    @Query("SELECT new br.com.bluelimit.vo.TweetCountByHourOfDayVO(count (1), YEAR(t.createdAt), MONTH(t.createdAt), DAY(t.createdAt), HOUR(t.createdAt)) " +
            "FROM TweetEntity t GROUP BY YEAR(t.createdAt), MONTH(t.createdAt), DAY(t.createdAt), HOUR(t.createdAt) " +
            "ORDER BY YEAR(t.createdAt), MONTH(t.createdAt), DAY(t.createdAt), HOUR(t.createdAt)")
    public List<TweetCountByHourOfDayVO> listTweetCountByHourOfDay();
}