package com.unsignedcharcoal.football.modules.team;

import java.util.UUID;

public class TeamPlayer implements TeamEntity {

    @Override
    public TeamRole getTeamRole() {
        return null;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public UUID getUniqueId() {
        return null;
    }

    @Override
    public long getJoinedTime() {
        return 0;
    }

    @Override
    public long getLeftTime() {
        return 0;
    }
}
