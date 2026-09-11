(ns statute.facts
  "General-law compliance catalog for Poland (POL) -- a 48th
  country-level entry (see cloud-itonami-iso3166-jpn/-usa/-gbr/-deu/
  -fra/-can/-aus/-kor/-nld/-ita/-esp/-swe/-nor/-dnk/-fin/-prt/-bel/-bra/
  -mex/-chl/-arg/-zaf/-col/-ury/-cri/-pan/-ecu/-pry/-gtm/-hnd/-ind/-ken/
  -tha/-are/-vnm/-idn/-phl/-egy/-tur/-nga/-sau/-mys/-aut/-che/-irl/-nzl/
  -cze for the first forty-seven) per ADR-2607141700 (cloud-itonami-
  compliance-fact-federation). Poland previously had ONLY municipality
  (cloud-itonami-municipality-pol-warsaw) and marketentry.facts
  coverage in this pre-existing repo, with no statute.facts -- this
  entry closes that structural country-axis gap identified at tick
  141 and confirmed still open at tick 163.

  All three entries are directly WebFetch-verified against eli.gov.pl
  (the official Polish/EU legal-act identifier registry -- part of
  the same government infrastructure as the Sejm's ISAP database,
  which itself presented an anti-bot CAPTCHA this tick and was
  therefore abandoned per this project's standing rule against ever
  solving or bypassing CAPTCHAs; eli.gov.pl rendered the same acts
  without any CAPTCHA):

  Kodeks spółek handlowych (Commercial Companies Code, Dz.U. 2000 Nr
  94 poz. 1037) -- eli.gov.pl states verbatim 'Ustawa z dnia 15
  września 2000 r. Kodeks spółek handlowych' with enactment date 15
  September 2000.

  Ustawa o ochronie danych osobowych (Personal Data Protection Act,
  Dz.U. 2018 poz. 1000) -- eli.gov.pl states verbatim 'Ustawa z dnia
  10 maja 2018 r. o ochronie danych osobowych' with enactment date 10
  May 2018.

  Kodeks pracy (Labour Code, Dz.U. 1974 Nr 24 poz. 141) -- eli.gov.pl
  states verbatim 'Ustawa z dnia 26 czerwca 1974 r. Kodeks pracy' with
  enactment date 26 June 1974.

  An entry not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "ISO3166 alpha-3 -> vector of statute entries."
  {"POL"
   [{:statute/id "pol.dz-u-2000-1037-kodeks-spolek-handlowych"
     :statute/title "Kodeks spółek handlowych (Commercial Companies Code)"
     :statute/jurisdiction "POL"
     :statute/kind :law
     :statute/law-number "Dz.U. 2000 Nr 94 poz. 1037"
     :statute/url "https://eli.gov.pl/eli/DU/2000/1037/ogl"
     :statute/url-provenance :official-eli-gov-pl
     :statute/enacted-date "2000-09-15"
     :statute/retrieved-at "2026-07-18"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "pol.dz-u-2018-1000-ochrona-danych-osobowych"
     :statute/title "Ustawa o ochronie danych osobowych (Personal Data Protection Act)"
     :statute/jurisdiction "POL"
     :statute/kind :law
     :statute/law-number "Dz.U. 2018 poz. 1000"
     :statute/url "https://eli.gov.pl/eli/DU/2018/1000/ogl"
     :statute/url-provenance :official-eli-gov-pl
     :statute/enacted-date "2018-05-10"
     :statute/retrieved-at "2026-07-18"
     :statute/topic #{:data-protection :privacy}}
    {:statute/id "pol.dz-u-1974-141-kodeks-pracy"
     :statute/title "Kodeks pracy (Labour Code)"
     :statute/jurisdiction "POL"
     :statute/kind :law
     :statute/law-number "Dz.U. 1974 Nr 24 poz. 141"
     :statute/url "https://eli.gov.pl/eli/DU/1974/141/ogl"
     :statute/url-provenance :official-eli-gov-pl
     :statute/enacted-date "1974-06-26"
     :statute/retrieved-at "2026-07-18"
     :statute/topic #{:labor :employment}}]})

(defn spec-basis [jurisdiction] (get catalog jurisdiction))

(defn coverage
  ([] (coverage (keys catalog)))
  ([jurisdictions]
   (let [have (filter catalog jurisdictions)
         missing (remove catalog jurisdictions)]
     {:requested (count jurisdictions)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-pol statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "POL")) " Poland entries seeded "
                 "with eli.gov.pl citations (isap.sejm.gov.pl presented a CAPTCHA and was abandoned). "
                 "Extend `statute.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [jurisdiction topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis jurisdiction)))
