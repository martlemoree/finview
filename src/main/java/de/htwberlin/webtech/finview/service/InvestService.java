package de.htwberlin.webtech.finview.service;

import de.htwberlin.webtech.finview.persistence.InvestEntity;
import de.htwberlin.webtech.finview.persistence.InvestRepository;
import de.htwberlin.webtech.finview.web.api.Invest;
import de.htwberlin.webtech.finview.web.api.InvestManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvestService {

    private final InvestRepository investRepository;

    public InvestService(InvestRepository investRepository) {
        this.investRepository = investRepository;
    }

    public List<Invest> findAll() {
        List<InvestEntity> invests = investRepository.findAll();
        return invests.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Invest findById(Long id) {
        var investEntity = investRepository.findById(id);
        return investEntity.map(this::transformEntity).orElse(null);
    }

    public Invest create(InvestManipulationRequest request) {
        var investEntity = new InvestEntity(request.getInvestName(), request.getInvestType(), request.getPurchaseValue(), request.getQuantity(), request.getCurrentValue());
        investEntity = investRepository.save(investEntity);
        return transformEntity(investEntity);
    }

    public Invest update(Long id, InvestManipulationRequest request) {
        var investEntityOptional = investRepository.findById(id);
        if (investEntityOptional.isEmpty()) {
            return null;
        }

        var investEntity = investEntityOptional.get();
        investEntity.setInvestName(request.getInvestName());
        investEntity.setInvestType(request.getInvestType());
        investEntity.setPurchaseValue(request.getPurchaseValue());
        investEntity.setQuantity(request.getQuantity());
        investEntity.setCurrentValue(request.getCurrentValue());
        investEntity = investRepository.save(investEntity);

        return transformEntity(investEntity);
    }

    public boolean deleteById(Long id) {
        if (!investRepository.existsById(id)) {
            return false;
        }

        investRepository.deleteById(id);
        return true;
    }

    private Invest transformEntity(InvestEntity investEntity) {
        return new Invest(
                investEntity.getId(),
                investEntity.getInvestName(),
                investEntity.getInvestType(),
                investEntity.getPurchaseValue(),
                investEntity.getQuantity(),
                investEntity.getCurrentValue()
        );
    }
}
