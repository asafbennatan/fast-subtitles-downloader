package com.asaf.response;

public class RelatedLink {

    /**
     *  {
     *                         "label": "All subtitles for Tv Show The Mindy Project",
     *                         "url": "https://www.opensubtitles.com/en/features/redirect/12415",
     *                         "img_url": "https://s9.opensubtitles.com/features/9/9/8/41899.jpg"
     *                     }
     */

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
