### Project name: typescript-demo

* **how to run:** `tsc`, and after that `node dist`  
* **for testing:** _mocha_ and _chai_ (ts-node is also must)  
* **how to init typescript project:**  
* run `tsc --init` - tsconfig.json  
* you can tsc [some files] or just run tsc and put files inside config file  
* **entry point** The "files" property takes a list of relative or absolute file paths. The "include" and "exclude" properties take a list of glob-like file patterns. 

### How did I debug mocha tests?
I put **--debug-brk** in npm test script. Also, I went to debug tab of VSCode, click gear icon to generate launch.json and choose to attach to proccess on certain port.

### Typescript

**Interfaces**
One of TypeScript’s core principles is that type-checking focuses on the shape that values have. This is sometimes  called “duck typing” or “structural subtyping”.