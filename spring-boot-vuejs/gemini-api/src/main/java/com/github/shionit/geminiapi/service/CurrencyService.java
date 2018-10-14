package com.github.shionit.geminiapi.service;

import com.github.shionit.geminiapi.domain.Currency;
import com.github.shionit.geminiapi.domain.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by @shionit on 2018/10/08.
 */
@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }

    public Currency save(String name, String symbol) {
        return currencyRepository.save(Currency.of(name, symbol));
    }

    public void delete(Long id) {
        currencyRepository.findById(id).ifPresent(currency -> currencyRepository.delete(currency));
    }
}
