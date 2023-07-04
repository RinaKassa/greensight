# Empty methods will end up consumming CPU and RAM although they do nothing (avoid-empty-methods)

Keeping methods with empty body in the code can lead to increased memory and cpu usage.
To conform to Green IT best pratices it is recommended to remove them.

## Rule Details

This rule aims to...

Examples of **incorrect** code for this rule:

```js

function empty(){

}

```

Examples of **correct** code for this rule:

```js

function notEmpty(){
    return 2+2
}

```
