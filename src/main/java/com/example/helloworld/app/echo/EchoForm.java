package com.example.helloworld.app.echo;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class EchoForm implements Serializable {
    private static final long serialVersionUID = 2557725707095364445L;
    // @NotNull アノテーションをつけることで、HTTPリクエスト中に name パラメータがあることを確認する。
    @NotNull
    // @Size(min = 1, max = 5) をつけることで、name のサイズが、1以上5以下であることを確認する。
    @Size(min = 1, max = 5) // (2)
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}