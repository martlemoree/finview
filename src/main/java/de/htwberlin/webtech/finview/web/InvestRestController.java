package de.htwberlin.webtech.finview.web;

import de.htwberlin.webtech.finview.web.api.Invest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InvestRestController {

    private List<Invest> invests;

    public  InvestRestController() {
        invests = new ArrayList<>();
        invests.add(new Invest(1,"Apple","Share",100,10,100));
        invests.add(new Invest(2,"Tesla","Share",780,1,780));
    }

    @GetMapping(path = "/api/v1/invests")
    public ResponseEntity<List<Invest>> fetchInvests() {
        return ResponseEntity.ok(invests);
    }

}
