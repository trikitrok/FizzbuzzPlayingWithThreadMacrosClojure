(ns fizzbuzz-with-thread-macros.core)

(defn- multiple-of? [num div]
  (zero? (mod num div)))

(defn fizzbuzz []
  (->>
    (range 1 101)
    (map #(if (and (not (string? %)) (multiple-of? % 3) (multiple-of? % 5)) "FizzBuzz" %))
    (map #(if (and (not (string? %)) (multiple-of? % 3)) "Fizz" %))
    (map #(if (and (not (string? %)) (multiple-of? % 5)) "Buzz" %))
    (map str)))
