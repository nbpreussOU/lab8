package lab8.doc;

public enum Color
{

        RED(255, 0, 0), GREEN(0, 255, 0), BLUE(0, 0, 255), YELLOW(255, 255,0), CYAN(0, 255, 255), MAGENTA(255, 0, 255);
    private int r;
    private int b;
    private int g;
    
    private Color(int r, int g, int b)
    {
        this.r = r;
        this.b = b;
        this.g = g;
    }

    public int getR()
    {
        return r;
    }

    public int getB()
    {
        return b;
    }

    public int getG()
    {
        return g;
    }
    
    
}
