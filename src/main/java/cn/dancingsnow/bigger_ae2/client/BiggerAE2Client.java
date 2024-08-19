package cn.dancingsnow.bigger_ae2.client;

import appeng.api.IAEAddonEntrypoint;
import appeng.client.render.crafting.CraftingCubeModel;
import cn.dancingsnow.bigger_ae2.BiggerAE2Base;
import cn.dancingsnow.bigger_ae2.BiggerAE2Mod;
import cn.dancingsnow.bigger_ae2.block.ModCraftingUnitType;
import cn.dancingsnow.bigger_ae2.init.ModBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.model.ModelResourceLocation;

@Environment(EnvType.CLIENT)
public class BiggerAE2Client extends BiggerAE2Base implements IAEAddonEntrypoint {
    @Override
    public void onAe2Initialized() {
        super.init();
        initCraftingUnitModels();
    }

    private static void initCraftingUnitModels() {
        for (ModCraftingUnitType type : ModCraftingUnitType.values()) {
            /*ModelLoadingRegistry.INSTANCE
                    .registerResourceProvider(resourceManager -> new SimpleModelLoader<>
                            (BiggerAE2Mod.of("block/crafting/" + type.getAffix() + "_formed"),
                                    () -> new CraftingCubeModel(new ModCraftingUnitModelProvider(type))));*/
            ModelLoadingPlugin.register(new ModelLoadingPlugin() {
                private final ModelResourceLocation MODEL = new ModelResourceLocation(BiggerAE2Mod.MOD_ID,"block/crafting/" + type.getAffix() + "_formed","");
                @Override
                public void onInitializeModelLoader(Context pluginContext) {
                    pluginContext.modifyModelOnLoad().register(((model, context) -> {
                        if(context.id().equals(MODEL)){
                            return new CraftingCubeModel(new ModCraftingUnitModelProvider(type));
                        }else{
                            return model;
                        }
                    }));
                }
            });
        }

        setRenderLayer();
    }

    private static void setRenderLayer() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACCELERATOR_4.block(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACCELERATOR_16.block(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACCELERATOR_64.block(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACCELERATOR_256.block(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACCELERATOR_1024.block(), RenderType.cutout());
    }
}
