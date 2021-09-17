package libgem.utils;

public class ShortStringException extends Throwable {
    public ShortStringException () {
        super();
    }
    public ShortStringException(String s) {
        super(s);
    }

    public ShortStringException(String s, Throwable t){
        super(s, t);
    }

    public ShortStringException(Throwable t){
        super(t);
    }
}
