package net.eteriumnetwork.quantumpraeda;

import com.mojang.logging.LogUtils;
import net.eteriumnetwork.quantumpraeda.base.Item.ItemRegistration;
import net.eteriumnetwork.quantumpraeda.base.block.BlockRegistration;
import net.eteriumnetwork.quantumpraeda.datagen.DataGeneration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(QuantumPraeda.MODID)
public class QuantumPraeda
{
    public static final String MODID = "quantum_praeda";
    public static final Logger LOGGER = LogUtils.getLogger();

    public QuantumPraeda() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BlockRegistration.init(modEventBus);
        ItemRegistration.init(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(BlockRegistration::addCreative);
        modEventBus.addListener(ItemRegistration::addCreative);
        modEventBus.addListener(DataGeneration::generate);
    }

    public void commonSetup(final FMLCommonSetupEvent event) {

    }

}
