# BE-settimana-8-progetto
Progetto EWallet, settimana 8.



http://localhost:8080/EWallet/rest/wallet/getmovimenti = Retrieve dell'Array Movimenti.

http://localhost:8080/EWallet/rest/wallet/getconti = Retrieve dell'Array listaCC.

http://localhost:8080/EWallet/rest/wallet/modifica = Modifica, con annesso esempio Json per la modifica:
  {
        "dataCreazione": "10/09/2017",
        "iban": 100,
        "saldo": 2500.0,
        "intestatario": "Franco Franchino"
    }
    
 
 http://localhost:8080/EWallet/rest/wallet/inserisci = Inserimento, con annesso esempio Json per la modfica:
 
  {
    "dataCreazione" : "10/10/2020",
	"iban" : 100,
    "saldo" : 1000.00,
	"intestatario" : "Aldo"
}


http://localhost:8080/EWallet/rest/wallet/deleteconto/100 = Delete, con inserimento del parametro IBAN dopo il delete conto.

http://localhost:8080/EWallet/rest/wallet/deposito/102/10settembre2020/500.0 = Deposito. Dopo la stringa deposito inserico in ordine: IBAN; DATA; IMPORTO.

http://localhost:8080/EWallet/rest/wallet/prelievo/102/10settembre2020/500.0 = Prelievo. Dopo la stringa prelievo inserico in ordine: IBAN; DATA; IMPORTO.
