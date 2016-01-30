(ns fizzbuzz-with-thread-macros.core)

(defn- multiple-of? [div num]
  (zero? (mod num div)))

(defn- transform-num [to preds]
  (fn [num]
    (if (every? #(% num) (cons (complement string?) preds))
      (to num)
      num)))

(defn- transform-to [to preds res]
  (map (transform-num to preds) res))

(defn- when-multiple-of [& divisors]
  (map #(partial multiple-of? %) divisors))

(def ^:private fizz-buzz (constantly "FizzBuzz"))
(def ^:private fizz (constantly "Fizz"))
(def ^:private buzz (constantly "Buzz"))
(def ^:private in-any-other-case [(constantly true)])

(defn fizzbuzz []
  (->>
    (range 1 101)
    (transform-to fizz-buzz (when-multiple-of 3 5))
    (transform-to fizz (when-multiple-of 3))
    (transform-to buzz (when-multiple-of 5))
    (transform-to str in-any-other-case)))
