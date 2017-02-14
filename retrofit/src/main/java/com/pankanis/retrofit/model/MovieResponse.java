package com.pankanis.retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sumit.ingewar on 2/13/2017.
 */

public class MovieResponse {

    @SerializedName("page")
    private String page;

    @SerializedName("results")
    private List<MovieModel> results;

    @SerializedName("total_results")
    private int totalResults;

    @SerializedName("total_pages")
    private int totalPages;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<MovieModel> getResults() {
        return results;
    }

    public void setResults(List<MovieModel> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
