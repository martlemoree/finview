package de.htwberlin.webtech.finview.web;

import de.htwberlin.webtech.finview.service.ProjectService;
import de.htwberlin.webtech.finview.web.api.Project;
import de.htwberlin.webtech.finview.web.api.ProjectManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ProjectRestController {

    private final ProjectService projectService;

    public ProjectRestController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(path = "/api/v1/projects")
    public ResponseEntity<List<Project>> fetchProjects() {
        return ResponseEntity.ok(projectService.findAll());
    }

    @PostMapping(path = "/api/v1/projects")
    public ResponseEntity<Void> createProject(@RequestBody ProjectManipulationRequest request) throws URISyntaxException {
        var project = projectService.create(request);
        URI uri = new URI("/api/v1/projects/" + project.getId());
        return ResponseEntity.created(uri).build();
    }
}
