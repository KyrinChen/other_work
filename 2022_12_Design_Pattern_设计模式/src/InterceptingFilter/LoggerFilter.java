package InterceptingFilter;

public class LoggerFilter implements Filter{
    //日志记录
    @Override
    public void execute(String request){
        System.out.println("Request Log: " + request);
    }
}
