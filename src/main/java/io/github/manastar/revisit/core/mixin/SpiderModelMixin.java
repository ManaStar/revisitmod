package io.github.manastar.revisit.core.mixin;

import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.PartDefinition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SpiderModel.class)
public class SpiderModelMixin {
	@Redirect(method = "createSpiderBodyLayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/model/geom/builders/PartDefinition;addOrReplaceChild(Ljava/lang/String;Lnet/minecraft/client/model/geom/builders/CubeListBuilder;Lnet/minecraft/client/model/geom/PartPose;)Lnet/minecraft/client/model/geom/builders/PartDefinition;", ordinal = 2))
	private static PartDefinition createSpiderBodyLayer(PartDefinition instance, String name, CubeListBuilder builder, PartPose rotationData) {
		return instance.addOrReplaceChild(name, builder.create().texOffs(0, 12).addBox(-5.0F, -5.0F, -7.0F, 10.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.0F, 9.0F, 0.3054F, 0.0F, 0.0F));
	}
}
