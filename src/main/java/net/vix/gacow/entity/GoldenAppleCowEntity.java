package net.vix.gacow.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class GoldenAppleCowEntity extends CowEntity {

    public GoldenAppleCowEntity(EntityType<? extends CowEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public CowEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        return new GoldenAppleCowEntity((EntityType<? extends CowEntity>) this.getType(), serverWorld);
    }
}