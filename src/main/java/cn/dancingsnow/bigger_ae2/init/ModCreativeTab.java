package cn.dancingsnow.bigger_ae2.init;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

public class ModCreativeTab {

    public static final CreativeModeTab TAB = FabricItemGroup.builder()
            .title(Component.translatable("itemGroup.bigger_ae2.bigger_ae2"))
            .icon(ModItems.SINGULARITY_ITEM_CELL::stack)

            .displayItems((parameters, output) -> {

                output.accept(ModItems.ADVANCED_ITEM_CELL_HOUSING);
                output.accept(ModItems.ADVANCED_FLUID_CELL_HOUSING);

                output.accept(ModItems.QUANTUM_CELL_COMPONENT);
                output.accept(ModItems.QUANTUM_ITEM_CELL);
                output.accept(ModItems.QUANTUM_FLUID_CELL);

                output.accept(ModItems.SINGULARITY_CELL_COMPONENT);
                output.accept(ModItems.SINGULARITY_ITEM_CELL);
                output.accept(ModItems.SINGULARITY_FLUID_CELL);

                output.accept(ModBlocks.ACCELERATOR_4);
                output.accept(ModBlocks.ACCELERATOR_16);
                output.accept(ModBlocks.ACCELERATOR_64);
                output.accept(ModBlocks.ACCELERATOR_256);
                output.accept(ModBlocks.ACCELERATOR_1024);
            })
            .build();

}
