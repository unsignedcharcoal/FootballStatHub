package com.unsignedcharcoal.football.modules.team;

import java.util.UUID;

public interface TeamEntity {

    TeamRole getTeamRole();

    String getName();

    UUID getUniqueId();

    long getJoinedTime();

    long getLeftTime();

}
