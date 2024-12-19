package com.example.socksinstock.service;

import com.example.socksinstock.model.Socks;

public interface SocksService {
    void registerIncome(Socks socks);

    void registerOutcome(Socks socks, Integer amount);
}
