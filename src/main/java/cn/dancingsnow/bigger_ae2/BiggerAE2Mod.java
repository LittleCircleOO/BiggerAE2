package cn.dancingsnow.bigger_ae2;


import appeng.api.storage.StorageCells;
import appeng.api.upgrades.Upgrades;
import appeng.core.definitions.AEItems;
import appeng.core.localization.GuiText;
import cn.dancingsnow.bigger_ae2.init.ModBlockEntities;
import cn.dancingsnow.bigger_ae2.init.ModBlocks;
import cn.dancingsnow.bigger_ae2.init.ModCreativeTab;
import cn.dancingsnow.bigger_ae2.init.ModItems;
import cn.dancingsnow.bigger_ae2.item.cell.DigitalSingularityCellItem;
import com.mojang.logging.LogUtils;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

public class BiggerAE2Mod {

    public static final String MOD_ID = "bigger_ae2";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation makeId(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static void init() {

        //Block
        for (var block : ModBlocks.getBlocks()) {
            Registry.register(BuiltInRegistries.BLOCK, block.id(), block.block());
            Registry.register(BuiltInRegistries.ITEM, block.id(), block.asItem());
        }

        //Item
        for (var item : ModItems.getItems()) {
            Registry.register(BuiltInRegistries.ITEM, item.id(), item.asItem());
        }

        //CreativeTab
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, makeId("tab"), ModCreativeTab.TAB);

        //BlockEntity
        for (var blockEntity : ModBlockEntities.getBlockEntityTypes().entrySet()) {
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, blockEntity.getKey(), blockEntity.getValue());
        }

        //REMOVED:AppliedFluxIntegration

        initUpgrades();
        initStorageCells();

    }

    public static ResourceLocation of(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    private static void initUpgrades() {
        var storageCellGroup = GuiText.StorageCells.getTranslationKey();

        Upgrades.add(AEItems.VOID_CARD, ModItems.QUANTUM_ITEM_CELL, 1, storageCellGroup);
        Upgrades.add(AEItems.VOID_CARD, ModItems.SINGULARITY_ITEM_CELL, 1, storageCellGroup);
        Upgrades.add(AEItems.VOID_CARD, ModItems.QUANTUM_FLUID_CELL, 1, storageCellGroup);
        Upgrades.add(AEItems.VOID_CARD, ModItems.SINGULARITY_FLUID_CELL, 1, storageCellGroup);
    }

    private static void initStorageCells() {
        StorageCells.addCellHandler(DigitalSingularityCellItem.HANDLER);
    }
}
