package com.github.shionit.geminiapi.controller;

import com.github.shionit.geminiapi.domain.Currency;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * Created by @shionit on 2018/10/08.
 */
@Getter
@Builder
public class CurrencyResponse {

    private List<Currency> currencies;
}
