package de.htwberlin.webtech.finview.web.api;

public class ProjectManipulationRequest {

    private String projectName;
    private String githubRepository;
    private Long libraryId;

    public ProjectManipulationRequest(String projectName, String githubRepository, Long libraryId) {
        this.projectName = projectName;
        this.githubRepository = githubRepository;
        this.libraryId = libraryId;
    }

    public ProjectManipulationRequest() {}

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

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }
}
