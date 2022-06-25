package de.htwberlin.webtech.finview.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstallRepository extends JpaRepository<InstallEntity, Long> {
}
