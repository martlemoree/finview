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

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Library> findAll() {
        List<LibraryEntity> libraries = libraryRepository.findAll();
        return libraries.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Library findById(Long id) {
        var libraryEntity = libraryRepository.findById(id);
        return libraryEntity.map(this::transformEntity).orElse(null);
    }

    public Library create(LibraryManipulationRequest request) {
        var programmingLanguage = ProgrammingLanguage.valueOf(request.getProgrammingLanguage());
        var libraryEntity = new LibraryEntity(request.getLibraryName(), programmingLanguage, request.getLatestVersion(), request.getUseField());
        libraryEntity = libraryRepository.save(libraryEntity);
        return transformEntity(libraryEntity);
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
        libraryEntity = libraryRepository.save(libraryEntity);

        return transformEntity(libraryEntity);
    }

    public boolean deleteById(Long id) {
        if (!libraryRepository.existsById(id)) {
            return false;
        }

        libraryRepository.deleteById(id);
        return true;
    }

    private Library transformEntity(LibraryEntity libraryEntity) {
        var programmingLanguage = libraryEntity.getProgrammingLanguage() != null ? libraryEntity.getProgrammingLanguage().name() : ProgrammingLanguage. OTHER.name();
        return new Library(
                libraryEntity.getId(),
                libraryEntity.getLibraryName(),
                programmingLanguage,
                libraryEntity.getLatestVersion(),
                libraryEntity.getUseField()
        );
    }
}
