(ns fizzbuzz-with-thread-macros.core)

(defn fizzbuzz []
  (->>
    (range 1 101)
    (map #(if (zero? (mod % 3)) "Fizz" %))
    (map str)))
