package com.trbz_.simplysteel.util;

import com.trbz_.simplysteel.SimplySteel;
import com.trbz_.simplysteel.armor.SteelArmorMaterial;
import com.trbz_.simplysteel.blocks.SteelAnvilBlock;
import com.trbz_.simplysteel.entities.FallingSteelAnvil;
import com.trbz_.simplysteel.entities.SteelGolem;
import com.trbz_.simplysteel.items.RNGFlintAndSteelItem;
import com.trbz_.simplysteel.tools.SteelItemTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SimplySteel.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SimplySteel.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, SimplySteel.MOD_ID);

    public static void init(){

        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    //Items

    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final net.minecraftforge.registries.RegistryObject<Item> CRUDE_IRON = ITEMS.register("crude_iron", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final net.minecraftforge.registries.RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    //Blocks

    public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", () -> new Block(Block.Properties
            .of(Material.METAL)
            .strength(7.0F,10.0F)
            .sound(SoundType.METAL)
            .requiresCorrectToolForDrops()));

    public static final RegistryObject<IronBarsBlock> STEEL_BARS = BLOCKS.register("steel_bars", () -> new IronBarsBlock(BlockBehaviour.Properties
            .of(Material.METAL, MaterialColor.NONE)
            .requiresCorrectToolForDrops()
            .strength(7.0F,10.0F)
            .sound(SoundType.METAL)
            .noOcclusion()));

    public static final net.minecraftforge.registries.RegistryObject<DoorBlock> STEEL_DOOR = BLOCKS.register("steel_door", () -> new DoorBlock(BlockBehaviour.Properties
            .of(Material.METAL, MaterialColor.METAL)
            .requiresCorrectToolForDrops()
            .strength(7.0F,10.0F)
            .sound(SoundType.METAL)
            .noOcclusion()));

    public static final RegistryObject<TrapDoorBlock> STEEL_TRAPDOOR = BLOCKS.register("steel_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties
            .of(Material.METAL)
            .requiresCorrectToolForDrops()
            .strength(7.0F,10.0F)
            .sound(SoundType.METAL)
            .noOcclusion()
            .isValidSpawn(RegistryHandler::neverAllowSpawn)));

    public static final RegistryObject<SteelAnvilBlock> STEEL_ANVIL = BLOCKS.register("steel_anvil", () -> new SteelAnvilBlock(BlockBehaviour.Properties
            .of(Material.HEAVY_METAL, MaterialColor.METAL)
            .requiresCorrectToolForDrops()
            .strength(7.0F, 2000.0F)
            .sound(SoundType.ANVIL)));

    public static final RegistryObject<SteelAnvilBlock> CHIPPED_STEEL_ANVIL = BLOCKS.register("chipped_steel_anvil", () -> new SteelAnvilBlock(BlockBehaviour.Properties
            .of(Material.HEAVY_METAL, MaterialColor.METAL)
            .requiresCorrectToolForDrops()
            .strength(7.0F, 2000.0F)
            .sound(SoundType.ANVIL)));

    public static final RegistryObject<SteelAnvilBlock> DAMAGED_STEEL_ANVIL = BLOCKS.register("damaged_steel_anvil", () -> new SteelAnvilBlock(BlockBehaviour.Properties
            .of(Material.HEAVY_METAL, MaterialColor.METAL)
            .requiresCorrectToolForDrops()
            .strength(7.0F, 2000.0F)
            .sound(SoundType.ANVIL)));

    private static Boolean neverAllowSpawn(BlockState state, BlockGetter reader, BlockPos pos, EntityType<?> entity) {
        return (boolean)false;
    }

    //Tools

    public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword", () -> new SwordItem(SteelItemTier.STEEL,3,-2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final net.minecraftforge.registries.RegistryObject<ShovelItem> STEEL_SHOVEL = ITEMS.register("steel_shovel", () -> new ShovelItem(SteelItemTier.STEEL, 1.5F, -3.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<PickaxeItem> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () -> new PickaxeItem(SteelItemTier.STEEL, 1, -2.8F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));
    public static final net.minecraftforge.registries.RegistryObject<AxeItem> STEEL_AXE = ITEMS.register("steel_axe", () -> new AxeItem(SteelItemTier.STEEL, 6.0F, -3.1F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<HoeItem> STEEL_HOE = ITEMS.register("steel_hoe", () -> new HoeItem(SteelItemTier.STEEL, -2, -1.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<FlintAndSteelItem> QUARTZ_AND_STEEL = ITEMS.register("quartz_and_steel", () -> new FlintAndSteelItem(new Item.Properties().durability(88).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<RNGFlintAndSteelItem> FLINT_AND_IRON = ITEMS.register("flint_and_iron", () -> new RNGFlintAndSteelItem(new Item.Properties().durability(64).tab(CreativeModeTab.TAB_TOOLS), 0.5F));
    public static final net.minecraftforge.registries.RegistryObject<RNGFlintAndSteelItem> QUARTZ_AND_IRON = ITEMS.register("quartz_and_iron", () -> new RNGFlintAndSteelItem(new Item.Properties().durability(88).tab(CreativeModeTab.TAB_TOOLS), 0.5F));



    //Armor

    public static final RegistryObject<ArmorItem> STEEL_HELMET = ITEMS.register("steel_helmet", () -> new ArmorItem(SteelArmorMaterial.STEEL, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ArmorItem> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate", () -> new ArmorItem(SteelArmorMaterial.STEEL, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final net.minecraftforge.registries.RegistryObject<ArmorItem> STEEL_LEGGINGS = ITEMS.register("steel_leggings", () -> new ArmorItem(SteelArmorMaterial.STEEL, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final net.minecraftforge.registries.RegistryObject<ArmorItem> STEEL_BOOTS = ITEMS.register("steel_boots", () -> new ArmorItem(SteelArmorMaterial.STEEL, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    //Block Items

    public static final RegistryObject<Item> STEEL_BLOCK_ITEM = ITEMS.register("steel_block", () -> new BlockItem(STEEL_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> STEEL_BARS_ITEM = ITEMS.register("steel_bars", () -> new BlockItem(STEEL_BARS.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> STEEL_DOOR_ITEM = ITEMS.register("steel_door", () -> new DoubleHighBlockItem(STEEL_DOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final net.minecraftforge.registries.RegistryObject<Item> STEEL_TRAPDOOR_ITEM = ITEMS.register("steel_trapdoor", () -> new BlockItem(STEEL_TRAPDOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final net.minecraftforge.registries.RegistryObject<Item> STEEL_ANVIL_ITEM = ITEMS.register("steel_anvil", () -> new BlockItem(STEEL_ANVIL.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> CHIPPED_STEEL_ANVIL_ITEM = ITEMS.register("chipped_steel_anvil", () -> new BlockItem(CHIPPED_STEEL_ANVIL.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final net.minecraftforge.registries.RegistryObject<Item> DAMAGED_STEEL_ANVIL_ITEM = ITEMS.register("damaged_steel_anvil", () -> new BlockItem(DAMAGED_STEEL_ANVIL.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_DECORATIONS)));

    //Entities

    public static final RegistryObject<EntityType<FallingSteelAnvil>> FALLING_ANVIL = ENTITIES.register("falling_anvil", () -> EntityType.Builder.<FallingSteelAnvil>of(FallingSteelAnvil::new, MobCategory.MISC).sized(0.98F, 0.98F).clientTrackingRange(10).updateInterval(20).build(new ResourceLocation(SimplySteel.MOD_ID + ":falling_anvil").toString()));
    public static final RegistryObject<EntityType<SteelGolem>> STEEL_GOLEM = ENTITIES.register("steel_golem", () -> EntityType.Builder.<SteelGolem>of(SteelGolem::new, MobCategory.MISC).sized(1.4F, 2.7F).clientTrackingRange(10).build(new ResourceLocation(SimplySteel.MOD_ID + ":steel_golem").toString()));

}