package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworClient {
    private String url;

    public NetworClient() {
        System.out.println("생성자 호출, url= "+ url);

    }

    public void setUrl(String url) {
        System.out.println("NetworClient.setUrl");
        this.url = url;
    }

    public void printUrl(){
        System.out.println("프린트URL = " + url);
    }

    //서비스 시작 시 호출
    public void connect(){
        System.out.println("connect: "+ url);
    }

    public void call(String message){
        System.out.println("call"+ url + "message ="+ message);
    }

    //서비스 종료 시 호출
    public void disconnect(){
        System.out.println("close: "+ url);
    }

    @PostConstruct
    public void init()  {
        System.out.println("NetworClient.init");
        connect();
        call("초기화 연결 메시지");

    }

    @PreDestroy
    public void close() {
        System.out.println("NetworClient.close");
        disconnect();
    }
}
