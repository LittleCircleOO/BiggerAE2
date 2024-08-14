package cn.dancingsnow.bigger_ae2.client;

import appeng.api.IAEAddonEntrypoint;
import appeng.client.render.SimpleModelLoader;
import appeng.client.render.crafting.CraftingCubeModel;
import cn.dancingsnow.bigger_ae2.BiggerAE2Base;
import cn.dancingsnow.bigger_ae2.BiggerAE2Mod;
import cn.dancingsnow.bigger_ae2.block.ModCraftingUnitType;
import cn.dancingsnow.bigger_ae2.init.ModBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.minecraft.client.renderer.RenderType;

@Environment(EnvType.CLIENT)
public class BiggerAE2Client extends BiggerAE2Base implements IAEAddonEntrypoint {
    @Override
    public void onAe2Initialized() {
        super.init();
        initCraftingUnitModels();
        BiggerAE2Mod.REGISTRATE.register();
    }

    private static void initCraftingUnitModels() {
        for (ModCraftingUnitType type : ModCraftingUnitType.values()) {
            ModelLoadingRegistry.INSTANCE
                    .registerResourceProvider(resourceManager -> new SimpleModelLoader<>
                            (BiggerAE2Mod.of("block/crafting/" + type.getAffix() + "_formed"),
                                    () -> new CraftingCubeModel(new ModCraftingUnitModelProvider(type))));
        }

        setRenderLayer();
    }

    private static void setRenderLayer() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACCELERATOR_4.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACCELERATOR_16.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACCELERATOR_64.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACCELERATOR_256.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACCELERATOR_1024.get(), RenderType.cutout());
    }
}
