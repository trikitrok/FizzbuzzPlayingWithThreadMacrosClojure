(ns fizzbuzz-with-thread-macros.core)

(defn- multiple-of? [div num]
  (zero? (mod num div)))

(defn- transform-to [to & preds]
  (fn [num]
    (if (every? #(% num) (cons (complement string?) preds))
      to
      num)))

(defn fizzbuzz []
  (->>
    (range 1 101)
    (map (transform-to "FizzBuzz" (partial multiple-of? 3) (partial multiple-of? 5)))
    (map (transform-to "Fizz" (partial multiple-of? 3)))
    (map (transform-to "Buzz" (partial multiple-of? 5)))
    (map str)))
