package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by user on 6/30/2016.
 */
public class Shape extends AbstractShape implements ShapeBehaviour{
    protected int color;
    protected float saturation;

    public double area(){
        return 1.0;
    }

    public void setColor(int aColor) {
        this.color = aColor;
    }

    public void setSaturation(float aSaturation){
        this.saturation = aSaturation;
    }

}

