package de.htwberlin.webtech.finview.persistence;

import javax.persistence.*;

@Entity(name = "projects")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    @Column(name = "github_repository")
    private String githubRepository;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "library_id", referencedColumnName = "library_id")
    private LibraryEntity library;

    public ProjectEntity() {
    }

    public ProjectEntity(String projectName, String githubRepository, LibraryEntity library) {
        this.projectName = projectName;
        this.githubRepository = githubRepository;
        this.library = library;
    }

    public Long getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getGithubRepository() {
        return githubRepository;
    }

    public void setGithubRepository(String githubRepository) {
        this.githubRepository = githubRepository;
    }

    public LibraryEntity getLibrary() {
        return library;
    }

    public void setLibrary(LibraryEntity library) {
        this.library = library;
    }
}
