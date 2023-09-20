ALBUM [immutabile]
    - titolo
    - elenco (ordinato, non vuoto e senza ripetizioni) di BRANI
    - durata complessiva (positiva)
    • titolo -> brano
    • posizione nell'ALBUM -> brano
    • brano -> posizione nell'ALBUM
    • iteratore sui brani

BRANO [immutabile]
    - titolo (non vuoto)
    - durata (positiva)
    NB: brani appartenenti ad ALBUM diversi sono diversi
        => inner class di ALBUM
            => costruttore di ALBUM: no elenco album, ma elenco di titoli e durate 

DURATA 
    - valore (non negativo)
    • "2:01:35" -> costruisce una durata
    • durata -> "2:01:35"
    • -> rappresentazione tipo "2:01:35"
    • somme e sottrazioni (con risultato non negativo) tra durate

PLAYLIST [mutabile]
    - elenco (ordinato) di brani (anche da album diversi), anche vuota
    - nome
    - durata complessiva (0 se playlist vuota)
    • aggiunta di brani
    • rimozione di brani
    • brano -> presenza?
    • brano -> posizione nella playlist

    • iteratore sui brani (con album di provenienza)
    • album -> iteratore sui brani di tale album
    • iteratore sugli album (non ripetuti)

    • PLAYLIST, titolo -> nuova PLAYLIST ottenuta dalla fusione di this e quella data (prima i brani di this e poi quelli dell'altra, se non già presenti in this)


---
RAPPRESENTAZIONE DI ALBUM:

    Titolo album: In the Court of the Crimson King
    1 - "21st Century Schizoid Man" (07:24)
    2 - "I Talk to the Wind" (06:04)
    3 - "Epitaph" (08:49)
    4 - "Moonchild" (12:13)
    5 - "The Court of the Crimson King" (09:26)
    Durata totale: 43:56

RAPPRESENTAZIONE DI PLAYLIST:

    Nome playlist: Mescolotto
    1 - "Another Brick in the Wall, Part 1" (03:11), (da "The wall")
    2 - "21st Century Schizoid Man" (07:24), (da "In the Court of the Crimson King")
    3 - "Another Brick in the Wall, Part 2" (03:59), (da "The wall")
    4 - "Hey You" (04:40), (da "The wall")
    5 - "Is There Anybody Out There?" (02:44), (da "The wall")
    6 - "The Court of the Crimson King" (09:26), (da "In the Court of the Crimson King")
    7 - "Mother" (05:32), (da "The wall")
    Durata totale: 45:23