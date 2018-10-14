package com.github.shionit.geminiapi.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by @shionit on 2018/10/08.
 */
@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
