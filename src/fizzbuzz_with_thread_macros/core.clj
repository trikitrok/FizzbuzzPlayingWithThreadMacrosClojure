(ns fizzbuzz-with-thread-macros.core)

(defn- multiple-of? [div num]
  (zero? (mod num div)))

(defn- transform-num [to preds]
  (fn [num]
    (if (every? #(% num) (cons (complement string?) preds))
      to
      num)))

(defn- transform-to [to preds res]
  (map (transform-num to preds) res))

(defn- when-multiple-of [& divisors]
  (map #(partial multiple-of? %) divisors))

(defn fizzbuzz []
  (->>
    (range 1 101)
    (transform-to "FizzBuzz" (when-multiple-of 3 5))
    (transform-to "Fizz" (when-multiple-of 3))
    (transform-to "Buzz" (when-multiple-of 5))
    (map str)))
