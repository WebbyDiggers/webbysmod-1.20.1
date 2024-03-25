package net.webbywebbysmod.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.webbywebbysmod.WebbysMod;
import net.webbywebbysmod.items.custom.CuringBlockItem;

public class ModItems {
    public static final Item CURINGBLOCK = registerItem("curingblock", new CuringBlockItem(new FabricItemSettings()));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries){
        entries.add(CURINGBLOCK);
    }
    private  static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(WebbysMod.MOD_ID,name),item);
    }
    public static void registerModItems() {
        WebbysMod.LOGGER.info("Registering mod items for " + WebbysMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }

}
