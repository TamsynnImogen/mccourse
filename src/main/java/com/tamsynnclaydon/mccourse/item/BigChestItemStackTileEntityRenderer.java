package com.tamsynnclaydon.mccourse.item;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.tamsynnclaydon.mccourse.tileentity.BigChestTile;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;

public class BigChestItemStackTileEntityRenderer extends ItemStackTileEntityRenderer
{
    @Override
    public void func_239207_a_(ItemStack stack, ItemCameraTransforms.TransformType p_239207_2_,
                               MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay)
        {
            TileEntityRendererDispatcher.instance.renderItem(new BigChestTile(), matrixStack, buffer, combinedLight, combinedOverlay);
        }
}