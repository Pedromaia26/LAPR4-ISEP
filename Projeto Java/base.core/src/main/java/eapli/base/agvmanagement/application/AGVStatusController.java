package eapli.base.agvmanagement.application;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.repositories.AGVRepository;

public interface AGVStatusController {

    boolean updateStatus(String id);

    boolean updateStatusFree(String id);
}
