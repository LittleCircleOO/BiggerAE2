package cn.dancingsnow.bigger_ae2.init;

import appeng.api.stacks.AEKeyType;
import appeng.core.definitions.ItemDefinition;
import appeng.items.materials.MaterialItem;
import appeng.items.materials.StorageComponentItem;
import appeng.items.storage.BasicStorageCell;
import cn.dancingsnow.bigger_ae2.BiggerAE2Mod;
import cn.dancingsnow.bigger_ae2.item.cell.DigitalSingularityCellItem;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.function.Function;

public class ModItems {

    private static final List<ItemDefinition<?>> ITEMS = new ArrayList<>();

    public static List<ItemDefinition<?>> getItems() {
        return Collections.unmodifiableList(ITEMS);
    }

    public static final ItemDefinition<MaterialItem> ADVANCED_ITEM_CELL_HOUSING =
            item("Advanced Item Cell Housing","advanced_item_cell_housing",MaterialItem::new);

    public static final ItemDefinition<MaterialItem> ADVANCED_FLUID_CELL_HOUSING =
            item("Advanced Fluid Cell Housing","advanced_fluid_cell_housing",MaterialItem::new);

    public static final ItemDefinition<StorageComponentItem> QUANTUM_CELL_COMPONENT =
            item("Quantum Cell Component","quantum_cell_component", p -> new StorageComponentItem(p, 1 << 28 - 1));

    public static final ItemDefinition<BasicStorageCell> QUANTUM_ITEM_CELL =
            item("Quantum Item Storage Cell","quantum_item_storage_cell", p -> new BasicStorageCell(
                    p.stacksTo(1),
                    QUANTUM_CELL_COMPONENT,
                    ADVANCED_ITEM_CELL_HOUSING,
                    20,
                    (1 << 28 - 1) / 1024,
                    65536,
                    1,
                    AEKeyType.items()
            ));

    public static final ItemDefinition<BasicStorageCell> QUANTUM_FLUID_CELL =
            item("Quantum Fluid Storage Cell","quantum_fluid_storage_cell", p -> new BasicStorageCell(
                    p.stacksTo(1),
                    QUANTUM_CELL_COMPONENT,
                    ADVANCED_FLUID_CELL_HOUSING,
                    20,
                    (1 << 28 - 1) / 1024,
                    65536,
                    1,
                    AEKeyType.fluids()
            ));

    public static final ItemDefinition<MaterialItem> SINGULARITY_CELL_COMPONENT =
            item("Digital Singularity Cell Component","digital_singularity_cell_component", MaterialItem::new);

    public static final ItemDefinition<DigitalSingularityCellItem> SINGULARITY_ITEM_CELL =
            item("Digital Singularity Item Storage Cell","digital_singularity_item_storage_cell", p -> new DigitalSingularityCellItem(
                    p,
                    AEKeyType.items(),
                    SINGULARITY_CELL_COMPONENT,
                    ADVANCED_ITEM_CELL_HOUSING
            ));

    public static final ItemDefinition<DigitalSingularityCellItem> SINGULARITY_FLUID_CELL =
            item("Digital Singularity Fluid Storage Cell","digital_singularity_fluid_storage_cell", p -> new DigitalSingularityCellItem(
                    p,
                    AEKeyType.fluids(),
                    SINGULARITY_CELL_COMPONENT,
                    ADVANCED_FLUID_CELL_HOUSING
            ));

    public static <T extends Item> ItemDefinition<T> item(
            String englishName, String id, Function<Item.Properties, T> factory) {
        var definition = new ItemDefinition<>(englishName, BiggerAE2Mod.makeId(id), factory.apply(new Item.Properties()));
        ITEMS.add(definition);
        return definition;
    }

}
