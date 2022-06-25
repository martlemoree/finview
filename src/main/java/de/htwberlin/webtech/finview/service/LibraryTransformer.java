package de.htwberlin.webtech.finview.service;

import de.htwberlin.webtech.finview.persistence.InstallEntity;
import de.htwberlin.webtech.finview.persistence.LibraryEntity;
import de.htwberlin.webtech.finview.persistence.ProgrammingLanguage;
import de.htwberlin.webtech.finview.persistence.ProjectEntity;
import de.htwberlin.webtech.finview.web.api.Library;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class LibraryTransformer {

    public Library transformEntity(LibraryEntity libraryEntity) {
        var programmingLanguage = libraryEntity.getProgrammingLanguage() != null ? libraryEntity.getProgrammingLanguage().name() : ProgrammingLanguage. other.name();
        var projectIds = libraryEntity.getProjects().stream().map(ProjectEntity::getId).collect(Collectors.toSet());
        var installIds = libraryEntity.getInstalls().stream().map(InstallEntity::getId).collect(Collectors.toSet());
        return new Library(
                libraryEntity.getId(),
                libraryEntity.getLibraryName(),
                programmingLanguage,
                libraryEntity.getLatestVersion(),
                libraryEntity.getUseField(),
                libraryEntity.getWebsite(),
                libraryEntity.getUpvotes(),
                libraryEntity.getDownvotes(),
                libraryEntity.getCreatedAt(),
                libraryEntity.getUpdatedAt(),
                projectIds,
                installIds);
    }
}
