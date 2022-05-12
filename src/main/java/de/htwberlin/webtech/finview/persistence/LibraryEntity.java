package de.htwberlin.webtech.finview.persistence;

import javax.persistence.*;

@Entity(name = "libraries")
public class LibraryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "library_id")
    private long id;

    @Column(name = "library_name", nullable = false)
    private String libraryName;

    @Column(name = "programming_language")
    @Enumerated(value = EnumType.STRING)
    private ProgrammingLanguage programmingLanguage;

    @Column(name = "latest_version")
    private String latestVersion;

    @Column(name = "use_field")
    private String useField;

    public LibraryEntity(String libraryName, ProgrammingLanguage programmingLanguage, String latestVersion, String useField) {
        this.libraryName = libraryName;
        this.programmingLanguage = programmingLanguage;
        this.latestVersion = latestVersion;
        this.useField = useField;
    }

    protected LibraryEntity() {}

    public Long getId() {
        return id;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public ProgrammingLanguage getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
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
