## MVC패턴 이해하기

### 컨트롤러로 View 반환하는 과정

전통적인 Spring MVC의 컨트롤러인 `@Controller`는 주로 View를 반환하기 위해 사용한다. 아래와 같은 과정을 통해 Spring MVC 컨테이너는 클라이언트의 요청으로부터 View를 반환한다. 컨트롤러가 반환환 View의 이름을 가지고 View를 렌더링하기 위해서는 ViewResolver를 거치며 그의 설정에 맞게 View를 찾아 렌더링한다.

![img.png](https://github.com/user-attachments/assets/daa9c79a-545c-42d0-8663-ca43d6e1ed3d)

1. Client는 URI 형식으로 웹 서비스에 요청을 보낸다.
2. DispatcherServlet이 요청을 처리할 대상을 찾는다.
3. HandlerAdapter을 통해 요청을 알맞은 Controller로 위임한다.
4. Controller는 요청을 처리한 후에 ViewName을 반환한다.
5. DispatcherServlet은 ViewResolver를 통해 ViewName에 해당하는 View를 찾아 사용자에게 반환한다.

<br>

### 컨트롤러로 Data 반환하는 과정

Spring MVC의 컨트롤러를 사용하면서 Data를 반환해야 하는 경우도 있다. 컨트롤러에서는 데이터를 반환하기 위해 `@ResponseBody` 어노테이션을 활용한다. 그러면 Controller가 Json 형태로 데이터를 반환할 수 있다.

컨트롤러를 통해 객체를 반환할 때에는 일반적으로 ResponseEntity로 감싸서 반환한다. 그리고 객체를 반환하기 위해서는 ViewResolver 대신 HttpMessageConverter가 동작한다. HttpMessageConverter에는 여러 Converter가 등록되어 있고, 반환해야 하는 데이터에 따라 사용되는 Converter가 달라진다. 단순 문자열인 경우에는 StringHttpMessageConverter가 사용되고, 객체인 경우에는 MappingJackson2HttpMessageConverter가 사용되며, 데이터 종류에 따라 서로 다른 MessageConverter가 작동하게 된다. Spring은 클라이언트의 HTTP Accept 헤더와 서버의 컨트롤러 반환 타입 정보 둘을 조합해 적합한 HttpMessageConverter를 선택하여 이를 처리한다. MessageConverter가 동작하는 시점은 HandlerAdapter와 Controller가 요청을 주고 받는 시점이다. 그림의 4번에서는 메세지를 객체로, 6번에서는 객체를 메세지로 변환하는데 메세지 컨버터가 사용된다.

![img_1.png](https://github.com/user-attachments/assets/e2e6b70f-9da9-4dba-a074-4e48f060aa65)

1. Client는 URI 형식으로 웹 서비스에 요청을 보낸다.
2. DispatcherServlet이 요청을 처리할 대상을 찾는다.
3. HandlerAdapter을 통해 요청을 Controller로 위임한다.
4. Controller는 요청을 처리한 후에 객체를 반환한다.
5. 반환되는 객체는 Json으로 Serialize되어 사용자에게 반환된다.

<br>

### @RestController란?

`@RestController`는 `@Controller`에 `@ResponseBody`가 추가된 것. RestController의 주용도는 Json 형태로 객체 데이터를 반환하는 것. 최근에 데이터를 응답으로 제공하는 REST API를 개발할 때 주로 사용하며 객체를 ResponseEntity로 감싸서 반환한다. 이러한 이유로 동작 과정 역시 `@Controller`에 `@ReponseBody`를 붙인 것과 완벽히 동일하다.

![img_2.png](https://github.com/user-attachments/assets/39e3a6f5-04f9-41a0-b1af-7abd588fdbf6)

1. Client는 URI 형식으로 웹 서비스에 요청을 보낸다.
2. DispatcherServlet이 요청을 처리할 대상을 찾는다.
3. HandlerAdapter을 통해 요청을 Controller로 위임한다.
4. Controller는 요청을 처리한 후에 객체를 반환한다.
5. 반환되는 객체는 Json으로 Serialize되어 사용자에게 반환된다.
