(ns intcode)

(defn parse-opcode [code-list]
  (first code-list))

(defn operation [code-list effect]
  (let [sum-number1 (nth code-list (nth code-list 1))
        sum-number2 (nth code-list (nth code-list 2))
        sum (effect sum-number1 sum-number2)
        position (nth code-list 3)]
    (assoc code-list position sum)))

(defn multiply-operation [code-list]
  (operation code-list *))

(defn add-operation [code-list]
  (operation code-list +))

(defn parse-code [code-list]
  (let [operation (parse-opcode code-list)]))
