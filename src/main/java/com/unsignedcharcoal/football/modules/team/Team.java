package com.unsignedcharcoal.football.modules.team;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Serdeable
@MappedEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    private String namespace;
    private String name;
    private List<TeamEntity> teamMembers;

}
