# Greensight plugin

- [Preamble](#preamble)
  - [Folder structure](#folder-structure)
- [Requirement](#requirement)
- [Installation](#installation)
  - [Development about the front (Js, Vue.js ...)](#development-about-the-front-js-vuejs)
    - [Extensions VSCode - obligatory](#extensions-vscode---obligatory)
    - [Extension web browser](#extension-web-browser)
  - [Development about the back (Java)](#development-about-the-back-java)
- [Using](#using)
  - [npm run start (or npm start)](#npm-run-start-or-npm-start)
  - [npm run build](#npm-run-build)
  - [mvn package](#mvn-package)
  - [npm run lint](#npm-run-lint)
  - [npx webpack --analyze](#npx-webpack---analyze)
- [Notes](#notes)
  - [Communication between the back and the front](#communication-between-the-back-and-the-front)
  - [Browserslist in package.json](#browserslist-in-packagejson)
  - [Technos Front](#technos-front)
    - [Webpack](#webpack)
    - [Babel](#babel)
    - [Postcss](#postcss)
  - [Differences prod/dev](#différences-proddev)
    - [Webpack](#webpack-1)
    - [CSS](#css)
- [Lexicon](#lexicon)
  - [Bundle](#bundle)
  - [Quality profile](#quality-profile)
  - [Rules (or checks)](#rules-or-checks)

## Preamble

The documentation speak about two parts of the project :

- The Back (or backend) which run in Java. It has the nexts responsabilities :
  - Declare the plugin in Sonarqube, with all the qualities profiles and rules (or checks).
  - Declare the additional page (the front).
  - Responsable of the scan of the code sent for Sonarqube and report for him the problems found inside.
- The Front (or frontend) which use npm with Vue.js in Javascript. It has the nexts responsabilities :
  - Show additional page in Sonarqube.

### Folder structure

- src/
  - eslint-plugin-greensight/
    - plugin Greensight pour ESLint
  - main/
    - assets/
      - Contains images used by the front.
    - java/
      - Code of the back (java).
    - js/
      - Code of the front (js, css...).
    - resources/
      - Used by the backend.
      - Contains for all rules of Greensight a file HTML and JSON.
      - These two files provide additional information for Sonarqube about our rules.
  - test/
    - java/
      - Contains the code of test of the back.
    - test_files/
      - Contains the files on which the rules will be tested.
- target/
  - Contains the compiled files
  - At the end of the command `mvn package` the plugin in .jar format should be inside it.

## Requirement

The tools below must be accessible with the `PATH` environment variable.

- Node.js LTS (v16+) [link](https://nodejs.org/en/download/)
- jdk 11 [link](https://www.oracle.com/fr/java/technologies/javase/jdk11-archive-downloads.html) (an Oracle account must be created to download the file)
- Maven (3+) [link](https://maven.apache.org/download.cgi)
- Sonarqube (Version 8.9.9 build 56886 or +) take `Community` edition [link](https://www.sonarqube.org/downloads/?gads_campaign=Europe-4-SonarQube&gads_ad_group=SonarQube&gads_keyword=sonarqube&gclid=CjwKCAjw7p6aBhBiEiwA83fGuusFBDehBiqISzSusttsOaoHLN36b5tmHFGbzX3zpATnZ2Fm6iQAPBoCBw8QAvD_BwE)

Once the softwares are installed, verify that the commands below are working:

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

Maven will install the node environment.

### Development about the front (Js, Vue.js ...)

It is recommended to use VSCode for the development of the front.

#### Extensions VSCode - obligatory

- [EditorConfig for VS Code](https://marketplace.visualstudio.com/items?itemName=EditorConfig.EditorConfig)
- [Prettier - Code formatter](https://marketplace.visualstudio.com/items?itemName=esbenp.prettier-vscode)
- [ESLint](https://marketplace.visualstudio.com/items?itemName=dbaeumer.vscode-eslint)

### Development about the back (Java)

InteliJ IDEA is recommended for the back. 
To execute JUnit unit tests, IDEA must be configured as below :

![](docs/Debug%20config%20InteliJ%20IDEA.png)

## Using

**Before start the commands below, make sure Sonarqube is started and operational.**

### npm run start (or npm start)

Start the server of development.

### npm run build

Produces a build ready for production. This command will be used by maven during the package.  
**This command must not be executed manually** except to test the the functioning of webpack.

### mvn package

Generates a jar ready for the production.

### npm run lint

Executes eslint and show all problems in the code.  
All the configuration of eslint is in [.eslintrc.js](.eslintrc.js)

To do an eslint fix :

```powershell
npm run lintfix
```

### npx webpack --analyze

Allows to see the content of the web pack. Useful to know what takes up space in the bundle.

You can specify the environment, to compare the builds of dev until the prod :

```powershell
npx webpack --analyze --node-env production
# or
npx webpack --analyze --node-env development
```

## Notes

### Communication between the back and the front

- The front and the back **never communicate directly with each other**
- All informations pass by Sonarqube. The front uses the Sonarqube's API to recover all informations it needs.

The API's documentation is accessible in Sonarqube (white question mark-> Web API):

![](docs/doc%20webapi%20sonarqube.png)

### Browserslist in package.json

In [package.json](package.json) there is this code :

```json
"browserslist": [
  "defaults"
]
```

This code informs babel, postcss and webpack of the browsers that we want to support, this can have an impact 
on the size of the bundle.

### Technos Front

#### Webpack

See [webpack.config.js](webpack.config.js)  
Bundler for maven and the server of the development.

#### Babel

See [babel.config.js](babel.config.js)  
Compiles the javascript code, ensures the compatibility of the code with old internet browsers.

:information_source: See browserlist to define the list of the compatibles browsers.

#### Postcss

See [postcss.config.js](postcss.config.js)  
Compiles the css and ensures the compatibility of the code with old internet browsers.

:information_source: See browserlist to define the list of the compatibles browsers.

### Differences prod/dev

#### Webpack

The important parameter is the first in [webpack.config.js](webpack.config.js): `mode`.
It allows to activate or not all webpack optimizations in production mode.

:warning: the builds of prod haven't source-map, for css and js. This drastically reduces the 
file size but makes debugging more difficult (see impossible).

#### CSS

In development, webpack uses `style-loader`. The css is inserted inline in the bundle `view.js`.

In production,
**The css is not inserted automatically, see [index.jsx](src/main/js/greensight_tab/index.jsx)**.
Webpack with the plugin `MiniCssExtractPlugin` produces a css file.  
This has several advantages :

- Loading in parallel of js and css.
- Allows the best use of web server caches.
- Possibility to minimize the css file.

## Lexicon

### Bundle

Files released by webpack during a build (both dev and prod).
The output files are in `target/classes/static`

### Quality profile

Gathers rules for a particular language.
There is at least one profile per language but it is possible to have quality profiles with the same name for several programming languages.
Exemple : `Sonar way` is present on practically all the languages supported by Sonarqube.
You can also customize the parameters of the rules (`@Ruleproperty` in the code back) if they allow.

### Rules (or checks)

This is a requirement for the code, these rules check if the code meets the defined criteria.  
If one line or one piece of code transgresses one or more rules, the back takes charge of reporting it to Sonarqube.
