package de.htwberlin.webtech.finview.web.api;

public class Library {

    private long id;
    private String libraryName;
    private String programmingLanguage;
    private String latestVersion;
    private String useField;

    public Library(long id, String libraryName, String programmingLanguage, String latestVersion, String useField) {
        this.id = id;
        this.libraryName = libraryName;
        this.programmingLanguage = programmingLanguage;
        this.latestVersion = latestVersion;
        this.useField = useField;
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
}
