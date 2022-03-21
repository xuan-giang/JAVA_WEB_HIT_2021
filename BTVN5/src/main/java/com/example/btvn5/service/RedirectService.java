package com.example.btvn5.service;

import com.example.btvn5.model.Redirect;

import java.util.Optional;

public interface RedirectService {


    void createRedirect(String startUrl);

    Redirect getRedirect(String alias);
}
