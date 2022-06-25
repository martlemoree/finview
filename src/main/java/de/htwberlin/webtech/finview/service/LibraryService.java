package de.htwberlin.webtech.finview.service;

import de.htwberlin.webtech.finview.persistence.LibraryEntity;
import de.htwberlin.webtech.finview.persistence.LibraryRepository;
import de.htwberlin.webtech.finview.persistence.ProgrammingLanguage;
import de.htwberlin.webtech.finview.web.api.Library;
import de.htwberlin.webtech.finview.web.api.LibraryManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final LibraryTransformer libraryTransformer;

    public LibraryService(LibraryRepository libraryRepository, LibraryTransformer libraryTransformer) {
        this.libraryRepository = libraryRepository;
        this.libraryTransformer = libraryTransformer;
    }

    public List<Library> findAll() {
        List<LibraryEntity> libraries = libraryRepository.findAll();
        return libraries.stream()
                .map(libraryTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public Library findById(Long id) {
        var libraryEntity = libraryRepository.findById(id);
        return libraryEntity.map(libraryTransformer::transformEntity).orElse(null);
    }

    public Library create(LibraryManipulationRequest request) {
        var programmingLanguage = ProgrammingLanguage.valueOf(request.getProgrammingLanguage());
        var libraryEntity = new LibraryEntity(request.getLibraryName(), programmingLanguage, request.getLatestVersion(), request.getUseField(), request.getWebsite(), request.getUpvotes(), request.getDownvotes(), request.getCreatedAt(), request.getUpdatedAt());
        libraryEntity = libraryRepository.save(libraryEntity);
        return libraryTransformer.transformEntity(libraryEntity);
    }

    public Library update(Long id, LibraryManipulationRequest request) {
        var libraryEntityOptional = libraryRepository.findById(id);
        if (libraryEntityOptional.isEmpty()) {
            return null;
        }

        var libraryEntity = libraryEntityOptional.get();
        libraryEntity.setLibraryName(request.getLibraryName());
        libraryEntity.setProgrammingLanguage(ProgrammingLanguage.valueOf(request.getProgrammingLanguage()));
        libraryEntity.setLatestVersion(request.getLatestVersion());
        libraryEntity.setUseField(request.getUseField());
        libraryEntity.setWebsite(request.getWebsite());
        libraryEntity.setUpvotes(request.getUpvotes());
        libraryEntity.setDownvotes(request.getDownvotes());
        libraryEntity.setCreatedAt(request.getCreatedAt());
        libraryEntity.setUpdatedAt(request.getUpdatedAt());
        libraryEntity = libraryRepository.save(libraryEntity);

        return libraryTransformer.transformEntity(libraryEntity);
    }

    public boolean deleteById(Long id) {
        if (!libraryRepository.existsById(id)) {
            return false;
        }

        libraryRepository.deleteById(id);
        return true;
    }
}
