(ns fizzbuzz-with-thread-macros.core-test
  (:require [midje.sweet :refer :all]
            [fizzbuzz-with-thread-macros.core :refer :all]))

(facts
  "About fizzbuzz"
  (fact
    "It returns 100 strings"

    (fizzbuzz) => (n-of string? 100))

  (fact
    "It trasforms multiples of 3 into Fizz"
    (nth (fizzbuzz) 2) => "Fizz"
    (nth (fizzbuzz) 5) => "Fizz"
    (nth (fizzbuzz) 8) => "Fizz"))

