package net.vix.gacow.item;

import net.minecraft.block.BlockState;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.vix.gacow.entity.ModEntities;

public class GoldenAppleCowSpawnEgg extends Item {

    public GoldenAppleCowSpawnEgg(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();

        // Ensure we are on the server side (logic side)
        if (!(world instanceof ServerWorld)) {
            return ActionResult.SUCCESS;
        }

        BlockPos pos = context.getBlockPos();
        Direction direction = context.getSide();
        BlockState state = world.getBlockState(pos);

        // Calculate spawn position (if block is solid, spawn on top/side)
        BlockPos spawnPos;
        if (state.getCollisionShape(world, pos).isEmpty()) {
            spawnPos = pos;
        } else {
            spawnPos = pos.offset(direction);
        }

        // The Magic Line: Spawn the Cow!
        ModEntities.GOLDEN_APPLE_COW.spawn(
                (ServerWorld) world,
                spawnPos,
                SpawnReason.TRIGGERED // <--- CHANGED THIS (Safe universal option)
        );

        // Consume 1 egg from inventory (unless in Creative)
        if (context.getPlayer() != null && !context.getPlayer().isCreative()) {
            context.getStack().decrement(1);
        }

        return ActionResult.CONSUME;
    }
}