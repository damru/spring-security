package com.damienrubio.samples.springsecurity.oauth2.client;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

    @PreAuthorize("#oauth2.hasScope('foo:read')")
    @GetMapping
    public ResponseEntity<String> auth() {
        return ResponseEntity.ok("You are authenticated.");
    }

    @PreAuthorize("#oauth2.hasScope('foo:noscope')")
    @GetMapping("/noscope")
    public ResponseEntity<Void> reject() {
        return ResponseEntity.ok().build();
    }

}
