package io.github.manastar.revisit.core.mixin;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Spider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Spider.SpiderAttackGoal.class)
public abstract class SpiderAttackGoalMixin extends MeleeAttackGoal {

	public SpiderAttackGoalMixin(PathfinderMob mob, double speed, boolean pauseWhenMobIdle) {
		super(mob, speed, pauseWhenMobIdle);
	}

	@Inject(method = "canUse", at = @At(value = "RETURN"), cancellable = true)
	private void canUse(CallbackInfoReturnable<Boolean> cir) {
		boolean flag = cir.getReturnValue();

		cir.setReturnValue(flag && this.mob.getTarget().getActiveEffects().contains(MobEffects.MOVEMENT_SLOWDOWN));
	}

	@Inject(method = "canContinueToUse", at = @At(value = "RETURN"), cancellable = true)
	private void canContinueToUse(CallbackInfoReturnable<Boolean> cir) {
		boolean flag = cir.getReturnValue();

		cir.setReturnValue(flag && this.mob.getTarget().getActiveEffects().contains(MobEffects.MOVEMENT_SLOWDOWN));
	}
}
