(ns culture.facts
  "Country-level regional-culture catalog for Poland (POL) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"POL"
   [{:culture/id "pol.dish.pierogi"
     :culture/name "Pierogi"
     :culture/country "POL"
     :culture/kind :dish
     :culture/summary "Dumplings under the name pierogi are a traditional Polish dish, holding considerable culinary significance in Poland."
     :culture/url "https://en.wikipedia.org/wiki/Pierogi"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "pol.dish.bigos"
     :culture/name "Bigos"
     :culture/country "POL"
     :culture/kind :dish
     :culture/summary "Polish dish of chopped meat of various kinds stewed with sauerkraut, shredded fresh cabbage and spices."
     :culture/url "https://en.wikipedia.org/wiki/Bigos"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "pol.dish.kielbasa"
     :culture/name "Kielbasa"
     :culture/country "POL"
     :culture/kind :dish
     :culture/summary "Any type of meat sausage from Poland and a staple of Polish cuisine."
     :culture/url "https://en.wikipedia.org/wiki/Kielbasa"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "pol.beverage.vodka"
     :culture/name "Vodka"
     :culture/name-local "Wódka"
     :culture/country "POL"
     :culture/kind :beverage
     :culture/summary "The world's first written mention of the word wódka was in 1405, from Polish court documents, establishing Poland's early prominence in the drink's history."
     :culture/url "https://en.wikipedia.org/wiki/Vodka"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "pol.product.oscypek"
     :culture/name "Oscypek"
     :culture/country "POL"
     :culture/kind :product
     :culture/summary "Smoked cheese made of salted sheep milk, produced exclusively in Poland's Tatra Mountains region, with EU Protected Designation of Origin status granted in February 2008."
     :culture/url "https://en.wikipedia.org/wiki/Oscypek"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "pol.craft.boleslawiec-pottery"
     :culture/name "Boleslawiec pottery"
     :culture/name-local "Ceramika bolesławiecka"
     :culture/country "POL"
     :culture/kind :craft
     :culture/summary "Collective term for fine pottery and stoneware produced in the town of Boleslawiec in south-western Poland, with origins tracing to the late Middle Ages; the town is known as the \"Town of Ceramics\" and the pottery is one of Poland's unofficial cultural symbols."
     :culture/url "https://en.wikipedia.org/wiki/Boles%C5%82awiec_pottery"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "pol.festival.lajkonik"
     :culture/name "Lajkonik"
     :culture/country "POL"
     :culture/kind :festival
     :culture/summary "Annual Krakow festival held on the first Thursday after Corpus Christi, where a man dressed as a warrior from the East rides a hobby horse through the city streets collecting ransom money; being touched by his mace is believed to bring good fortune."
     :culture/url "https://en.wikipedia.org/wiki/Lajkonik"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "pol.heritage.wieliczka-salt-mine"
     :culture/name "Wieliczka Salt Mine"
     :culture/country "POL"
     :culture/kind :heritage
     :culture/summary "In 1978 the Wieliczka Salt Mine was placed on the original UNESCO list of World Heritage Sites, and it remains recognized today alongside the nearby Bochnia Salt Mine under the designation \"Wieliczka and Bochnia Royal Salt Mines\"."
     :culture/url "https://en.wikipedia.org/wiki/Wieliczka_Salt_Mine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-pol culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "POL"))
                 " POL entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
