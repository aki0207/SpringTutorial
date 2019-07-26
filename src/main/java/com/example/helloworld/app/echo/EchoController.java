package com.example.helloworld.app.echo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
@RequestMapping("echo")
public class EchoController {
	// @ModelAttribute というアノテーションを、メソッドに付加する。
	// このアノテーションがついたメソッドの返り値は、自動でModelに追加される。
    @ModelAttribute 
    public EchoForm setUpEchoForm() {
        EchoForm form = new EchoForm();
        return form;
    }

    // メソッドに付加した @RequestMapping アノテーションの value 属性に、何も指定しない場合、クラスに付加した @RequestMapping のルートに、マッピングされる。
    // この場合、”<contextPath>/echo”にアクセスすると、 index メソッドが呼ばれる。
    @RequestMapping 
    public String index(Model model) {
    	// 	View名で”echo/index”を返すので、ViewResolverにより、 “WEB-INF/views/echo/index.jsp”がレンダリングされる。
        return "echo/index"; 
    }
    // ”<contextPath>/echo/hello”にPOSTメソッドを使用してアクセスすると hello メソッドが呼ばれる。
    @RequestMapping(value = "hello", method = RequestMethod.POST)
    // 引数に、EchoFormにはsetUpEchoForm()によりModelに追加されたEchoFormオブジェクトが渡される。
    // コントローラー側には、Validation対象の引数に @Validated アノテーションを付加し、 BindingResult オブジェクトを引数に追加する。
    // Bean Validationによる入力チェックは、自動で行われる。結果は、 BindingResult オブジェクトに渡される。
    public String hello(@Validated EchoForm form, BindingResult result, Model model) { 
    	//hasErrors メソッドを実行して、エラーがあるかどうかを確認する。入力エラーがある場合は、入力画面を表示するためのView名を返却する。
        if (result.hasErrors()) { 
            return "echo/index";
        }
        model.addAttribute("name", form.getName());
        return "echo/hello";
    }
}