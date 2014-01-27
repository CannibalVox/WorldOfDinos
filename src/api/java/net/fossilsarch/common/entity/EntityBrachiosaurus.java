package net.fossilsarch.common.entity;

import java.util.ArrayList;
import java.util.Random;


import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;

public class EntityBrachiosaurus extends EntityDinosaurce  {

	public EntityBrachiosaurus(World world) { super(world);}
    @Override
    protected void applyEntityAttributes() {
    }

    @Override
	public boolean attackEntityFrom(DamageSource damagesource, float i)
    {
		return true;
    }
    
    @Override
	protected String getLivingSound()
    {
		if (worldObj.getClosestPlayerToEntity(this, 16D)!=null) return "fossilsarch:Brach_living";
		else return null;

    }
    
    @Override
	protected String getHurtSound()
    {
        return "mob.cow.hurt";
    }

    @Override
    protected String getDeathSound()
    {
        return "fossilsarch:Brach_death";
    }
    
	@Override
	public String getOwnerName() {
		return "";
	}

	@Override
	public void setOwner(String s) {

	}

	@Override
	public boolean isTamed() {
		return false;
	}

	@Override
	public void setTamed(boolean flag) {

	}


	@Override
	public EntityAgeable createChild(EntityAgeable entityanimal) {
		return null;
	}

}
