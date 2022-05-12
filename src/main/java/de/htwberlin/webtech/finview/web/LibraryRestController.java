package de.htwberlin.webtech.finview.web;

import de.htwberlin.webtech.finview.service.LibraryService;
import de.htwberlin.webtech.finview.web.api.Library;
import de.htwberlin.webtech.finview.web.api.LibraryManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class LibraryRestController {

    private final LibraryService libraryService;

    public LibraryRestController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping(path = "/api/v1/libraries")
    public ResponseEntity<List<Library>> fetchLibraries() {
        return ResponseEntity.ok(libraryService.findAll());
    }

    @GetMapping(path = "/api/v1/libraries/{id}")
    public ResponseEntity<Library> fetchLibraryById(@PathVariable Long id) {
        var library = libraryService.findById(id);
        return library != null? ResponseEntity.ok(library) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/libraries")
    public ResponseEntity<Void> createLibrary(@RequestBody LibraryManipulationRequest request) throws URISyntaxException {
        var library = libraryService.create(request);
        URI uri = new URI("/api/v1/libraries/" + library.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/libraries/{id}")
    public ResponseEntity<Library> updateLibrary(@PathVariable Long id, @RequestBody LibraryManipulationRequest request) {
        var library = libraryService.update(id, request);
        return library != null? ResponseEntity.ok(library) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path ="/api/v1/libraries/{id}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable Long id) {
        boolean successful = libraryService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
