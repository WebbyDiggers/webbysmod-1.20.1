package net.webbywebbysmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.webbywebbysmod.WebbysMod;
import net.webbywebbysmod.entity.custom.SculkCureProjectileEntity;


public class ModEntities {
    public static final EntityType<SculkCureProjectileEntity> SCULK_CURE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(WebbysMod.MOD_ID, "sculk_cure_projectile"), FabricEntityTypeBuilder.<SculkCureProjectileEntity>create(SpawnGroup.MISC, SculkCureProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f,0.25f)).build());
}
