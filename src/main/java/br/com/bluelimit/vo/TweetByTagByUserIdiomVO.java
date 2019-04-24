package br.com.bluelimit.vo;

import br.com.bluelimit.resources.TagResource;
import lombok.*;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
public class TweetByTagByUserIdiomVO extends ResourceSupport {
    private Long tweets;
    private String hastTag;
    private String idiom;

    public TweetByTagByUserIdiomVO(Long tweets, String hastTag, String idiom) {
        this.tweets = tweets;
        this.hastTag = String.format("#%s", hastTag);
        this.idiom = idiom;
    }
}
