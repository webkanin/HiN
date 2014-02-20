package oppg18_29;

/**
 * Created with IntelliJ IDEA.
 * User: Marko Sundic
 * Student nr. 530 614
 */
public class MyRectangle2D {
    private int xpos;
    private int ypos;
    private int width;
    private int height;

    public MyRectangle2D() {
        xpos = 0;
        ypos = 0;
    }
    public MyRectangle2D(int x, int y, int w, int h) {
        xpos = x;
        ypos = y;
        width = w;
        height = h;
    }
    public int getXpos()
    {
        return xpos;
    }
    public void setXpos(int x)
    {
        xpos = x;
    }
    public int getYpos()
    {
        return ypos;
    }
    public void setYpos(int y)
    {
        ypos = y;
    }
    public int getWidth()
    {
        return width;
    }
    public void setWidth(int w)
    {
        width = w;
    }
    public int getHeight()
    {
        return height;
    }
    public void setHeight(int h)
    {
        height = h;
    }

    public int getArea() {
        return width*height;
    }
    public int getPerimeter() {
        return (width*2)+(height*2);
    }
    public boolean contains(int x, int y) {
        if(x >= xpos && x <= (xpos+width) && y >= ypos && y <= (ypos+height)){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean contains(MyRectangle2D r){
        if(contains(r.getXpos(), r.getYpos()) && contains((r.getXpos() + r.getWidth()), (r.getYpos() + r.getHeight()))){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean overlaps(MyRectangle2D r){
        if(contains(r) && r.contains(this)){
            return false;
        }
        if(contains(r.getXpos(), r.getYpos())){
            return true;
        }
        if(contains(r.getXpos()+r.getWidth(), r.getYpos()+r.getHeight())){
            return true;
        }
        if(contains(r.getXpos()+r.getWidth(), r.getYpos())){
            return true;
        }
        if(contains(r.getXpos(), r.getYpos()+r.getHeight())) {
            return true;
        }
        else {
            return false;
        }
    }
    public String toString(){
        return "[" + getXpos() + "," + getYpos() + "]   width= " + getWidth() + ",height= " + getHeight() + ",";
    }
}
