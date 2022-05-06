package de.htwberlin.webtech.finview.web;

import de.htwberlin.webtech.finview.service.InvestService;
import de.htwberlin.webtech.finview.web.api.Invest;
import de.htwberlin.webtech.finview.web.api.InvestManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class InvestRestController {

    private final InvestService investService;

    public InvestRestController(InvestService investService) {
        this.investService = investService;
    }

    @GetMapping(path = "/api/v1/invests")
    public ResponseEntity<List<Invest>> fetchInvests() {
        return ResponseEntity.ok(investService.findAll());
    }

    @GetMapping(path = "/api/v1/invests/{id}")
    public ResponseEntity<Invest> fetchInvestById(@PathVariable Long id) {
        var invest = investService.findById(id);
        return invest != null? ResponseEntity.ok(invest) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/invests")
    public ResponseEntity<Void> createInvest(@RequestBody InvestManipulationRequest request) throws URISyntaxException {
        var invest = investService.create(request);
        URI uri = new URI("/api/v1/invests/" + invest.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/invests/{id}")
    public ResponseEntity<Invest> updateInvest(@PathVariable Long id, @RequestBody InvestManipulationRequest request) {
        var invest = investService.update(id, request);
        return invest != null? ResponseEntity.ok(invest) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path ="/api/v1/invests/{id}")
    public ResponseEntity<Void> deleteInvest(@PathVariable Long id) {
        boolean successful = investService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
