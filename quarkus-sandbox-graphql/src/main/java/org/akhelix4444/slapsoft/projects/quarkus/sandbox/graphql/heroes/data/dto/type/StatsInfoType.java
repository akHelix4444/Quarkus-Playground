package org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.data.dto.type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatsInfoType {

    private Integer intelligence;

    private Integer strength;

    private Integer speed;

    private Integer durability;

    private Integer power;

    private Integer combat;

    public StatsInfoType intelligence(Integer value) {
        intelligence = value;
        return this;
    }

    public StatsInfoType strength(Integer value) {
        strength = value;
        return this;
    }

    public StatsInfoType speed(Integer value) {
        speed = value;
        return this;
    }

    public StatsInfoType durability(Integer value) {
        durability = value;
        return this;
    }

    public StatsInfoType power(Integer value) {
        power = value;
        return this;
    }

    public StatsInfoType combat(Integer value) {
        combat = value;
        return this;
    }

}
