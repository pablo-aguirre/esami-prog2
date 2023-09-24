## BoolVect
È un vettore di valori booleani sul quale è possibile eseguire un insieme di operazioni.

È una sequenza di valori di verità ciascuno dei quali può essere vero o falso.

- **posizioni** indicizzate dai numeri naturali (**0** in poi)
- **dimensione** = 1 + posizione più grande dove si trova un valore **vero** (0 se sono tutti **falsi**)
- **taglia**: massima dimensione che esso può raggiungere (può essere infinita = Integer.MAX_VALUE)
- **sparso**/**denso** dipende dal numero di valori di verità
- **rappresentazione testuale**:

    posizione 9876543210

    BoolVect FFFFVFFVVV
- **operazioni**:
  - leggere i-esimo valore (valore in posizione > dimensione -> false)
  - scrivere i-esimo valore
- equeals e hashCode facoltativi

### Operazioni binarie 
Operatori binari:
- **and** &
- **or** |
- **xor** ^ (vero se e solo se esattamente uno dei valori di verità a e b è vero)
  
    => derivare le operazioni componente a componente tra boolvect (**non** è necessario che i boolvect abbiano la stessa dimensione)


---
- **denso**: byte, int o long oppure array o liste (taglie arbitrarie)
- **sparsi**: rappresentazione che consenta una taglia infinita (Integer.MAX_VALUE)
- 
