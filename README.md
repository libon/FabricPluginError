Sample project demonstrating compilation error with fabric gradle plugin 1.28.0.
===============================================================================

Steps to reproduce the error:

* Build the project: `./gradlew clean assembleDebug`
* Expected behavior: the project compiles
* Actual behavior:
```
A problem occurred configuring project ':submodule'.
> groovy.lang.MissingPropertyException: Could not get unknown property 'assemble' for task ':submodule:assembleDebug' of type org.gradle.api.Task.
```

Workaround 1:
-------------

Downgrade the fabric gradle plugin from `1.28.0` to `1.27.1`, in `submodule/build.gradle`


Workaround 2:
-------------

Move the fabric configuration from `submodule` to `app` (changes demonstrating this fix are in branch `workaround-move-fabric-to-app-module`)



