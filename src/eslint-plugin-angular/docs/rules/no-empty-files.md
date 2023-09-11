# Disallow empty files present in the project (no-empty-files)

In Angular, most of the developers use Angular CLI to create new components, modules, etc... The issue is that it's often generate empty files that are never going to be used.
To conform to the Green IT best pratices it is recommended to remove empty files.

## Rule Details

This rule aims to check any files that are empty or containing comments only. If the file is empty or containing comments only then the file is highlighted as **error** and the file should be removed manually from the project.

Examples of **incorrect** code for this rule:

sample-empty-file.js
```js
```

sample-commented-file.js
```js
//
```
or
```js
/* Comment */
```

sample-code-commented-file.js
```js
// // say Hello world
// function sayHelloWorld() {
// 	console.log('Hello world');
// }
```

Example of **correct** code for this rule:

```js
var x = 5;
var y = 10;
// This function simply add x and y and return the value 15
function addxy(){
    return x + y;
}
```
