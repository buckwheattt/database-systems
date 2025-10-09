## Informační systém pro včelařství🐝🐝🐝
Tento projekt ukazuje celý životní cyklus návrhu a implementace relační databáze v doméně včelařství. Zahrnuje konceptuální modelování, návrh relačního schématu, implementaci v PostgreSQL a integraci s Java aplikací.

### 1. Konceptuální model
Osm hlavních entit: Uživatel, Osobní údaje, Zákazník, Včelař, Med, Sklenice, Komentář, Včelí úl + asociační entita Doporučil.
Obsahuje slabé entity (např. Osobní údaje závislé na Uživateli), rekurzivní vazby (včelař spolupracující s jiným včelařem), dědičnost (Uživatel jako nadtřída pro Zákazníka a Včelaře) a složené identifikátory.

### 2. Relační model a databázová implementace
Model byl převeden do relačního schématu s odpovídajícími tabulkami v PostgreSQL.
Byly zachovány všechny klíčové vztahy: 1:1, 1:N, N:M i rekurzivní vazby.
Byla vložena ukázková data pro testování a připraveny SQL dotazy demonstrující joiny, agregace, vnořené selecty, množinové operace a stránkování.

### 3. Pokročilé databázové prvky
Trigger: Zabraňuje smazání včelaře, pokud má přiřazen alespoň jeden úl.
Transakce: Ukazuje změnu role uživatele převedením včelaře na zákazníka v rámci serializovatelné transakce.
Pohledy: Umožňují zjednodušený přístup k filtrovaným datům (např. sklenice s určitým druhem a množstvím medu).
Indexy: Zrychlují vyhledávání podle vybraných atributů, např. složení medu.

### 4. Integrace s Javou
Relační schéma bylo propojeno s Java projektem v IntelliJ IDEA.
Entity byly namapovány na databázové tabulky pomocí JPA/Hibernate.
Byly implementovány DAO třídy pro práci s databází a zapouzdření perzistentní logiky.

### 5. Účel projektu
Projekt slouží jako případová studie databázového návrhu a softwarového inženýrství. Spojuje konceptuální modelování, relační implementaci a aplikační vývoj do jednoho celku.
