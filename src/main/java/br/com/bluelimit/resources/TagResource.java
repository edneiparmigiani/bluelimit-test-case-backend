package br.com.bluelimit.resources;

import br.com.bluelimit.repositories.TagRepository;
import br.com.bluelimit.vo.TweetByTagByUserIdiomVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagResource {

    @Autowired
    private TagRepository tagRepository;

    @Operation(description = "Total de postagens agrupadas por Hora do dia", tags = {"v1"})
    @ApiResponses(value = {
            @ApiResponse(description = "Sucesso", responseCode = "200")
    })
    @RequestMapping(value = "/twee-tag", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<TweetByTagByUserIdiomVO>> getTags() {
        List<TweetByTagByUserIdiomVO> tags = tagRepository.listTweetAmountByTagsByUser();
        return new ResponseEntity<List<TweetByTagByUserIdiomVO>>(tags, HttpStatus.OK);
    }

}
