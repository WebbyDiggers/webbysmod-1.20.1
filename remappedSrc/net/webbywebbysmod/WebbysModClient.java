package net.webbywebbysmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.webbywebbysmod.entity.ModEntities;

public class WebbysModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.SCULK_CURE_PROJECTILE, FlyingItemEntityRenderer::new);
    }
}
