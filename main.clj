(ns main)

(defn fuel-for-mass [mass]
  (let [floored (Math/floor (/ mass 3))]
    (if (< floored 0)
      0
    (- (int floored) 2)) ))

(defn fuel-requirement-for-modules [masses]
  (apply + (map #(fuel-for-mass %) masses)))

(defn fuel-for-fuel [module-mass]
  (loop [fuel-mass module-mass
         sum 0]
    (let [fuel (fuel-for-mass fuel-mass)]
      (if (< 0 fuel)
        (recur fuel (+ sum fuel))
        sum))))

(defn total-mass [module-mass]
  (let [fuel-for-module (fuel-for-mass module-mass)
        fuel-mass (fuel-for-fuel fuel-for-module)]
  (+ fuel-for-module fuel-mass)))
