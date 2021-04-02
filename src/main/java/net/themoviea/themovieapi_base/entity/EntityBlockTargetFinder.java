package net.themoviea.themovieapi_base.entity;

import java.util.concurrent.ThreadLocalRandom;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityBlockTargetFinder {
	
	public boolean isMovable;
	private MobEntity entity;
	
	public EntityBlockTargetFinder(MobEntity entity) {
		this.entity = entity;
	}
	
	public void setIsMovable(boolean isMovable) {
		this.isMovable = isMovable;
	}
	
	public boolean getIsMovable() {
		return this.isMovable;
	}
	
	public BlockPos findRandomBlockTarget(boolean includeY, int num) {
		double randY;
		double randX = ThreadLocalRandom.current().nextDouble(this.entity.getX() - num, this.entity.getX() + num);
		if(includeY == true) {
			randY = ThreadLocalRandom.current().nextDouble(this.entity.getY() - num, this.entity.getY() + num);
		} else {
			randY = this.entity.getY();
		}
		double randZ = ThreadLocalRandom.current().nextDouble(this.entity.getZ() - num, this.entity.getZ() + num);
		return new BlockPos(randX, randY, randZ);
	}
	
	public Vec3d findRandomVec3dTarget(boolean includeY, double num) {
		double randY;
		double randX = ThreadLocalRandom.current().nextDouble(this.entity.getX() - num, this.entity.getX() + num);
		if(includeY == true) {
			randY = ThreadLocalRandom.current().nextDouble(this.entity.getY() - num, this.entity.getY() + num);
		} else {
			randY = this.entity.getY();
		}
		double randZ = ThreadLocalRandom.current().nextDouble(this.entity.getZ() - num, this.entity.getZ() + num);
		return new Vec3d(randX, randY, randZ);
	}
	
	public void startMovingToPos(World world, BlockPos pos, double speed) {
		if(world.getBlockState(pos) == Blocks.AIR.getDefaultState()) {
			setIsMovable(true);
			this.entity.getNavigation().startMovingTo(pos.getX(), pos.getY(), pos.getZ(), speed);
		} else {
			setIsMovable(false);
		}
	}
}
