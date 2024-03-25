package net.webbywebbysmod.entity.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.webbywebbysmod.entity.ModEntities;
import net.webbywebbysmod.items.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;

public class SculkCureProjectileEntity extends ThrownItemEntity {
        public SculkCureProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }
    public SculkCureProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.SCULK_CURE_PROJECTILE,livingEntity, world);
    }
    @Override
    protected Item getDefaultItem(){

        return ModItems.CURINGBLOCK;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {

        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if(!this.method_48926().isClient()){
            int SculkFound = 0;
            this.method_48926().sendEntityStatus(this, (byte)3);
            BlockPos pos = getBlockPos();

            Iterator var8 = BlockPos.iterateOutwards(pos, 5, 2, 5).iterator();

            while(var8.hasNext())
            {
                BlockPos blockPos = (BlockPos)var8.next();
                BlockState blockState = this.method_48926().getBlockState(blockPos);
                Block block = blockState.getBlock();
                if(block == Blocks.SCULK || block == Blocks.SCULK_VEIN  || block == Blocks.SCULK_SENSOR || block == Blocks.SCULK_CATALYST || block == Blocks.SCULK_SHRIEKER) {
                    SculkFound =SculkFound+1;
                    this.method_48926().setBlockState(blockPos, Blocks.AIR.getDefaultState());
                    //
                }
                double rnd = Math.random();
                System.out.println("SculkFound " + SculkFound + ":" + rnd );
                if (rnd > 0.99 && SculkFound ==1) {
                    this.method_48926().setBlockState(blockPos, Blocks.VERDANT_FROGLIGHT.getDefaultState());
                }
            }


        }
        this.discard();

        super.onBlockHit(blockHitResult);
    }
}
