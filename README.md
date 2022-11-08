Client/Server Programmierung mit Sockets

1. Transportschicht
2. Sockets und Ports
3. Serialisierung der Nachrichten
4. Entwurf der Dateitransfer Anwendung
-----------------------------------------------------------------------------------------

#Client-Programm 

1. Erzeuge Client-Socket csock
2. Öffne Ein- und Ausgabestrom
von csock
3. Lese von und schreibe auf diese
Ströme wie bei gewöhnlicher
Ein-/Ausgabe. (gemäß
Protokoll)
4. Schließe die Ströme.
5. Schließe csock

#Server-Programm

1. Erzeuge Server-Socket ssock
2. Warte, bis Client ein eigenes Socket
anfordert (ssock.accept())
3. Öffne Ein- und Ausgabestrom des neuen
Sockets csock
4. Lese von und schreibe auf diese Ströme wie
bei gewöhnlicher Ein-/Ausgabe. (gemäß
Protokoll)
5. Schließe die Ströme.
6. Schließe csock
7. Schließe ssock (nur bei Server shutdown)
