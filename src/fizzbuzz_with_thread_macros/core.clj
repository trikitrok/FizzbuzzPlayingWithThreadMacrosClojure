(ns fizzbuzz-with-thread-macros.core)

(defn fizzbuzz []
  (->>
    (range 1 101)
    (map #(if (and (zero? (mod % 3)) (zero? (mod % 5))) "FizzBuzz" %))
    (map #(if (and (not (string? %)) (zero? (mod % 3))) "Fizz" %))
    (map #(if (and (not (string? %)) (zero? (mod % 5))) "Buzz" %))
    (map str)))
