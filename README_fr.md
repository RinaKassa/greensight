# Greensight plugin

- [Préambule](#préambule)
  - [Structure des dossiers](#structure-des-dossiers)
- [Prérequis](#prérequis)
- [Installation](#installation)
  - [Développement sur le front (Js, Vue.js ...)](#développement-sur-le-front-js-vuejs)
    - [Extensions VSCode - obligatoire](#extensions-vscode---obligatoire)
    - [Extension navigateur web](#extension-navigateur-web)
  - [Développement sur le back (Java)](#développement-sur-le-back-java)
- [Utilisation](#utilisation)
  - [npm run start (ou npm start)](#npm-run-start-ou-npm-start)
  - [npm run build](#npm-run-build)
  - [mvn package](#mvn-package)
  - [npm run lint](#npm-run-lint)
  - [npx webpack --analyze](#npx-webpack---analyze)
- [Notes](#notes)
  - [Communication entre le back et le front](#communication-entre-le-back-et-le-front)
  - [Browserslist dans package.json](#browserslist-dans-packagejson)
  - [Technos Front](#technos-front)
    - [Webpack](#webpack)
    - [Babel](#babel)
    - [Postcss](#postcss)
  - [Différences prod/dev](#différences-proddev)
    - [Webpack](#webpack-1)
    - [CSS](#css)
- [Lexique](#lexique)
  - [Bundle](#bundle)
  - [Profil qualités (quality profile)](#profil-qualités-quality-profile)
  - [Règles (checks ou rules)](#règles-checks-ou-rules)

## Préambule

La documentation jongle entre deux parties du projet :

- Le Back (aussi appelé backend) qui tourne sous Java. Il a les responsabilités suivantes :
  - Déclare le plugin dans Sonarqube, avec tous les profils de qualité et règles (aussi appelé checks).
  - Déclare la page additionnelle (le front).
  - Responsable du scan du code envoyé à Sonarqube et de lui signaler les problèmes trouvés dedans.
- Le Front (aussi appelé frontend) qui utilise npm avec Vue.js sous Javascript. Il a les responsabilités suivantes :
  - Affiche la page additionnelle sur Sonarqube.

### Structure des dossiers

- src/
  - eslint-plugin-greensight/
    - plugin Greensight pour ESLint
  - main/
    - assets/
      - Contient les images utilisées par le front.
    - java/
      - Code du back (java).
    - js/
      - Code du front (js, css...).
    - resources/
      - Utilisé par le backend.
      - Contient pour chaque règle de Greensight un fichier HTML et JSON.
      - Ces deux fichiers permettent de fournir des informations complémentaires à Sonarqube à propos de nos règles.
  - test/
    - java/
      - Contient le code de test du back
    - test_files/
      - Contient les fichiers sur lesquels les règles vont être testées
- target/
  - Contient les fichiers compilés
  - A la fin de la commande `mvn package` le plugin au format .jar devrait être présent dedans.

## Prérequis

Les outils ci-dessous doivent être accessibles avec la variable d'environnement `PATH`.

- Node.js LTS (v16+) [lien](https://nodejs.org/en/download/)
- jdk 11 [lien](https://www.oracle.com/fr/java/technologies/javase/jdk11-archive-downloads.html) (un compte Oracle doit être créé pour pouvoir télécharger le fichier)
- Maven (3+) [lien](https://maven.apache.org/download.cgi)
- Sonarqube (Version 8.9.9 build 56886 ou +) prendre l'édition `Community`[lien](https://www.sonarqube.org/downloads/?gads_campaign=Europe-4-SonarQube&gads_ad_group=SonarQube&gads_keyword=sonarqube&gclid=CjwKCAjw7p6aBhBiEiwA83fGuusFBDehBiqISzSusttsOaoHLN36b5tmHFGbzX3zpATnZ2Fm6iQAPBoCBw8QAvD_BwE)

Une fois les logiciels installés, vérifier que les commandes ci-dessous fonctionnent:

```bash
$ npm -v
8.15.0
```

```bash
$ node -v
v16.16.0
```

```bash
$ java --version
java 11.0.15.1 2022-04-22 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.15.1+2-LTS-10)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.15.1+2-LTS-10, mixed mode)
```

```bash
$ mvn -v
Apache Maven 3.8.6 (84538c9988a25aec085021c365c560670ad80f63)
Maven home: C:\Users\tviolent\scoop\apps\maven\current
Java version: 11.0.15.1, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-11.0.15.1
Default locale: fr_FR, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```

## Installation

```powershell
mvn install
```

Maven va installer l'environnement node.

### Développement sur le front (Js, Vue.js ...)

Il est recommandé d'utiliser VSCode pour le développement du front.

#### Extensions VSCode - obligatoire

- [EditorConfig for VS Code](https://marketplace.visualstudio.com/items?itemName=EditorConfig.EditorConfig)
- [Prettier - Code formatter](https://marketplace.visualstudio.com/items?itemName=esbenp.prettier-vscode)
- [ESLint](https://marketplace.visualstudio.com/items?itemName=dbaeumer.vscode-eslint)

### Développement sur le back (Java)

InteliJ IDEA est recommandé pour le back.  
Pour exécuter les tests unitaires JUnit, IDEA doit être configuré comme ci-dessous :

![](docs/Debug%20config%20InteliJ%20IDEA.png)

## Utilisation

**Avant de lancer les commandes ci-dessous, assurez-vous que Sonarqube soit démarré et opérationnel.**

### npm run start (ou npm start)

Démarre le serveur de développement.

### npm run build

Permet de produire un build prêt pour la production. Cette commande sera utilisée par maven lors du package.  
**Cette commande ne doit pas être exécutée manuellement** sauf pour tester le bon fonctionnement de webpack.

### mvn package

Permet de générer un jar prêt pour la production.

### npm run lint

Exécute eslint et affiche tous les problèmes dans le code.  
Toute la configuration de eslint est dans [.eslintrc.js](.eslintrc.js)

Pour faire un eslint fix :

```powershell
npm run lintfix
```

### npx webpack --analyze

Permet de voir le contenu du bundle webpack. Utile pour savoir ce qui prend de la place dans le bundle.

Vous pouvez aussi préciser l'environnement, pour comparer les builds de dev à la prod :

```powershell
npx webpack --analyze --node-env production
# ou
npx webpack --analyze --node-env development
```

## Notes

### Communication entre le back et le front

- Le front et le back **ne communiquent jamais directement entre-eux**
- Toutes les informations passent par Sonarqube. Le front utilise l'API de Sonarqube pour récupérer toutes les informations dont il a besoin.

La documentation de l'API est accessible dans Sonarqube (point d'interrogation blanc -> Web API):

![](docs/doc%20webapi%20sonarqube.png)

### Browserslist dans package.json

Dans [package.json](package.json) il y a ceci :

```json
"browserslist": [
  "defaults"
]
```

Cela permet d'informer babel, postcss et webpack des navigateurs que l'on souhaite supporter, ceci peut avoir un impact
sur la taille du bundle

### Technos Front

#### Webpack

Voir [webpack.config.js](webpack.config.js)  
Bundler pour maven et le serveur de développement.

#### Babel

Voir [babel.config.js](babel.config.js)  
Compile le code javascript, assure la compatibilité du code avec d'anciens navigateurs internet.

:information_source: Voir browserlist pour définir la liste des navigateurs compatibles.

#### Postcss

Voir [postcss.config.js](postcss.config.js)  
Compile le css et assure la compatibilité du code avec d'anciens navigateurs internet.

:information_source: voir browserlist pour définir la liste des navigateurs compatibles.

### Différences prod/dev

#### Webpack

Le paramètre important est le premier dans [webpack.config.js](webpack.config.js): `mode`.
Il permet d'activer ou non toutes les optimisations de webpack en mode production.

:warning: Les builds de prod n'ont pas de source-map, aussi bien pour le css que le js. Ce qui réduit drastiquement la 
taille des fichiers mais rend le débogage plus difficile (voir impossible).

#### CSS

En développement, webpack utilise `style-loader`. Le css est donc inséré en inline dans le bundle `view.js`.

En production,
**Le css est inséré à la main, voir [index.jsx](src/main/js/greensight_tab/index.jsx)**.
Webpack avec le plugin `MiniCssExtractPlugin` sort un fichier css appart.  
Ceci à plusieurs avantages :

- Chargement parallélisé du js et css.
- Permet l'utilisation aux mieux les caches de serveur web.
- Possibilité de minimizer le fichier css.

## Lexique

### Bundle

Fichiers sortis par webpack lors d'un build (aussi bien dev que prod).
Les fichiers de sortie se trouvent dans `target/classes/static`

### Profil qualités (quality profile)

Rassemble les règles pour un langage en particulier.  
Il y a au moins un profil par langage mais il est possible d'avoir des quality profiles avec le même nom pour plusieurs langages de programmation.
Exemple : `Sonar way` est présent sur pratiquement tous les langages supportés par Sonarqube.
On peut aussi personnaliser les paramètres des règles (`@Ruleproperty` dans le code back) si celles-ci le permettent.

### Règles (checks ou rules)

Il s'agit d'une exigence pour le code, ces règles vérifient si le code répond aux critères définis.  
Si une ligne ou un bout de code transgresse une ou plusieurs règles, le back se charge de le signaler à Sonarqube.
