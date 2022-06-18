REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=base.daemon.agvDigitalTwin\target\base.daemon.agvDigitalTwin-1.4.0-SNAPSHOT.jar;base.daemon.agvDigitalTwin\target\dependency\*;

REM call the java VM, e.g,
java -cp %BASE_CP% daemon.agvdigitaltwin.AGVDigitalTwinDaemon
