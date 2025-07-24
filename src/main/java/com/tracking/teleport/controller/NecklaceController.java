package com.tracking.teleport.controller;

import com.tracking.teleport.service.NecklaceService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/necklace")
@RequiredArgsConstructor
public class NecklaceController {
    private final NecklaceService necklaceService;

    @GetMapping()
    public int getNecklace(@RequestParam String necklace,
                              @RequestParam int n) {
        int result = necklaceService.getMaxBeadsCollected(n,necklace);
        return result;
    }
}
