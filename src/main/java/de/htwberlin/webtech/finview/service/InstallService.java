package de.htwberlin.webtech.finview.service;

import de.htwberlin.webtech.finview.persistence.LibraryRepository;
import de.htwberlin.webtech.finview.persistence.InstallEntity;
import de.htwberlin.webtech.finview.persistence.InstallRepository;
import de.htwberlin.webtech.finview.persistence.OperatingSystem;
import de.htwberlin.webtech.finview.web.api.Install;
import de.htwberlin.webtech.finview.web.api.InstallManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstallService {

    private final InstallRepository installRepository;
    private final LibraryRepository libraryRepository;
    private final LibraryTransformer libraryTransformer;

    public InstallService(InstallRepository installRepository, LibraryRepository libraryRepository, LibraryTransformer libraryTransformer) {
        this.installRepository = installRepository;
        this.libraryRepository = libraryRepository;
        this.libraryTransformer = libraryTransformer;
    }

    public List<Install> findAll() {
        List<InstallEntity> installs = installRepository.findAll();
        return installs.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Install create(InstallManipulationRequest request) {
        var operatingSystem = OperatingSystem.valueOf(request.getOperatingSystem());
        var library = libraryRepository.findById(request.getLibraryId()).orElseThrow();
        var installEntity = new InstallEntity(request.getCommand(), operatingSystem, request.getPackageManager(), library);
        installEntity = installRepository.save(installEntity);
        return transformEntity(installEntity);
    }

    private Install transformEntity(InstallEntity installEntity) {
        var operatingSystem = installEntity.getOperatingSystem() != null ? installEntity.getOperatingSystem().name() : OperatingSystem. other.name();
        return new Install(
                installEntity.getId(),
                installEntity.getCommand(),
                operatingSystem,
                installEntity.getPackageManager(),
                libraryTransformer.transformEntity(installEntity.getLibrary()));
    }
}
