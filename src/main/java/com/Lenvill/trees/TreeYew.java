package com.Lenvill.trees;

import com.Lenvill.DynamicTreesMFR;
import com.Lenvill.ModContent;
import com.ferreusveritas.dynamictrees.trees.Species;
import com.ferreusveritas.dynamictrees.trees.TreeFamily;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.List;

public class TreeYew extends TreeFamily {

    public static Block leavesBlock = Block.getBlockFromName("minefantasyreforged:yew_leaves");
    public static Block logBlock = Blocks.LOG;
    public static Block saplingBlock = Block.getBlockFromName("minefantasyreforged:yew_sapling");

    public class SpeciesYew extends Species {
        SpeciesYew(TreeFamily treeFamily) {
            super(treeFamily.getName(), treeFamily, ModContent.yewLeavesProperties);
            setBasicGrowingParameters(0.3f, 12.0f, upProbability, lowestBranchHeight, 0.8f);

            envFactor(Type.COLD, 0.75f);
            envFactor(Type.DRY, 0.50f);
            envFactor(Type.SWAMP, 1.05f);

            generateSeed();
            setupStandardSeedDropping();
        }
        @Override
        public boolean isBiomePerfect(Biome biome) {
            return BiomeDictionary.hasType(biome, Type.SWAMP);
        }
    }

    public TreeYew() {
        super(new ResourceLocation(DynamicTreesMFR.MODID, "yew"));

        setPrimitiveLog(logBlock.getDefaultState(), new ItemStack(logBlock, 1, 0));

        ModContent.yewLeavesProperties.setTree(this);

        addConnectableVanillaLeaves((state) -> state.getBlock() == leavesBlock);
    }

    @Override
    public void createSpecies() {
        setCommonSpecies(new SpeciesYew(this));
    }

    @Override
    public void registerSpecies(IForgeRegistry<Species> speciesRegistry) {
        super.registerSpecies(speciesRegistry);
    }

    @Override
    public List<Item> getRegisterableItems(List<Item> itemList) {
        return super.getRegisterableItems(itemList);
    }
}
