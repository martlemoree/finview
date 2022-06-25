package de.htwberlin.webtech.finview.persistence;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "latest_version", nullable = false)
    private String latestVersion;

    @Column(name = "use_field")
    private String useField;

    @Column(name = "website")
    private String website;

    @Column(name = "upvotes", columnDefinition = "integer default 0")
    private int upvotes;

    @Column(name = "downvotes", columnDefinition = "integer default 0")
    private int downvotes;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "library", fetch = FetchType.EAGER)
    private Set<ProjectEntity> projects = new HashSet<>();

    @OneToMany(mappedBy = "library", fetch = FetchType.EAGER)
    private Set<InstallEntity> installs = new HashSet<>();

    public LibraryEntity(String libraryName, ProgrammingLanguage programmingLanguage, String latestVersion, String useField, String website, int upvotes, int downvotes, Timestamp createdAt, Timestamp updatedAt) {
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

    public Set<ProjectEntity> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProjectEntity> projects) {
        this.projects = projects;
    }

    public Set<InstallEntity> getInstalls() {
        return installs;
    }

    public void setInstalls(Set<InstallEntity> installs) {
        this.installs = installs;
    }
}
