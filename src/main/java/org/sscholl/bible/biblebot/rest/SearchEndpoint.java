package org.sscholl.bible.biblebot.rest;

import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sscholl.bible.common.model.dto.BookDTO;
import org.sscholl.bible.common.model.dto.PassageDTO;
import org.sscholl.bible.common.service.BibleCsvRepository;
import org.sscholl.bible.common.service.QueryParserService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Component
@Path("/search")
public class SearchEndpoint {

    @Autowired
    private BibleCsvRepository bibleCsvRepository;

    @Autowired
    private QueryParserService queryParserService;

    @GET
    @Path("/{query}")
    @Produces(MediaType.TEXT_HTML + ";charset=utf-8")
    public String get(@PathParam("query") String query) {
        StringBuilder response = new StringBuilder();
        for (PassageDTO passageDTO : queryParserService.process(query)) {
            response.append(passageDTO.toString()).append("<br/><br/>");
        }
        return response.toString();
    }

    @GET
    @Path("/keywords")
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String keywords() {
        StringBuilder response = new StringBuilder();
        response.append("b:,bible:,bibel:");
        response.append("!b ,!bible ,!bibel ");
        for (BookDTO bookDTO : bibleCsvRepository.findBible(bibleCsvRepository.getDefaultBible()).getBooks()) {
            for (String shortcut : bookDTO.getShortcuts()) {
                response.append(",").append(shortcut);
            }
        }
        for (BookDTO bookDTO : bibleCsvRepository.findBible(bibleCsvRepository.getDefaultBible()).getBooks()) {
            for (String shortcut : bookDTO.getShortcuts()) {
                response.append(",").append(WordUtils.capitalize(shortcut));

            }
        }
        return response.toString();
    }

}