package de.htwberlin.webtech.finview.service;

import de.htwberlin.webtech.finview.persistence.InvestEntity;
import de.htwberlin.webtech.finview.persistence.InvestRepository;
import de.htwberlin.webtech.finview.web.api.Invest;
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
                .map(investEntity -> new Invest(
                        investEntity.getId(),
                        investEntity.getInvestName(),
                        investEntity.getInvestType(),
                        investEntity.getPurchaseValue(),
                        investEntity.getQuantity(),
                        investEntity.getCurrentValue()
                ))
                .collect(Collectors.toList());
    }
}
