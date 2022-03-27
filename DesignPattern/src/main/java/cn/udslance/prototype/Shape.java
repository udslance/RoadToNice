package cn.udslance.prototype;

/**
 * @program: DesignPattern
 * @description:
 * @author: Udslance
 * @create: 2022-03-22 10:37
 **/
public abstract class Shape implements Cloneable{
    private String id;
    protected String type;

    abstract void draw();

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
