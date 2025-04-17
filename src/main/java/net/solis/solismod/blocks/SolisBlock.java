package net.solis.solismod.blocks;

import com.ibm.icu.impl.CacheValue;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.solis.solismod.SolisMod;

public class SolisBlock {

    public static final Block THESOLISBLOCK = registerBlock("solis_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
            .requiresTool().sounds(BlockSoundGroup.COBWEB))
        );


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);;
        return Registry.register(Registries.BLOCK, Identifier.of(SolisMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(SolisMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerSolisBlock(){
        SolisMod.LOGGER.info("TEST");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
            entries.add(SolisBlock.THESOLISBLOCK);
        });
    }
}
