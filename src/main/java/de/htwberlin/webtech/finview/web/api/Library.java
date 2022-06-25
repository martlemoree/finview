package de.htwberlin.webtech.finview.web.api;

import java.util.Date;
import java.util.Set;

public class Library {

    private long id;
    private String libraryName;
    private String programmingLanguage;
    private String latestVersion;
    private String useField;
    private String website;
    private int upvotes;
    private int downvotes;
    private Date createdAt;
    private Date updatedAt;
    private Set<Long> projectIds;
    private Set<Long> installIds;

    public Library(long id, String libraryName, String programmingLanguage, String latestVersion, String useField, String website, int upvotes, int downvotes, Date createdAt, Date updatedAt, Set<Long> projectIds, Set<Long> installIds) {
        this.id = id;
        this.libraryName = libraryName;
        this.programmingLanguage = programmingLanguage;
        this.latestVersion = latestVersion;
        this.useField = useField;
        this.website = website;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.projectIds = projectIds;
        this.installIds = installIds;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getLatestVersion() {
        return latestVersion;
    }

    public void setLatestVersion(String latestVersion) {
        this.latestVersion = latestVersion;
    }

    public String getUseField() {
        return useField;
    }

    public void setUseField(String useField) {
        this.useField = useField;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<Long> getProjectIds() {
        return projectIds;
    }

    public void setProjectIds(Set<Long> projectIds) {
        this.projectIds = projectIds;
    }

    public Set<Long> getInstallIds() {
        return installIds;
    }

    public void setInstallIds(Set<Long> installIds) {
        this.installIds = installIds;
    }
}
