package net.eteriumnetwork.quantumpraeda.base.Item;

import net.eteriumnetwork.quantumpraeda.QuantumPraeda;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class ItemRegistration {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
        ForgeRegistries.ITEMS,
        QuantumPraeda.MODID
    );

    private static RegistryObject<Item> registryItem(@NotNull String name, @NotNull Item.Properties item) {
        return ITEMS.register(name, () -> new Item(item));
    }

    public static RegistryObject<Item> RAW_QUANTUMITE = registryItem(
        "raw_quantumite",
        new Item.Properties()
    );
    public static RegistryObject<Item> RAW_NEUTRINIO = registryItem(
        "raw_neutrinio",
        new Item.Properties()
    );
    public static RegistryObject<Item> RAW_GRAVITONITA = registryItem(
        "raw_gravitonita",
        new Item.Properties()
    );
    public static RegistryObject<Item> RAW_PHOTONITA = registryItem(
        "raw_photonita",
        new Item.Properties()
    );
    public static RegistryObject<Item> RAW_SPINORITA = registryItem(
        "raw_spinorita",
        new Item.Properties()
    );
    public static RegistryObject<Item> RAW_ENTANGLION = registryItem(
        "raw_entanglion",
        new Item.Properties()
    );
    public static RegistryObject<Item> RAW_SUPERCONDUTITA = registryItem(
        "raw_supercondutita",
        new Item.Properties()
    );

    public static void init(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(RAW_QUANTUMITE);
            event.accept(RAW_NEUTRINIO);
            event.accept(RAW_GRAVITONITA);
            event.accept(RAW_PHOTONITA);
            event.accept(RAW_SPINORITA);
            event.accept(RAW_ENTANGLION);
            event.accept(RAW_SUPERCONDUTITA);
        }
    }
}
