package com.example.btvn5.controller;

import com.example.btvn5.model.Redirect;
import com.example.btvn5.service.RedirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.MOVED_PERMANENTLY;

@RestController
public class RedirectController {

    @Autowired
    private RedirectService redirectService;

    @GetMapping(value = {"/", "/index"})
    public String getHomePage()
    {
        return "index";
    }



    @GetMapping("/create")
    public String createUrl(@RequestParam("name") String name)
    {
        redirectService.createRedirect(name);
        return "Created URL successfully!";
    }

    @GetMapping("/{alias}")
    public ResponseEntity<?> handleRedirect(@PathVariable String alias) throws URISyntaxException {
        Redirect redirect = redirectService.getRedirect(alias);
        System.out.println("We're redirecting here!" + redirect);
        URI uri = new URI(redirect.getUrl());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, MOVED_PERMANENTLY);
    }
}
