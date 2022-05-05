package de.htwberlin.webtech.finview.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestRepository extends JpaRepository<InvestEntity, Long> {

    List<InvestEntity> findAllByInvestName(String investName);
}
