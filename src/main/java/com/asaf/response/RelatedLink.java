package com.asaf.response;

public class RelatedLink {

    private String label;
    private String url;
    private String img_url;

    public String getLabel() {
        return label;
    }

    public <T extends RelatedLink> T setLabel(String label) {
        this.label = label;
        return (T) this;
    }

    public String getUrl() {
        return url;
    }

    public <T extends RelatedLink> T setUrl(String url) {
        this.url = url;
        return (T) this;
    }

    public String getImg_url() {
        return img_url;
    }

    public <T extends RelatedLink> T setImg_url(String img_url) {
        this.img_url = img_url;
        return (T) this;
    }
}
