# 🕵️ Simulatore Grafico della Macchina Enigma

Questo progetto è un **simulatore interattivo** della celebre **macchina Enigma**, sviluppato in **Java** con **JavaFX**. L'applicazione permette di codificare messaggi lettera per lettera o per intero, replicando fedelmente il comportamento dell'Enigma grazie alla configurazione di **rotori**, **riflettore** e **plugboard**.

---

## 🎮 Funzionalità

### 🔘 Selezione Rotori
- Tre rotori configurabili tra **I, II, III, IV, V**
- Ogni rotore ha un cablaggio interno differente

### 🔢 Impostazione Posizione Iniziale
- Ogni rotore può essere impostato su una lettera da **A a Z**
- Controllo con pulsanti `+` e `-`

### 🔁 Selezione del Riflettore
- Tre tipi disponibili: **A, B, C**
- Determina il comportamento simmetrico della cifratura

### 🔌 Plugboard (Pannello Prese)
- Fino a **13 coppie di lettere** (es. `AB`, `CD`, ...)
- Collega le lettere tra loro prima e dopo i rotori
- Input validato: solo due lettere diverse, da `A` a `Z`

### 💡 Lampade Virtuali
- Griglia di **3x9** lettere con cerchi colorati
- La lettera cifrata si illumina in **giallo**

### 🎹 Modalità di Input
Due modalità selezionabili:
- **Tastiera Virtuale** (mouse): clic sulle lettere per codifica istantanea
- **Input di Testo**: scrivi una frase e codificala con il tasto "Enter"

### ⌨️ Supporto alla Tastiera Fisica
- Premendo i tasti `A`–`Z` sulla tastiera, viene eseguita la codifica
- Rotori ruotano automaticamente dopo ogni lettera

### 🔄 Reset Completo
Un pulsante "Reset" per:
- Riportare i rotori alla posizione iniziale (`A`)
- Selezionare rotori III, II, I
- Selezionare riflettore B
- Pulire la plugboard

### 🔁 Meccanismo di Rotazione
- Dopo ogni lettera codificata, i rotori ruotano secondo il meccanismo "a cascata"
- Visualizzazione aggiornata in tempo reale

---

## 📚 Obiettivi Didattici

Il progetto è stato realizzato con l'intento di approfondire:

- I principi della **crittografia meccanica**
- La **programmazione grafica** con **JavaFX**
- L'uso degli **eventi**, dei **layout dinamici** e dei **componenti GUI**
- La **programmazione orientata agli oggetti**
- La gestione dello **stato** in un sistema interattivo

---

## 📌 In Sintesi

Il simulatore Enigma offre:

- Un'interfaccia chiara e realistica
- Un'ottima base per l’apprendimento della crittografia storica
- Un esempio avanzato di applicazione JavaFX

> Può essere utilizzato in ambito **didattico**, per **presentazioni**, o come base per **estensioni** future (es. stile vintage, esportazione configurazioni, modalità multiplayer).

---

## 📷 Screenshot

*(Puoi aggiungere uno o più screenshot qui con il tag `![nome](percorso/immagine.png)`)*

---

## ▶️ Avvio del progetto

1. Assicurati di avere installato **Java 17+** e **JavaFX**
2. Clona il progetto:
   ```bash
   git clone https://github.com/tuo-username/enigma-simulator.git
   cd enigma-simulator
