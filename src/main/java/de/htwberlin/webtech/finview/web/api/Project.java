package de.htwberlin.webtech.finview.web.api;

public class Project {

    private Long id;
    private String projectName;
    private String githubRepository;
    private Library library;

    public Project(Long id, String projectName, String githubRepository, Library library) {
        this.id = id;
        this.projectName = projectName;
        this.githubRepository = githubRepository;
        this.library = library;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
