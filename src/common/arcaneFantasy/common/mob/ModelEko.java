// Date: 12.09.2012 15:56:39
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX



package arcaneFantasy.common.mob;

import net.minecraft.src.Entity;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

/**
 *
 * @author Hykarunogo
 */
public class ModelEko extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer neck;
    ModelRenderer mouth;
    ModelRenderer body1;
    ModelRenderer Body_2;
    ModelRenderer leg_D1;
    ModelRenderer neck2;
    ModelRenderer leg_D2;
    ModelRenderer leg_G1;
    ModelRenderer leg_G2;
    ModelRenderer Leg_G3;
    ModelRenderer Leg_D3;
    ModelRenderer Foot_D1;
    ModelRenderer Foot_G1;
    ModelRenderer toe_G1;
    ModelRenderer toe_G2;
    ModelRenderer toe_D1;
    ModelRenderer toe_D2;
    ModelRenderer tail_1;
    ModelRenderer tail_2;
    ModelRenderer head2;
    ModelRenderer head3;

  public ModelEko()
  {
    textureWidth = 64;
    textureHeight = 32;

      head = new ModelRenderer(this, 36, 0);
      head.addBox(-2F, -4F, -3F, 4, 4, 5);
      head.setRotationPoint(0F, 3F, -8F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      neck = new ModelRenderer(this, 48, 13);
      neck.addBox(-1F, -1F, -5F, 2, 2, 6);
      neck.setRotationPoint(0F, 10F, -3.5F);
      neck.setTextureSize(64, 32);
      neck.mirror = true;
      setRotation(neck, -0.5948578F, 0F, 0F);
      mouth = new ModelRenderer(this, 49, 0);
      mouth.addBox(-1F, -1F, -3F, 2, 2, 3);
      mouth.setRotationPoint(0F, 2F, -11F);
      mouth.setTextureSize(64, 32);
      mouth.mirror = true;
      setRotation(mouth, 0F, 0F, 0F);
      body1 = new ModelRenderer(this, 0, 0);
      body1.addBox(-3F, -3F, -4F, 6, 6, 8);
      body1.setRotationPoint(0F, 12F, 1F);
      body1.setTextureSize(64, 32);
      body1.mirror = true;
      setRotation(body1, 0F, 0F, 0F);
      Body_2 = new ModelRenderer(this, 20, 0);
      Body_2.addBox(-2F, -2F, 0F, 4, 4, 4);
      Body_2.setRotationPoint(0F, 11F, 5F);
      Body_2.setTextureSize(64, 32);
      Body_2.mirror = true;
      setRotation(Body_2, 0F, 0F, 0F);
      leg_D1 = new ModelRenderer(this, 28, 8);
      leg_D1.addBox(-2F, 0F, -1F, 2, 4, 2);
      leg_D1.setRotationPoint(-3F, 13F, 0F);
      leg_D1.setTextureSize(64, 32);
      leg_D1.mirror = true;
      setRotation(leg_D1, 0.7853982F, 0F, 0F);
      neck2 = new ModelRenderer(this, 54, 5);
      neck2.addBox(-1F, -5F, -2F, 2, 6, 2);
      neck2.setRotationPoint(0F, 7F, -7F);
      neck2.setTextureSize(64, 32);
      neck2.mirror = true;
      setRotation(neck2, 0F, 0F, 0F);
      leg_D2 = new ModelRenderer(this, 20, 14);
      leg_D2.addBox(0F, 0F, 0F, 1, 5, 1);
      leg_D2.setRotationPoint(-4F, 15F, 2F);
      leg_D2.setTextureSize(64, 32);
      leg_D2.mirror = true;
      setRotation(leg_D2, 0.7853982F, 0F, 0F);
      leg_G1 = new ModelRenderer(this, 28, 14);
      leg_G1.addBox(0F, 0F, -1F, 2, 4, 2);
      leg_G1.setRotationPoint(3F, 13F, 0F);
      leg_G1.setTextureSize(64, 32);
      leg_G1.mirror = true;
      setRotation(leg_G1, 0.7853982F, 0F, 0F);
      leg_G2 = new ModelRenderer(this, 24, 14);
      leg_G2.addBox(-1F, 0F, 0F, 1, 5, 1);
      leg_G2.setRotationPoint(4F, 15F, 2F);
      leg_G2.setTextureSize(64, 32);
      leg_G2.mirror = true;
      setRotation(leg_G2, 0.7853982F, 0F, 0F);
      Leg_G3 = new ModelRenderer(this, 24, 20);
      Leg_G3.addBox(0F, 0F, 0F, 1, 8, 1);
      Leg_G3.setRotationPoint(3F, 17F, 5F);
      Leg_G3.setTextureSize(64, 32);
      Leg_G3.mirror = true;
      setRotation(Leg_G3, -0.7853982F, 0F, 0F);
      Leg_D3 = new ModelRenderer(this, 20, 20);
      Leg_D3.addBox(-1F, 0F, 0F, 1, 8, 1);
      Leg_D3.setRotationPoint(-3F, 17F, 5F);
      Leg_D3.setTextureSize(64, 32);
      Leg_D3.mirror = true;
      setRotation(Leg_D3, -0.7853982F, 0F, 0F);
      Foot_D1 = new ModelRenderer(this, 0, 24);
      Foot_D1.addBox(-2F, 0F, -2F, 2, 2, 2);
      Foot_D1.setRotationPoint(-3F, 22F, 1F);
      Foot_D1.setTextureSize(64, 32);
      Foot_D1.mirror = true;
      setRotation(Foot_D1, 0F, 0F, 0F);
      Foot_G1 = new ModelRenderer(this, 0, 28);
      Foot_G1.addBox(0F, 0F, -2F, 2, 2, 2);
      Foot_G1.setRotationPoint(3F, 22F, 1F);
      Foot_G1.setTextureSize(64, 32);
      Foot_G1.mirror = true;
      setRotation(Foot_G1, 0F, 0F, 0F);
      toe_G1 = new ModelRenderer(this, 0, 16);
      toe_G1.addBox(-1F, 0F, -3F, 1, 1, 3);
      toe_G1.setRotationPoint(4F, 23F, -1F);
      toe_G1.setTextureSize(64, 32);
      toe_G1.mirror = true;
      setRotation(toe_G1, 0F, 0F, 0F);
      toe_G2 = new ModelRenderer(this, 8, 28);
      toe_G2.addBox(0F, 0F, -3F, 1, 1, 3);
      toe_G2.setRotationPoint(5F, 23F, 0F);
      toe_G2.setTextureSize(64, 32);
      toe_G2.mirror = true;
      setRotation(toe_G2, 0F, 0F, 0F);
      toe_D1 = new ModelRenderer(this, 0, 20);
      toe_D1.addBox(0F, 0F, -3F, 1, 1, 3);
      toe_D1.setRotationPoint(-4F, 23F, -1F);
      toe_D1.setTextureSize(64, 32);
      toe_D1.mirror = true;
      setRotation(toe_D1, 0F, 0F, 0F);
      toe_D2 = new ModelRenderer(this, 8, 24);
      toe_D2.addBox(-1F, 0F, -3F, 1, 1, 3);
      toe_D2.setRotationPoint(-5F, 23F, 0F);
      toe_D2.setTextureSize(64, 32);
      toe_D2.mirror = true;
      setRotation(toe_D2, 0F, 0F, 0F);
      tail_1 = new ModelRenderer(this, 28, 22);
      tail_1.addBox(-1F, -8F, -1F, 2, 8, 2);
      tail_1.setRotationPoint(0F, 10F, 8F);
      tail_1.setTextureSize(64, 32);
      tail_1.mirror = true;
      setRotation(tail_1, -0.5576792F, 0F, 0F);
      tail_2 = new ModelRenderer(this, 36, 23);
      tail_2.addBox(-0.5F, 0F, 0F, 1, 8, 1);
      tail_2.setRotationPoint(-0.5F, 4F, 12F);
      tail_2.setTextureSize(64, 32);
      tail_2.mirror = true;
      setRotation(tail_2, 0.6320364F, 0F, 0F);
      head2 = new ModelRenderer(this, 36, 15);
      head2.addBox(0F, 0F, 0F, 1, 1, 5);
      head2.setRotationPoint(2F, -1F, -8F);
      head2.setTextureSize(64, 32);
      head2.mirror = true;
      setRotation(head2, 0.3490659F, 0F, 0F);
      head3 = new ModelRenderer(this, 36, 9);
      head3.addBox(-1F, 0F, 0F, 1, 1, 5);
      head3.setRotationPoint(-2F, -1F, -8F);
      head3.setTextureSize(64, 32);
      head3.mirror = true;
      setRotation(head3, 0.3490659F, 0F, 0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    head.render(f5);
    neck.render(f5);
    mouth.render(f5);
    body1.render(f5);
    Body_2.render(f5);
    leg_D1.render(f5);
    neck2.render(f5);
    leg_D2.render(f5);
    leg_G1.render(f5);
    leg_G2.render(f5);
    Leg_G3.render(f5);
    Leg_D3.render(f5);
    Foot_D1.render(f5);
    Foot_G1.render(f5);
    toe_G1.render(f5);
    toe_G2.render(f5);
    toe_D1.render(f5);
    toe_D2.render(f5);
    tail_1.render(f5);
    tail_2.render(f5);
    head2.render(f5);
    head3.render(f5);
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
  }

}
