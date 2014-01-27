package net.fossilsarch.common.entity;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class EntityDinosaurce extends EntityTameable implements IEntityAdditionalSpawnData{

	public EntityDinosaurce(World world) { super(world);}
	@Override
	public String getEntityName() {
		return "";
	}

	@Override
    protected void entityInit()
    {

    }
    @Override
    public boolean attackEntityAsMob(Entity par1Entity)
    {
        return false;
    }

	@Override
	protected int getDropItemId() {
		return 0;
	}

	@Override
	protected void dropFewItems(boolean flag, int unusedi) {

	}

	@Override
	public Entity getOwner() {
		return null;
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
    }
	
	@Override
	public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
    }

	@Override
	public void writeSpawnData(ByteArrayDataOutput data) {


	}

	@Override
	public void readSpawnData(ByteArrayDataInput data) {


	}

	
    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
	@Override
    public boolean canBeCollidedWith()
    {
		return false;
    }
	
	@Override
    public boolean canBePushed()
    {
		return false;
    }

	@Override
    protected void collideWithEntity(Entity par1Entity)
    {
    }
}