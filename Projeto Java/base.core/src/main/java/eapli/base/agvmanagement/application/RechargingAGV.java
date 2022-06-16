package eapli.base.agvmanagement.application;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.domain.Battery;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import javax.persistence.Persistence;

public class RechargingAGV {

    AGVRepository agvRepository = PersistenceContext.repositories().agv();

    public void main(String id) {
        AGV agv = agvRepository.findById(id);
        Recharging rechargeAGV = new Recharging(agv);
        Thread thread = new Thread(rechargeAGV);
        thread.start();
    }



    static class Recharging extends Thread {

        private final UpdateStatusFreeService updateStatusFreeService = new UpdateStatusFreeService();
        private final AssignAGVService assignAGVService = new AssignAGVService();
        private final AGVRepository agvRepository = PersistenceContext.repositories().agv();
        private final double RECHARGING_VALUE = 5;
        private
        AGV agv;
        public Recharging(AGV agv){
            this.agv = agv;
        }


        @Override
        public void run () {

            while (agv.Battery().battery() < agv.Autonomy().autonomy()){
                double battery = agv.Battery().battery();
                battery+=RECHARGING_VALUE;

                if (battery >= agv.Autonomy().autonomy()){
                    battery = agv.Autonomy().autonomy();
                }
                Battery newBattery = new Battery(battery);

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                agv.modifyBattery(newBattery);
                agvRepository.save(agv);
            }

            updateStatusFreeService.updateStatusFreeService(agv.identity().AgvIdentifier());
            assignAGVService.assignAGVService();
        }
    }

}
