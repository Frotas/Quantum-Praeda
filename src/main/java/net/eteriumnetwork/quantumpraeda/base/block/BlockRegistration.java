package net.eteriumnetwork.quantumpraeda.base.block;

import net.eteriumnetwork.quantumpraeda.QuantumPraeda;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class BlockRegistration {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, QuantumPraeda.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, QuantumPraeda.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, QuantumPraeda.MODID);

    private static <T extends Block> RegistryObject<T> registerBlock(@NotNull String name, @NotNull Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return  ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // Ores:
    // TODO: Create a injection generation world from all ore blocks.
    public static final RegistryObject<Block> QUANTUMITE_ORE = registerBlock(
            "quantumite_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE))
    );
    public static final RegistryObject<Block> NEUTRINIO_ORE = registerBlock(
            "neutrinio_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE))
    );
    public static final RegistryObject<Block> GRAVITONITA_ORE = registerBlock(
            "gravitonita_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE))
    );
    public static final RegistryObject<Block> PHOTONITA_ORE = registerBlock(
      "photonita_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE))
    );
    public static final RegistryObject<Block> SPINORITA_ORE = registerBlock(
      "spinorita_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE))
    );
    public static final RegistryObject<Block> ENTANGLION_ORE = registerBlock(
            "entanglion_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE))
    );
    public static final RegistryObject<Block> SUPERCONDUTITA_ORE = registerBlock(
            "supercondutita_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE))
    );

    public static void init(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        BLOCK_ENTITIES.register(modEventBus);
    }

    public static void addCreative(@NotNull BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(QUANTUMITE_ORE);
            event.accept(NEUTRINIO_ORE);
            event.accept(GRAVITONITA_ORE);
            event.accept(PHOTONITA_ORE);
            event.accept(SPINORITA_ORE);
            event.accept(ENTANGLION_ORE);
            event.accept(SUPERCONDUTITA_ORE);
        }
    }
}
