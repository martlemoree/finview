package de.htwberlin.webtech.finview.web.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class LibraryManipulationRequest {

    @NotBlank(message = "The Library Name cannot be empty.")
    private String libraryName;

    @Pattern(
            regexp = "JavaScript|Python|Java|PHP|CSS|CSharp|CPlusPlus|TypeScript|Ruby|C|Swift|R|ObjectiveC|Shell|Scala|Go|PowerShell|Kotlin|Rust|Dart|other",
            message = "Please select a known programming language or choose 'other'."
    )
    private String programmingLanguage;

    @NotBlank(message = "The latest version cannot be empty.")
    private String latestVersion;

    @Size(min=5, message = "Please give a little bit more detailed field of use. At least a minimum of 5 characters.")
    private String useField;

    private String website;

    private int upvotes;

    private int downvotes;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    public LibraryManipulationRequest(String libraryName, String programmingLanguage, String latestVersion, String useField, String website, int upvotes, int downvotes, Timestamp createdAt, Timestamp updatedAt) {
        this.libraryName = libraryName;
        this.programmingLanguage = programmingLanguage;
        this.latestVersion = latestVersion;
        this.useField = useField;
        this.website = website;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public LibraryManipulationRequest() {}

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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
