package de.htwberlin.webtech.finview.web.api;

public class ProjectManipulationRequest {

    private String projectName;
    private String githubRepository;

    public ProjectManipulationRequest(String projectName, String githubRepository) {
        this.projectName = projectName;
        this.githubRepository = githubRepository;
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
}
