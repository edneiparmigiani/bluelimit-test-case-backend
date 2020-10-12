package br.com.bluelimit.vo;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class UserTopFiveWithMoreFollowersVO {
    private Long id;
    private String screenName;
    private Long followers;
}
