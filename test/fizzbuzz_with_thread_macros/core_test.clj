(ns fizzbuzz-with-thread-macros.core-test
  (:require [midje.sweet :refer :all]
            [fizzbuzz-with-thread-macros.core :refer :all]))

(facts
  "About fizzbuzz"
  (fact
    "It returns 100 strings"

    (fizzbuzz) => (n-of string? 100))
  )

