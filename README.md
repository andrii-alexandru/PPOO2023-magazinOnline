# PPOO2023 - Magazin Online in Java
Tema 3. Sa se realizeze o aplicatie Java de gestiune a unui magazin online, in care sa se poata efectua operatiile CRUD. Implementarea nu presupune lucrul cu baze de date, ci se doreste gasirea unei solutii de persistenta adiacenta (lucrul cu fisiere, colectii de obiecte ce definesc produse, etc.).

## Introducere
Aceasta documentatie ofera o descriere detaliata a aplicatiei "Magazin Online", un sistem de gestionare a unui magazin virtual dezvoltat in Java. Aceasta aplicatie vizeaza operatii de baza pentru produse si comenzi, fara a utiliza baze de date. Datele sunt stocate temporar in memorie sau in fisiere, iar interactiunea cu utilizatorul se face printr-o interfata text bazata pe consola.

## Functionalitati

### Modul Admin
(accesat pe baza unei parole)

- **Adauga Produs Nou**: Permite adaugarea unui produs nou in magazin. Adminul poate specifica numele, pretul si stocul produsului.
- **Sterge Produs**: Adminul poate sterge un produs existent pe baza ID-ului produsului.
- **Modifica Produs**: Adminul poate modifica un produs existent pe baza ID-ului produsului.
- **Reinitializeaza Selectia de Produse**: Aceasta optiune reseteaza selectia de produse la valorile initiale.
- **Statistici**: Adminul poate vizualiza istoricul comenzilor.

### Modul Magazin Online

- **Comanda Produse**: Utilizatorul poate comanda produse din magazin. Produsele pot fi adaugate intr-o lista de comanda utilizand ID-ul produsului.
- **Efectueaza Comanda**: Dupa ce s-au adaugat produse in comanda, utilizatorul poate finaliza comanda si efectua o achizitie. Astfel, se inregistreaza comanda in statistici.

## Resurse

Acest proiect utilizeaza resursele si conceptele standard din Java, cum ar fi colectii de obiecte pentru gestionarea produselor, interactiune cu utilizatorul utilizand clasa `Scanner`, gestionarea datelor in memorie si interfata utilizatorului bazata pe consola.

## Limitari

- Datele sunt stocate temporar in memorie sau in fisiere, ceea ce inseamna ca datele se pot pierde daca aplicatia nu se inchide corespunzator.
- Erori la validarea datelor.

## Contributii

Acest proiect este deschis pentru contributii. 

## Autor

Acest proiect a fost creat de Andrii Alexandru-Marian.
