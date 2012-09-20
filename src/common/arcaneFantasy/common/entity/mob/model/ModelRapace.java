// Date: 06.09.2012 18:44:13
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package arcaneFantasy.common.entity.mob.model;

import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

/**
 *
 * @author RevenantGaze
 */
public class ModelRapace extends ModelBase
{
  //fields
    ModelRenderer Head;
    ModelRenderer Beak;
    ModelRenderer BeakTip;
    ModelRenderer Body;
    ModelRenderer Left_Thigh;
    ModelRenderer Right_Thigh;
    ModelRenderer Right_Foot;
    ModelRenderer Left_Foot;
    ModelRenderer Left_Wing;
    ModelRenderer Right_Wing;
    ModelRenderer Left_Wing_Tip;
    ModelRenderer Right_Wing_Tip;
    ModelRenderer Tail;
    ModelRenderer Tail_2;

  public ModelRapace()
  {
    textureWidth = 56;
    textureHeight = 52;

      Head = new ModelRenderer(this, 30, 0);
      Head.addBox(0F, 0F, 0F, 5, 4, 5);
      Head.setRotationPoint(0F, 0F, 0F);
      Head.setTextureSize(56, 52);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Beak = new ModelRenderer(this, 30, 9);
      Beak.addBox(0F, 0F, 0F, 1, 2, 4);
      Beak.setRotationPoint(2F, 1F, -4F);
      Beak.setTextureSize(56, 52);
      Beak.mirror = true;
      setRotation(Beak, 0F, 0F, 0F);
      BeakTip = new ModelRenderer(this, 36, 11);
      BeakTip.addBox(0F, 0F, 0F, 1, 1, 1);
      BeakTip.setRotationPoint(2F, 3F, -4F);
      BeakTip.setTextureSize(56, 52);
      BeakTip.mirror = true;
      setRotation(BeakTip, 0F, 0F, 0F);
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(0F, 0F, 0F, 7, 6, 16);
      Body.setRotationPoint(-1F, 0F, 5F);
      Body.setTextureSize(56, 52);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Left_Thigh = new ModelRenderer(this, 0, 23);
      Left_Thigh.addBox(0F, 0F, 0F, 3, 1, 4);
      Left_Thigh.setRotationPoint(3F, 6F, 16F);
      Left_Thigh.setTextureSize(56, 52);
      Left_Thigh.mirror = true;
      setRotation(Left_Thigh, 0F, 0F, 0F);
      Right_Thigh = new ModelRenderer(this, 0, 28);
      Right_Thigh.addBox(0F, 0F, 0F, 3, 1, 4);
      Right_Thigh.setRotationPoint(-1F, 6F, 16F);
      Right_Thigh.setTextureSize(56, 52);
      Right_Thigh.mirror = true;
      setRotation(Right_Thigh, 0F, 0F, 0F);
      Right_Foot = new ModelRenderer(this, 0, 0);
      Right_Foot.addBox(0F, 0F, 0F, 1, 1, 5);
      Right_Foot.setRotationPoint(0F, 7F, 17F);
      Right_Foot.setTextureSize(56, 52);
      Right_Foot.mirror = true;
      setRotation(Right_Foot, 0F, 0F, 0F);
      Left_Foot = new ModelRenderer(this, 0, 6);
      Left_Foot.addBox(0F, 0F, 0F, 1, 1, 5);
      Left_Foot.setRotationPoint(4F, 7F, 17F);
      Left_Foot.setTextureSize(56, 52);
      Left_Foot.mirror = true;
      setRotation(Left_Foot, 0F, 0F, 0F);
      Left_Wing = new ModelRenderer(this, 0, 44);
      Left_Wing.addBox(0F, 0F, 0F, 11, 1, 7);
      Left_Wing.setRotationPoint(-12F, 1F, 6F);
      Left_Wing.setTextureSize(56, 52);
      Left_Wing.mirror = true;
      setRotation(Left_Wing, 0.0185893F, 0F, 0F);
      Right_Wing = new ModelRenderer(this, 0, 36);
      Right_Wing.addBox(0F, 0F, 0F, 11, 1, 7);
      Right_Wing.setRotationPoint(6F, 1F, 6F);
      Right_Wing.setTextureSize(56, 52);
      Right_Wing.mirror = true;
      setRotation(Right_Wing, 0F, 0F, 0F);
      Left_Wing_Tip = new ModelRenderer(this, 28, 29);
      Left_Wing_Tip.addBox(0F, 0F, 0F, 9, 1, 5);
      Left_Wing_Tip.setRotationPoint(-21F, 1F, 7F);
      Left_Wing_Tip.setTextureSize(56, 52);
      Left_Wing_Tip.mirror = true;
      setRotation(Left_Wing_Tip, 0F, 0F, 0F);
      Right_Wing_Tip = new ModelRenderer(this, 28, 23);
      Right_Wing_Tip.addBox(0F, 0F, 0F, 9, 1, 5);
      Right_Wing_Tip.setRotationPoint(17F, 1F, 7F);
      Right_Wing_Tip.setTextureSize(56, 52);
      Right_Wing_Tip.mirror = true;
      setRotation(Right_Wing_Tip, 0F, 0F, 0F);
      Tail = new ModelRenderer(this, 17, 23);
      Tail.addBox(0F, 0F, 0F, 5, 1, 1);
      Tail.setRotationPoint(0F, 2F, 21F);
      Tail.setTextureSize(56, 52);
      Tail.mirror = true;
      setRotation(Tail, 0F, 0F, 0F);
      Tail_2 = new ModelRenderer(this, 14, 25);
      Tail_2.addBox(-1F, 0F, 0F, 7, 1, 2);
      Tail_2.setRotationPoint(0F, 2F, 22F);
      Tail_2.setTextureSize(56, 52);
      Tail_2.mirror = true;
      setRotation(Tail_2, 0F, 0F, 0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Head.render(f5);
    Beak.render(f5);
    BeakTip.render(f5);
    Body.render(f5);
    Left_Thigh.render(f5);
    Right_Thigh.render(f5);
    Right_Foot.render(f5);
    Left_Foot.render(f5);
    Left_Wing.render(f5);
    Right_Wing.render(f5);
    Left_Wing_Tip.render(f5);
    Right_Wing_Tip.render(f5);
    Tail.render(f5);
    Tail_2.render(f5);
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
        Right_Wing.rotateAngleZ = f2;
        Left_Wing.rotateAngleZ = -f2;
  }

}
