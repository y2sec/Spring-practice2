package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient() {
        System.out.println("url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("call = " + url + " message = " + message);
    }

    public void disconnect() {
        System.out.println("close " + url);
    }

    // 의존성 주입 이후 호출
    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결");
    }

    // 종료되기 전에 호출
    @Override
    public void destroy() throws Exception {
        disconnect();
    }


//    public void init() throws Exception {
//        connect();
//        call("초기화 연결");
//    }

//    public void close() throws Exception {
//        disconnect();
//    }

    @PostConstruct
    public void init() throws Exception {
        connect();
        call("초기화 연결");
    }

    @PreDestroy
    public void close() throws Exception {
        disconnect();
    }

}
