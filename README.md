# Warehouse Control

Warehouse Control är ett objektorienterat Java-program för hantering av lagermaskiner och deras lastkapacitet.

## Hur kör man programmet ?
1. Klona eller ladda ner projektet från GitHub.
2. Öppna projektet i IntelliJ IDEA.
3. Kontrollera att JDK 25 är vald.
4. Öppna src/app/Main.java.
5. Klicka på den gröna Run-pilen vid main().

Programmet visar information om lagermaskinerna, genomförda regeltester och visar en sammanställning av lagrets totala lastkapacitet.

## Utskrift från Run-fönstret

========================================<br>
WAREHOUSE CONTROL<br>
========================================<br>
Maskin- och lasthantering<br>
Version: 1.0.0<br>
Registrerade maskiner: 3<br>

TR-001 | MOTVIKTSTRUCK
----------------------------------------
Modell: Toyota<br>
Drivning: Elektrisk<br>
Max lyfthöjd: 4500 mm<br>
Arbete: Lastar och lossar gods vid lastkajen.<br>
Aktuell last: 1500 / 2500 kg<br>
████████████░░░░░░░░ 60%<br>
Ledig kapacitet: 1000 kg<br>
Status: LEDIG KAPACITET

LS-001 | LEDSTAPLARE
----------------------------------------
Modell: BT<br>
Drivning: Elektrisk<br>
Max lyfthöjd: 3000 mm<br>
Arbete: Placerar gods i ett lagerstallage<br>
Aktuell last: 800 / 1200 kg<br>
█████████████░░░░░░░ 67%<br>
Ledig kapacitet: 400 kg<br>
Status: LEDIG KAPACITET

PD-001 | PALLDRAGARE
----------------------------------------
Modell: BT Lifter<br>
Drivning: Manuell<br>
Max lyfthöjd: 200 mm<br>
Arbete: Förflyttar gods till packstationen.<br>
Aktuell last: 500 / 2000 kg<br>
█████░░░░░░░░░░░░░░░ 25%<br>
Ledig kapacitet: 1500 kg<br>
Status: LEDIG KAPACITET

========================================<br>
REGELTESTER<br>
========================================<br>

Test: TR-001<br>
Före: 1500 kg<br>
Försöker tilldela: -1 kg<br>
Förväntat: Nekas<br>
[STOPP] -1 kg är inte tillåtet. tillåten intervall: 0-2500 kg.<br>
Efter: 1500 kg<br>
[OK] Testet lyckades.

Test: TR-001<br>
Före: 1500 kg<br>
Försöker tilldela: 2501 kg<br>
Förväntat: Nekas<br>
[STOPP] 2501 kg är inte tillåtet. tillåten intervall: 0-2500 kg.<br>
Efter: 1500 kg<br>
[OK] Testet lyckades.

Test: TR-001<br>
Före: 1500 kg<br>
Försöker tilldela: 0 kg<br>
Förväntat: Accepteras<br>
Efter: 0 kg<br>
[OK] Testet lyckades.

Test: TR-001<br>
Före: 0 kg<br>
Försöker tilldela: 2500 kg<br>
Förväntat: Accepteras<br>
Efter: 2500 kg<br>
[OK] Testet lyckades.<br>
Ursprunglig last återställd: 1500 kg

Test: LS-001<br>
Före: 800 kg<br>
Försöker tilldela: -1 kg<br>
Förväntat: Nekas<br>
[STOPP] -1 kg är inte tillåtet. tillåten intervall: 0-1200 kg.<br>
Efter: 800 kg<br>
[OK] Testet lyckades.

Test: LS-001<br>
Före: 800 kg<br>
Försöker tilldela: 1201 kg<br>
Förväntat: Nekas<br>
[STOPP] 1201 kg är inte tillåtet. tillåten intervall: 0-1200 kg.<br>
Efter: 800 kg<br>
[OK] Testet lyckades.

Test: LS-001<br>
Före: 800 kg<br>
Försöker tilldela: 0 kg<br>
Förväntat: Accepteras<br>
Efter: 0 kg<br>
[OK] Testet lyckades.

Test: LS-001<br>
Före: 0 kg<br>
Försöker tilldela: 1200 kg<br>
Förväntat: Accepteras<br>
Efter: 1200 kg<br>
[OK] Testet lyckades.<br>
Ursprunglig last återställd: 800 kg

Test: PD-001<br>
Före: 500 kg<br>
Försöker tilldela: -1 kg<br>
Förväntat: Nekas<br>
[STOPP] -1 kg är inte tillåtet. tillåten intervall: 0-2000 kg.<br>
Efter: 500 kg<br>
[OK] Testet lyckades.

Test: PD-001<br>
Före: 500 kg<br>
Försöker tilldela: 2001 kg<br>
Förväntat: Nekas<br>
[STOPP] 2001 kg är inte tillåtet. tillåten intervall: 0-2000 kg.<br>
Efter: 500 kg<br>
[OK] Testet lyckades.

Test: PD-001<br>
Före: 500 kg<br>
Försöker tilldela: 0 kg<br>
Förväntat: Accepteras<br>
Efter: 0 kg<br>
[OK] Testet lyckades.

Test: PD-001<br>
Före: 0 kg<br>
Försöker tilldela: 2000 kg<br>
Förväntat: Accepteras<br>
Efter: 2000 kg<br>
[OK] Testet lyckades.<br>
Ursprunglig last återställd: 500 kg

========================================<br>
TESTRESULTAT<br>
========================================<br>
Genomförda tester: 12<br>
Godkända tester: 12<br>
misslyckade tester: 0<br>
[OK] Samtliga regeltester godkända.

========================================<br>
LAGERÖVERSIKT<br>
========================================<br>
Antal maskiner: 3<br>
Total aktuell last: 2800 kg<br>
Total lastkapacitet: 5700 kg<br>
Ledig lastkapacitet: 2900 kg<br>
██████████░░░░░░░░░░ 49%<br>
========================================

Process finished with exit code 0

## Felsökning
Ett vanligt förekommande fel när jag skulle köra koden var att jag gång på gång fick felmeddelanden gällande att miss-match på olika namn när det kommer till stor och liten bokstav eller ett stavfel.

ett annat problem jag stötte på var att jag hade skapat metoden getLedigKapacitet(), men glömt att anropa den i visaKapacitet().

Jag löste problemet genom att lägga till följande rad:<br>
`System.out.println("Ledig kapacitet: " + getLedigKapacitet() + " kg");`

Eftersomm metoden ligger i superklassen behövde jag bara göra ändringen på ett ställe för att det skulle fungera för alla maskiner.

## Hjälpmedel

Jag har använt mig av:
- IntelliJ IDEA
- Git och GitHub
- Studieguiden
- Gammal hederlig Googling (tex w3schools.com för kodhjälp, coursera.org för att få fram hur man strukturerar upp en .md-fil)
- ChatGPT (Endast för att få hjälp att fixa det visuella i Run-fönster utskriften)



