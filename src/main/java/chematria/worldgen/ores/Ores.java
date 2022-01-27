package chematria.worldgen.ores;

import chematria.blocks.ChematriaBlocks;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class Ores {

    public static final int LEAD_VEINSIZE = 25;
    public static final int TIN_VEINSIZE = 20;
    public static final int MERCURY_VEINSIZE = 15;
    public static final int SILVER_VEINSIZE = 10;
    public static final int LEAD_AMOUNT = 10;
    public static final int TIN_AMOUNT = 8;
    public static final int MERCURY_AMOUNT = 6;
    public static final int SILVER_AMOUNT = 4;

    public static PlacedFeature LEAD_OREGEN;
    public static PlacedFeature TIN_OREGEN;
    public static PlacedFeature MERCURY_OREGEN;
    public static PlacedFeature SILVER_OREGEN;

    public static void registerConfiguredFeatures() {
        OreConfiguration leadConfig = new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, ChematriaBlocks.LEAD_ORE_OVERWORLD.get().defaultBlockState(), LEAD_VEINSIZE);
        OreConfiguration tinConfig = new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, ChematriaBlocks.TIN_ORE_OVERWORLD.get().defaultBlockState(), TIN_VEINSIZE);
        OreConfiguration mercuryConfig = new OreConfiguration(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ChematriaBlocks.MERCURY_ORE_OVERWORLD.get().defaultBlockState(), MERCURY_VEINSIZE);
        OreConfiguration silverConfig = new OreConfiguration(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ChematriaBlocks.SILVER_ORE_OVERWORLD.get().defaultBlockState(), SILVER_VEINSIZE);
        LEAD_OREGEN = registerPlacedFeature("overworld_lead_ore", Feature.ORE.configured(leadConfig),
                CountPlacement.of(LEAD_AMOUNT),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(90)));
        TIN_OREGEN = registerPlacedFeature("overworld_tin_ore", Feature.ORE.configured(tinConfig),
                CountPlacement.of(TIN_AMOUNT),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-10), VerticalAnchor.absolute(60)));

        MERCURY_OREGEN = registerPlacedFeature("deepslate_mercury_ore", Feature.ORE.configured(mercuryConfig),
                CountPlacement.of(MERCURY_AMOUNT),
                InSquarePlacement.spread(),
                BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(32), VerticalAnchor.aboveBottom(64)));

        SILVER_OREGEN = registerPlacedFeature("deepslate_silver_ore", Feature.ORE.configured(silverConfig),
                CountPlacement.of(SILVER_AMOUNT),
                InSquarePlacement.spread(),
                BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(32)));
    }

    private static <C extends FeatureConfiguration, F extends Feature<C>> PlacedFeature registerPlacedFeature(String registryName, ConfiguredFeature<C, F> feature, PlacementModifier... placementModifiers) {
        PlacedFeature placed = BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(registryName), feature).placed(placementModifiers);
        return PlacementUtils.register(registryName, placed);
    }

    public static void onBiomeLoadingEvent(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.BiomeCategory.NETHER) {
        } else if (event.getCategory() == Biome.BiomeCategory.THEEND) {
        } else {
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, LEAD_OREGEN);
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, TIN_OREGEN);
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MERCURY_OREGEN);
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SILVER_OREGEN);
        }
    }
}
