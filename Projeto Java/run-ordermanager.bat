REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=base.daemon.orderServer\target\base.daemon.orderServer-1.4.0-SNAPSHOT.jar;base.daemon.orderServer\target\dependency\*;

REM call the java VM, e.g,
java -cp %BASE_CP% daemon.ordermanager.OrderManagerDaemon


