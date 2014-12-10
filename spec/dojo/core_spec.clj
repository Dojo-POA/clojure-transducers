(ns dojo.core-spec
  (:require [speclj.core :exclude [run-specs] :refer :all]
            [dojo.core :refer :all]
            [speclj.run.standard :refer [run-specs]]))

(describe "dojo"
          (it "faz tudo"
              (should= (dojo2 square (fn [x] (>= 40 x))) 6))
          (it "faz tudo"
              (should= (dojo2 square #(>= 40 %1)) 6))
          (it "faz tudo"
              (should= (dojo square (partial >= 40)) 6))
          (it "faz tudo"
            (should= (dojo2 cube (partial >= 40)) 3))

          (it "faz tudo"
              (should= (into [] (from-1-until square (partial >= 40)) (range)) []))

          )

(run-specs)