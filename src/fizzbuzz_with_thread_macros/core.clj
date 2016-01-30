(ns fizzbuzz-with-thread-macros.core)

(defn- multiple-of? [div num]
  (zero? (mod num div)))

(defn- transform-to [to preds]
  (fn [num]
    (if (every? #(% num) (cons (complement string?) preds))
      to
      num)))

(defn- when-multiple-of [& divisors]
  (map #(partial multiple-of? %) divisors))

(defn fizzbuzz []
  (->>
    (range 1 101)
    (map (transform-to "FizzBuzz" (when-multiple-of 3 5)))
    (map (transform-to "Fizz" (when-multiple-of 3)))
    (map (transform-to "Buzz" (when-multiple-of 5)))
    (map str)))
