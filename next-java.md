# 2장 문자열 계산기 구현을 통한 테스트와 리팩토링
## main() 메소드를 활용한 테스트의 문제점
## JUnit을 활용해 main() 메소드 문제점 극복
## 테스트 코드 중복 제거
- @Before 애노테이션 활용
- JUnit에는 @RunWith, @Rule 같은 애노테이션을 사용해 기능을 확장할 수 있는데,
- @Before안이어야만 @RunWith, @Rule에서 초기화된 객체에 접근할 수 있다는 제약사항이 있기 때문.
- @After는 메소드 실행이 끝난 후 실행됨으로써 후처리 작업을 담당.
### 문자열 계산기 요구사항 및 실습
#### 정규식 관련 클래스
- Pattern
- Matcher 
- 리팩토링 요구사항

### 테스트와 리팩토링을 통한 문자열 계산기 구현
- 복잡도를 낮출 수 있는 방법 중 하나가 끊임없는 리팩토링을 통해 소스코드를 깔끔하게 구현하는 것
#### 요구사항을 작은 단위로 나누기
- 복잡한 문제를 풀어가기 위해 첫번째로 진행해야하는 작업이 복잡한 문제를 작은 단위로 나눠 좀 더 쉬운 문제로 만드는 작업
- 다양한 문제를 해결해 봄으로써 끊임없이 연습
#### 모든 단계의 끝은 리팩토링
- 소스코드가 복잡도가 쉽게 증가하는 이유는 하나의 요구사항을 완료한 후 리팩토링을 하지 않은 상태에서 다음 단계로 넘어가기 때문
- 구현 -> 테스트를 통한 결과 확인 -> 리팩토링 과정으로 진행.

### 문자열 계산기 구현
#### 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야한다.
```java
public class StringCalculatorTest {
    public StringCalculator cal;

    @BeforeEach
    public void setup() {
        cal = new StringCalculator();
    }

    @Test
    public void add_null_또는_빈문자() {
        assertEquals(0, cal.add(null));
        assertEquals(0, cal.add(""));
    }
}
```
```java
public class StringCalculator {
    public int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return 0;
    }
}
```
#### 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
```java
public class StringCalculatorTest{
    // ...
    @Test
    public void add_숫자하나() throws Exception{
        assertEquals(1, cal.add("1"));
    }
}
```
```java
public class StringCalculator{
    public int add(String text){
        if(text == null || text.isEmpty()){
            return 0;
        }
        return Integer.parseInt(text);
    }
}
```
#### 숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.
```java
public class StringCalculatorTest{
    //...
    @Test
    public void add_쉼표구분자() throws Exception{
        assertEquals(3, cal.add("1,2"));
    }
}
```
```java
public class StringCalculator{
    public int add(String text){
        if(text == null || text.isEmpty()){
            return 0;
        }
        if(text.contains(",")){
            String[] values = text.split(",");
            int sum = 0;
            for(String value : values){
                sum += Integer.parseInt(value);
            }
            return sum;
        }
        return Integer.parseInt(text);
    }
}
```
- 리팩토링할 부분 : 숫자가 하나인 경우와 쉼표 구분자를 포함하는 경우를 따로 분기해서 처리하는 부분
- -> String의 split() 메소드에 숫자 하나를 가지는 문자열을 전달하면 숫자 하나가 담겨있는 String[]을 반환하면 분기문 제거 가능
- -> 확인위해 테스트
