package com.hollingsworth.arsnouveau.client.renderer.tile;

import com.hollingsworth.arsnouveau.ArsNouveau;
import com.hollingsworth.arsnouveau.common.block.tile.VolcanicTile;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class VolcanicModel extends AnimatedGeoModel<VolcanicTile> {
    @Override
    public ResourceLocation getModelLocation(VolcanicTile volcanicTile) {
        return new ResourceLocation(ArsNouveau.MODID , "geo/volcanic_accumulator.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(VolcanicTile volcanicTile) {
        return new ResourceLocation(ArsNouveau.MODID, "textures/blocks/volcanic/volcanic_accumulator_core_magma.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(VolcanicTile volcanicTile) {
        return new ResourceLocation(ArsNouveau.MODID , "animations/volcanic_accumulator_animations.json");
    }
}