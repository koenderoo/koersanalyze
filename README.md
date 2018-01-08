# koersanalyze
Berekend per dag de koersschommeling voor de dan komende 3 jaar obv historische gegevens

Na het starten wordt een bestand verwacht. De analyse is geschreven obv de gegevens die te downloaden zijn via aex.nl.
Het verwachte formaat is .csv, vertical layout. De decimal separator is "." en datumformaat day/month/year.

De output is een lijst met datums vanaf de oudste in de file met daarachter de hoogste en laagste waarde in de 3 jaar na die datum en het verschil tussen die twee. De output stopt bij de datum die 3 jaar voor de laatste datum in de file ligt, zodat er altijd een periode van 3 jaar getoond wordt.
