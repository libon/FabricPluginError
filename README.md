Sample project demonstrating missing crashlytics build id
=========================================================

Steps to reproduce the error:

* Build the project: `./gradlew clean assembleDebug`
* Install the app: `adb install app/build/outputs/apk/debug/app-debug.apk`
* Launch the app
* Expected behavior: an empty activity is launched
* Actual behavior: a crash:
```
Caused by: io.fabric.sdk.android.services.concurrency.UnmetDependencyException: The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.
  at com.crashlytics.android.core.CrashlyticsCore.onPreExecute(CrashlyticsCore.java:243)
  at com.crashlytics.android.core.CrashlyticsCore.onPreExecute(CrashlyticsCore.java:211)
  at io.fabric.sdk.android.InitializationTask.onPreExecute(InitializationTask.java:44)
  at io.fabric.sdk.android.services.concurrency.AsyncTask.executeOnExecutor(AsyncTask.java:611)
  at io.fabric.sdk.android.services.concurrency.PriorityAsyncTask.executeOnExecutor(PriorityAsyncTask.java:43)
  at io.fabric.sdk.android.Kit.initialize(Kit.java:69)
  at io.fabric.sdk.android.Fabric.initializeKits(Fabric.java:466)
  at io.fabric.sdk.android.Fabric.init(Fabric.java:410)
  at io.fabric.sdk.android.Fabric.setFabric(Fabric.java:368)
  at io.fabric.sdk.android.Fabric.with(Fabric.java:359)
  at com.example.FabricInit.initFabric(FabricInit.kt:19)
  at com.example.fabricpluginerror.MyApplication.onCreate(MyApplication.kt:9)
  at android.app.Instrumentation.callApplicationOnCreate(Instrumentation.java:1028)
  at android.app.ActivityThread.handleBindApplication(ActivityThread.java:5658)
```

Workaround:
-----------

Add an empty resources file in `submodules/src/main/res/values/donottranslate_strings.xml`, with this content:
```xml
<resources/>
```

More info:
----------
Without the workaround, the following errors appear in the gradle build log:
```
Crashlytics couldn't find the res folder specified in sourceSets.main.res, please make one. It picked: src/main/res
Crashlytics couldn't find the res folder specified in sourceSets.main.res, please make one. It picked: src/main/res
```

Without the workaround, the following file isn't generated:
`submodule/build/generated/fabric/res/debug/values/com_crashlytics_build_id.xml`
