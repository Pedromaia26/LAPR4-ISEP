REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=base.daemon.agvManager\target\base.daemon.agvManager-1.4.0-SNAPSHOT.jar;base.daemon.agvManager\target\dependency\*;

REM call the java VM, e.g,
java -cp %BASE_CP% daemon.agvmanager.AGVManagerDaemon
