package cn.dancingsnow.bigger_ae2.init;

import appeng.block.crafting.CraftingUnitBlock;
import appeng.core.definitions.BlockDefinition;
import appeng.block.AEBaseBlockItem;
import cn.dancingsnow.bigger_ae2.BiggerAE2Mod;
import cn.dancingsnow.bigger_ae2.block.ModCraftingUnitType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class ModBlocks {

    private static final List<BlockDefinition<?>> BLOCKS = new ArrayList<>();

    public static List<BlockDefinition<?>> getBlocks() {
        return Collections.unmodifiableList(BLOCKS);
    }

    public static final BlockDefinition<CraftingUnitBlock> ACCELERATOR_4 = block(
            "4 Core Crafting Accelerator",
            "4_core_crafting_accelerator",
            () -> new CraftingUnitBlock(ModCraftingUnitType.ACCELERATOR_4),
            AEBaseBlockItem::new);

    public static final BlockDefinition<CraftingUnitBlock> ACCELERATOR_16 = block(
            "16 Core Crafting Accelerator",
            "16_core_crafting_accelerator",
            () -> new CraftingUnitBlock(ModCraftingUnitType.ACCELERATOR_16),
            AEBaseBlockItem::new);

    public static final BlockDefinition<CraftingUnitBlock> ACCELERATOR_64 = block(
            "64 Core Crafting Accelerator",
            "64_core_crafting_accelerator",
            () -> new CraftingUnitBlock(ModCraftingUnitType.ACCELERATOR_64),
            AEBaseBlockItem::new);

    public static final BlockDefinition<CraftingUnitBlock> ACCELERATOR_256 = block(
            "256 Core Crafting Accelerator",
            "256_core_crafting_accelerator",
            () -> new CraftingUnitBlock(ModCraftingUnitType.ACCELERATOR_256),
            AEBaseBlockItem::new);

    public static final BlockDefinition<CraftingUnitBlock> ACCELERATOR_1024 = block(
            "1024 Core Crafting Accelerator",
            "1024_core_crafting_accelerator",
            () -> new CraftingUnitBlock(ModCraftingUnitType.ACCELERATOR_1024),
            AEBaseBlockItem::new);

    public static <T extends Block> BlockDefinition<T> block(
            String englishName,
            String id,
            Supplier<T> blockSupplier,
            BiFunction<Block, Item.Properties, BlockItem> itemFactory) {
        var block = blockSupplier.get();
        var item = itemFactory.apply(block, new Item.Properties());

        var definition = new BlockDefinition<>(englishName, BiggerAE2Mod.makeId(id), block, item);
        BLOCKS.add(definition);
        return definition;
    }

}
