package com.Movies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    @JsonProperty("poster_path")
    String posterPath;
    String title;
    String overview;
    double popularity;

    public Movie() {
    }

    public Movie(String posterPath, String title, String overview, double popularity) {
        this.posterPath = posterPath;
        this.title = title;
        this.overview = overview;
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return "Movie{" +
            "posterPath='" + posterPath + '\'' +
            ", title='" + title + '\'' +
            ", overview='" + overview + '\'' +
            ", popularity=" + popularity +
            '}';
    }
}
