(ns dojo.core)

(defn square [x]
  (* x x))

(defn cube [x]
  (* x x x))

(defn from-1-until [f pred]
  (comp
    (drop 1)
    (map f)
    (take-while pred)))

(defn dojo [f pred]
  (transduce (comp
               (from-1-until f pred)
               (map (constantly 1)))
             + 0 (range)))

(defn dojo2 [f pred]
  (->> (range) ; => range infinito comecando em 0
         (drop 1) ; => Range iniciando do 1
         (map f) ; => numeros ate o quadrado
         (take-while pred)
         (map (constantly 1)) ; => Transforma tudo pra 1
         (reduce + 0))) ; => Soma tudo