# currency-converter

currency-converter est un projet expérimentant la mutualisation de code entre android et ios utilisant le framework kotlin native.
<br/>L'application est un convertisseur de devise permettant de saisir un montant dans la devise demandé et retourne un resulat vers une autre, pour cela elle utilise une api de conversion open source https://openrates.io/

## Installation

Le projet sous android compile sur la version 3.4 d'Android studio avec gradle-5.1.1

Pour IOS :
<br/>Dans le dossier SharedCode faire ../gradlew podspec
<br/>Puis dans le dossier iosApp faire pod install (sudo gem install cocoapods pour pouvoir lancer la commande sur mac)
<br/>Ensuite lancer le build sur xcode.

Voir aussi https://kotlinlang.org/docs/tutorials/native/mpp-ios-android.html pour le setup d'un projet kotlin native.

## L'architecture

![alt text](https://image.noelshack.com/fichiers/2019/23/1/1559551335-cleanocto.png)

androidApp : Projet android
<br/>iosApp : Projet ios
<br/>SharedCode : Dossier contenant la partie mutualisée
- core/src/androidMain : code spécifique à android
- core/src/iosMain : code spécifique à ios
- core/src/commonMain : code mutualisé en kotlin utilisé par android et ios

## Bibliotèques

Les bibliotèques multiplatefrom utilisées :

- [sqldelight](https://github.com/square/sqldelight) : Stockage de l'historique en local 
- [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization/) : Pour la sérialisation
- [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) : Pour le threading
- [kodein](https://kodein.org/Kodein-DI/?5.2/getting-started) : Pour l'injection de dépendances
- [mockk](https://mockk.io/) : Pour les testes 
- [io.ktor](https://ktor.io/clients/http-client/multiplatform.html) : Pour les appels réseaux
