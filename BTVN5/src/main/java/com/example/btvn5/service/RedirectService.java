package com.example.btvn5.service;

import com.example.btvn5.model.Redirect;

import java.util.List;
import java.util.Optional;

public interface RedirectService {


    void createRedirect(String startUrl);

    void createRedirect(String startUrl, String subUrl);

    Redirect getRedirect(String alias);

    List<Redirect> findAllRedirect();
}
