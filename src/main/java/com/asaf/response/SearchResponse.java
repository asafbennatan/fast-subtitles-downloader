package com.asaf.response;

import java.util.List;

public class SearchResponse<E extends Data> {
    private int total_pages;
    private int total_count;
    private int page;
    private int per_page;
    private List<E> data;


    public int getTotal_pages() {
        return total_pages;
    }

    public <T extends SearchResponse> T setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
        return (T) this;
    }

    public int getTotal_count() {
        return total_count;
    }

    public <T extends SearchResponse> T setTotal_count(int total_count) {
        this.total_count = total_count;
        return (T) this;
    }

    public int getPage() {
        return page;
    }

    public <T extends SearchResponse> T setPage(int page) {
        this.page = page;
        return (T) this;
    }

    public int getPer_page() {
        return per_page;
    }

    public <T extends SearchResponse> T setPer_page(int per_page) {
        this.per_page = per_page;
        return (T) this;
    }

    public List<E> getData() {
        return data;
    }

    public <T extends SearchResponse> T setData(List<E> data) {
        this.data = data;
        return (T) this;
    }
}
