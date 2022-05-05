package de.htwberlin.webtech.finview.web;

import de.htwberlin.webtech.finview.service.InvestService;
import de.htwberlin.webtech.finview.web.api.Invest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
