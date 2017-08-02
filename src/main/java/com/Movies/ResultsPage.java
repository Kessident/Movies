package com.Movies;

import java.util.List;

public class ResultsPage {

    List<Movie> results;

    public ResultsPage() {
    }
    public ResultsPage(List<Movie> results) {
        this.results = results;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
