package com.Lenvill;

import com.Lenvill.proxy.CommonProxy;
import com.ferreusveritas.dynamictrees.ModConstants;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = DynamicTreesMFR.MODID, name = DynamicTreesMFR.NAME, version = DynamicTreesMFR.VERSION, dependencies = DynamicTreesMFR.DEPENDECIES)
public class DynamicTreesMFR {
    public static final String MODID = "dynamictreesmfr";
    public static final String NAME = "Dynamic Trees for Minefantasy: Reforged";
    public static final String VERSION = "0.0.1";
    public static final String DEPENDECIES = "required-after:minefantasyreforged;required-after:" + ModConstants.DYNAMICTREES_LATEST +";";

    @Mod.Instance
    public static DynamicTreesMFR instance;
    @SidedProxy(clientSide = "com.Lenvill.proxy.ClientProxy", serverSide = "com.Lenvill.proxy.CommonProxy")
    public static CommonProxy PROXY;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        PROXY.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        PROXY.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        PROXY.postInit();
    }
}