(ns fizzbuzz-with-thread-macros.core-test
  (:require [midje.sweet :refer :all]
            [fizzbuzz-with-thread-macros.core :refer :all]))

(defn- fizzbuzz-for [num]
  (nth (fizzbuzz) (dec num)))

(facts
  "About fizzbuzz"
  (fact
    "It returns 100 strings"

    (fizzbuzz) => (n-of string? 100))

  (fact
    "It trasforms multiples of 3 into Fizz"
    (fizzbuzz-for 3) => "Fizz"
    (fizzbuzz-for 6) => "Fizz"
    (fizzbuzz-for 9) => "Fizz"))

