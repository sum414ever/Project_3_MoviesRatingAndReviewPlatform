package edu.curssor.moviesPlatform.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.curssor.moviesPlatform.enums.Category;
import lombok.Data;

@Data
public class Movie {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String id;

    private String name;

    private String categoryLabel;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Category category;

    private String director;

    private String description;

    private Rate rate;
}
