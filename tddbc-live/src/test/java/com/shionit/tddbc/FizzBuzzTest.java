package com.shionit.tddbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * FizzBuzz問題が解けていることのテスト
 */
@DisplayName("Fizz Buzz 数列と変換規則を扱う FizzBuzz クラス")
public class FizzBuzzTest {

    private FizzBuzz fizzbuzz;

    @BeforeEach
    void before() {
        // 準備(arrange/given)
        fizzbuzz = new FizzBuzz();
    }

    @Nested
    class convertメソッドは数を文字列に変換する {
        @Nested
        class _3の倍数のときは数の代わりにFizzに変換する {

            @Test
            void _3を渡すと文字列Fizzを返す() {
                // 実行(act/when) & 検証(assert/then)
                assertEquals("Fizz", fizzbuzz.convert(3));
            }
        }

        @Nested
        class _5の倍数のときは数の代わりにBuzzに返還する {

            @Test
            void _5を渡すと文字列Buzzを返す() {
                // 実行(act/when) & 検証(assert/then)
                assertEquals("Buzz", fizzbuzz.convert(5));
            }
        }

        @Nested
        class その他の数のときはそのまま文字列に変換する {

            @Test
            void _1を渡すと文字列1を返す() {
                // 実行(act/when) & 検証(assert/then)
                assertEquals("1", fizzbuzz.convert(1));
            }
        }

        @Nested
        class _3と5両方の倍数のときは数の代わりにFizzBuzzに変換する {
            @Test
            void _15を渡すと文字列FizzBuzzを返す() {
                // 実行(act/when) & 検証(assert/then)
                assertEquals("FizzBuzz", fizzbuzz.convert(15));
            }
        }
    }
}
