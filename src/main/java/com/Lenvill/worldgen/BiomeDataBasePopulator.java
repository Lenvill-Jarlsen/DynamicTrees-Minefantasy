package com.Lenvill.worldgen;

import com.Lenvill.DynamicTreesMFR;
import com.ferreusveritas.dynamictrees.ModConstants;
import com.ferreusveritas.dynamictrees.api.TreeRegistry;
import com.ferreusveritas.dynamictrees.api.worldgen.BiomePropertySelectors;
import com.ferreusveritas.dynamictrees.api.worldgen.BiomePropertySelectors.RandomSpeciesSelector;
import com.ferreusveritas.dynamictrees.api.worldgen.IBiomeDataBasePopulator;
import com.ferreusveritas.dynamictrees.trees.Species;
import com.ferreusveritas.dynamictrees.worldgen.BiomeDataBase;
import com.ferreusveritas.dynamictrees.worldgen.BiomeDataBase.Operation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.Loader;

public class BiomeDataBasePopulator implements IBiomeDataBasePopulator {

    private static Species yew, ironBark, ebony;

    public void populate(BiomeDataBase dbase) {

        yew = TreeRegistry.findSpecies(new ResourceLocation(DynamicTreesMFR.MODID, "yew"));
        ironBark = TreeRegistry.findSpecies(new ResourceLocation(DynamicTreesMFR.MODID, "ironBark"));
        ebony = TreeRegistry.findSpecies(new ResourceLocation(DynamicTreesMFR.MODID, "ebony"));

        Biome.REGISTRY.forEach(biome -> {
            if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.MOUNTAIN) && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.FOREST) && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.JUNGLE)) {
                RandomSpeciesSelector selector = new RandomSpeciesSelector().add(10).
                        add(yew, 2);
                dbase.setSpeciesSelector(biome, selector, Operation.SPLICE_BEFORE);

            } else if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SWAMP)) {
                RandomSpeciesSelector selector = new RandomSpeciesSelector().add(10).
                        add(ironBark, 5);
                dbase.setSpeciesSelector(biome, selector, Operation.SPLICE_BEFORE);

            } else if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.FOREST)) {
                RandomSpeciesSelector selector = new RandomSpeciesSelector().add(10).
                        add(ebony, 1);
                dbase.setSpeciesSelector(biome, selector, Operation.SPLICE_BEFORE);
            }
        });
    }
}
