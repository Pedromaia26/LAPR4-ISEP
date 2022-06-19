REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=base.core\target\base.core-1.4.0-SNAPSHOT.jar;base.core\target\dependency\*;

REM call the java VM, e.g,
java -cp %BASE_CP% eapli.base.dashboardmanagement.HttpServerAjax


