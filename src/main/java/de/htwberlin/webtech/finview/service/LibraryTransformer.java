package de.htwberlin.webtech.finview.service;

import de.htwberlin.webtech.finview.persistence.LibraryEntity;
import de.htwberlin.webtech.finview.persistence.ProgrammingLanguage;
import de.htwberlin.webtech.finview.persistence.ProjectEntity;
import de.htwberlin.webtech.finview.web.api.Library;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class LibraryTransformer {

    public Library transformEntity(LibraryEntity libraryEntity) {
        var programmingLanguage = libraryEntity.getProgrammingLanguage() != null ? libraryEntity.getProgrammingLanguage().name() : ProgrammingLanguage. OTHER.name();
        var projectIds = libraryEntity.getProjects().stream().map(ProjectEntity::getId).collect(Collectors.toList());
        return new Library(
                libraryEntity.getId(),
                libraryEntity.getLibraryName(),
                programmingLanguage,
                libraryEntity.getLatestVersion(),
                libraryEntity.getUseField(),
                projectIds);
    }
}
