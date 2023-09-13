# Check gitignore items for angular Project

This rules focus on the .gitignore file which define files and directories that will not be pushed on the GIT repository.

---

The goal here is to have basics rules for Angular based project and be sure that they are correctly set.
The list of rules that need to be present in the .gitignore file which is at the root of the directory are :
- /dist
- /tmp
- /out-tsc
- /bazel-out
- /node_modules
- npm-debug.log
- yarn-error.log
- .idea/
- .project
- .classpath
- .c9/
- *.launch
- .settings/
- *.sublime-workspace
- .vscode/*
- .history/*
- /.angular/cache
- .sass-cache/
- /connect.lock
- /coverage
- /libpeerconnection.log
- testem.log
- /typings
- .DS_Store
- Thumbs.db

Note: This is the basics rules defined by github for an Angular project.

To use this rule, you need to add the environment variable LINT_PATH for your project to be analyzed
example:
``
  set LINT_PATH=C:\Path\To\My-angular-application
``
