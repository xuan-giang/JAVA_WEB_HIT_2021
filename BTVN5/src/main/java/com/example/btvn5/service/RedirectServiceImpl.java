package com.example.btvn5.service;

import com.example.btvn5.exception.NotFoundException;
import com.example.btvn5.model.Redirect;
import com.example.btvn5.repository.RedirectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
public class RedirectServiceImpl implements RedirectService{

    @Autowired
    private RedirectRepository redirectRepository;

    public Redirect getRedirect(String alias) {
        Redirect redirect = redirectRepository.findBySubUrl(alias)
                .orElseThrow(() -> new NotFoundException("Hey we don't have that alias ! Try making it"));
        return redirect;
    }

    @Override
    public List<Redirect> findAllRedirect() {
        return redirectRepository.findAll();
    }

    @Override
    public void createRedirect(String startUrl) {
        Redirect redirect = new Redirect();
        redirect.setUrl(startUrl);
        redirect.setSubUrl(getRandomUrl());
        redirectRepository.save(redirect);
    }

    @Override
    public void createRedirect(String startUrl, String subUrl) {
        Redirect redirect = new Redirect();
        redirect.setUrl(startUrl);
        redirect.setSubUrl(subUrl);
        redirectRepository.save(redirect);
    }

    static final String AB  = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();
    static int len          = 8;

    private String getRandomUrl() {
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }




}
