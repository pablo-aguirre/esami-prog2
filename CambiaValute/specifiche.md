# Cambia valute

## Valuta [enum]
- Stato:
  - **nome** (non vuoto)
  - **simbolo** (carattere):
    - Dollaro ($)
    - Euro (€)
    - Franco (₣)
    - Lira (₺)
    - Rupia (₹)
    - Sterlina (£)
    - Yen (¥)
    
    Definite in questo **ordine** (iteratore).

## Importo
- Stato:
  - valore (unità e centesimi)
  - **valuta**
- Metodi:
  - importo -> somma con this
  - importo -> sottrazione con this
  - importo -> **confronto** con this
  - valuta -> importo zero (static factory method)
  - tasso di cambio (valuta di this e un'altra valuta ≠) -> importo equivalente all'altra valuta

## Cassa (multi-valuta)
"Contenitore” di **importi**, dove è possibile versare importi (in qualunque valuta) e prelevare importi (se possibile).

- Metodi:
  - versare **importi** (in qualunque valuta)
  - prelevare **importi** (se la cassa contiene un importo sufficiente per quella valuta)
  - iteratore sui propri importi (≠ 0) nell'ordine di come sono state definite le valute
  - toString() che usa l'iteratore sopra

## Tasso di cambio
- Stato:
  - due importi (di ≠ valuta)

## Cambiavalute
- Stato:
  - **cassa** (non più modificabile dopo la sua creazione se non mediante i tassi di cambio)
  - serie **tassi di cambio**
- Metodi:
  - ?
  - ?
  - iteratore sui tassi di cambio nell'ordine in cui sono stati aggiornati
  - toString() che usa iteratore sopra
  
