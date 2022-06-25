package de.htwberlin.webtech.finview.web;

import de.htwberlin.webtech.finview.service.InstallService;
import de.htwberlin.webtech.finview.web.api.Install;
import de.htwberlin.webtech.finview.web.api.InstallManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class InstallRestController {

    private final InstallService installService;

    public InstallRestController(InstallService installService) { this.installService = installService; }

    @GetMapping(path = "/api/v1/installs")
    public ResponseEntity<List<Install>> fetchInstalls() {
        return ResponseEntity.ok(installService.findAll());
    }

    @PostMapping(path = "/api/v1/installs")
    public ResponseEntity<Void> createInstall(@RequestBody InstallManipulationRequest request) throws URISyntaxException {
        var install = installService.create(request);
        URI uri = new URI("/api/v1/installs/" + install.getId());
        return ResponseEntity.created(uri).build();
    }
}
