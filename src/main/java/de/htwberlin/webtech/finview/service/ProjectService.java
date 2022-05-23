package de.htwberlin.webtech.finview.service;

import de.htwberlin.webtech.finview.persistence.LibraryRepository;
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
    private final LibraryRepository libraryRepository;
    private final LibraryTransformer libraryTransformer;

    public ProjectService(ProjectRepository projectRepository, LibraryRepository libraryRepository, LibraryTransformer libraryTransformer) {
        this.projectRepository = projectRepository;
        this.libraryRepository = libraryRepository;
        this.libraryTransformer = libraryTransformer;
    }

    public List<Project> findAll() {
        List<ProjectEntity> projects = projectRepository.findAll();
        return projects.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Project create(ProjectManipulationRequest request) {
        var library = libraryRepository.findById(request.getLibraryId()).orElseThrow();
        var projectEntity = new ProjectEntity(request.getProjectName(), request.getGithubRepository(), library);
        projectEntity = projectRepository.save(projectEntity);
        return transformEntity(projectEntity);
    }

    private Project transformEntity(ProjectEntity projectEntity) {
        return new Project(
                projectEntity.getId(),
                projectEntity.getProjectName(),
                projectEntity.getGithubRepository(),
                libraryTransformer.transformEntity(projectEntity.getLibrary()));
    }
}
