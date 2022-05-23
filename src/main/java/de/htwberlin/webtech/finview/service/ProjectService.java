package de.htwberlin.webtech.finview.service;

import de.htwberlin.webtech.finview.persistence.ProjectEntity;
import de.htwberlin.webtech.finview.persistence.ProjectRepository;
import de.htwberlin.webtech.finview.web.api.Project;
import de.htwberlin.webtech.finview.web.api.ProjectManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll() {
        List<ProjectEntity> projects = projectRepository.findAll();
        return projects.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Project create(ProjectManipulationRequest request) {
        var projectEntity = new ProjectEntity(request.getProjectName(), request.getGithubRepository());
        projectEntity = projectRepository.save(projectEntity);
        return transformEntity(projectEntity);
    }

    private Project transformEntity(ProjectEntity projectEntity) {
        return new Project(
                projectEntity.getId(),
                projectEntity.getProjectName(),
                projectEntity.getGithubRepository()
        );
    }
}
