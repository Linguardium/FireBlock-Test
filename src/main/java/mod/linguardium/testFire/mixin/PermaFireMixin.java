package mod.linguardium.testFire.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static mod.linguardium.testFire.testFire.PERMAFIRE_BLOCKS_TAG;

@Mixin(FireBlock.class)
public class PermaFireMixin {
    @Redirect(at=@At(value="INVOKE",target="Lnet/minecraft/block/BlockState;getBlock()Lnet/minecraft/block/Block;"),method="scheduledTick")
    private Block getPermaFireBlock(BlockState state) {
        Block block = state.getBlock();
        if (PERMAFIRE_BLOCKS_TAG.contains(block)) {
            return Blocks.NETHERRACK;
        }
        return block;
    }
}
