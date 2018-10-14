package com.github.shionit.geminiapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by @shionit on 2018/10/08.
 */
@Entity
@Setter
@Getter
public class Currency {

    /** 自動採番ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 仮想通貨名 */
    private String name;

    /** シンボル */
    private String symbol;

    /** 数量 */
    private BigDecimal amount;

    public static Currency of(String name, String symbol) {
        Currency currency = new Currency();
        currency.setName(name);
        currency.setSymbol(symbol);
        currency.setAmount(BigDecimal.ZERO);
        return currency;
    }
}
