(ns fizzbuzz-with-thread-macros.core)

(defn- multiple-of? [div num]
  (zero? (mod num div)))

(defn- transform [to & preds]
  (fn [num]
    (if (every? #(% num) (cons (complement string?) preds))
      to
      num)))

(defn fizzbuzz []
  (->>
    (range 1 101)
    (map (transform "FizzBuzz" (partial multiple-of? 3) (partial multiple-of? 5)))
    (map (transform "Fizz" (partial multiple-of? 3)))
    (map (transform "Buzz" (partial multiple-of? 5)))
    (map str)))
