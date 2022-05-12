package de.htwberlin.webtech.finview.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryEntity, Long> {

    List<LibraryEntity> findAllByLibraryName(String libraryName);
}
