# eslint-plugin-greensight

eslint plugin for green IT oriented rules

## Installation

You'll first need to install [ESLint](https://eslint.org/):

```sh
npm i eslint --save-dev
```

Next, install `eslint-plugin-greensight`:

```sh
npm install eslint-plugin-greensight --save-dev
```

## Usage

Add `greensight` to the plugins section of your `.eslintrc` configuration file. You can omit the `eslint-plugin-` prefix:

```json
{
    "plugins": [
        "greensight"
    ]
}
```


Then configure the rules you want to use under the rules section.

```json
{
    "rules": {
        "greensight/rule-name": 2
    }
}
```

## Supported Rules

* Fill in provided rules here


