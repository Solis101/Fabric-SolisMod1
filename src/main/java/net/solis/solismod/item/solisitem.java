package net.solis.solismod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.solis.solismod.SolisMod;
import net.minecraft.util.Identifier;

public class solisitem {

   public static final Item SOLISITEM = registerItem("solis_item", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
       return Registry.register(Registries.ITEM, Identifier.of(SolisMod.MOD_ID, name), item);
   }

    public static void registerSolisItems(){
        SolisMod.LOGGER.info("Registering Mod Items for " + SolisMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(SOLISITEM);
        });
    }
}
