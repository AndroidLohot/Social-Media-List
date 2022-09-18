package com.example.socialmedialist;

import java.io.Serializable;

public class WebSite implements Serializable {

    private String siteImage;
    private String siteName;

    public WebSite() {
    }

    public WebSite(String siteName) {
        this.siteName = siteName;
    }

    public WebSite(String siteImage, String siteName) {
        this.siteImage = siteImage;
        this.siteName = siteName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteImage() {
        return siteImage;
    }

    public void setSiteImage(String siteImage) {
        this.siteImage = siteImage;
    }
}
