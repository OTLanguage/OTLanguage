<table>
  <th width="50%" align=center>
    <img src="https://github.com/OTLanguage/.github/blob/main/banner.png?raw=true"/>  
  </th>
  <th width="50%" align=center>
    이모티콘으로 제작하는 프로그래밍 언어<br><br>
    이름 유래 <br>
    절망하는 자세인 OTL 과 언어라는 뜻인 Language가 합쳐져 만들어진 언어입니다.<br>
    OTL + Language <br><br>
    <a href="https://github.com/OTLanguage">OTLanguage Github 링크</a>
  </th>
</table>


# 제작자
<div align=left>
  <a href="https://github.com/PersesTitan">
  <img src="https://avatars.githubusercontent.com/PersesTitan" width="100px;" alt=""/>
  <br><b align=center>PersesTitan</b></a>    
</div>

## 추진 배경
제작하게 된 계기는 실용성이 존재하는 난해한 프로그래밍 언어면 재미 있을 것 같아 제작하게 되었습니다.
처음은 제미로 시작하였지만 해당 언어 구현에 가능성을 느끼게 되었고 기능 추가 및 수정, 확장등을 진행 중입니다.

## 파일 확장자
OTLanguage는 `.otl`, `.otlanguage`확장자를 사용합니다.
- 버전 3.1.2 이상부터 `.otlanguage` 확장자를 허용합니다.

## 모듈 확장자
확장자는 `.otlm`를 사용하며
`module/operate`, `module/compulsion`, `module/alteration`

## 동작 환경
 - MacOS
	테스트 환경: `MacBook, Apple M1`
 - Linux
	테스트 환경 : `Red Hat`
 - Window
	`개발중...`
 - Android
 	`개발중...`

## Download
다운로드에는 Git으로 부터 코드를 다운로드하기 때문에 원활한 설치를 위해서는 [git](https://git-scm.com/downloads)이 설치 되어 있는지 확인 부탁드립니다.
MacOS
```shell
curl https://raw.githubusercontent.com/OTLanguage/download/main/mac.sh | sh
```
Linux
```shell
curl https://raw.githubusercontent.com/OTLanguage/download/main/linux.sh | sh
```
Window
**프로토타입 버전** [윈도우 설치 파일 다운로드 링크](https://github.com/OTLanguage/OTLanguage-window-install/archive/refs/heads/main.zip)

Android
```
```

## 실행
<span style="color: yellow">단, 설치 후 처음으로 실행할때는 실행이 느릴 수 있습니다.</span>

대화식 모드 
_(셀에서는 한글 입력이 가끔 깨져서 보이기 때문에 복잡한 동작을 구현할때는 스크립트 모드를 권장합니다.)_

```
otl
```
스크립트 모드
```
otl [파일경로]
```

## 모듈 다운로드
적용 버전 : 3.1.1
형태 : `otl install <프로젝트명>`
예시 
```shell
otl install poison
```
기본적으로 `poison`과 같은 추가 기능들은 기본적으로 설치되어 있지 않기에 모듈을 따로 다운로드하여 사용할 수 있습니다.

# LCS(Line Cleanup System)
LCS(Line Cleanup System)은 OTLanguage에 들어가있는 시스템으로 파일 전체를 간단하게 한번 읽고 실행되기전에 괄호처리 및 사용하지 않는 라인 정리등을 진행하는 시스템입니다. 

특히 여러줄로 포현되어 있는 중괄호 문법을 `한 줄 단위 역할 원칙`에 맞추어 변경해줍니다.
원본 예시
```
0^10^1 {
	ㅆㅁㅆ 값 출력 = :변수명_
} <= ㅇㅈㅇ 변수명
```
LCS를 거친후 예제
```
0^10^1 (test,2,3) <= ㅇㅈㅇ 변수명
```
해당 특징으로 때문에 `<= ㅇㅈㅇ 변수명`에서 만약 타입에러가 발생하여도 `0^10^1 {`에서 에러가 발생하였다고 에러가 출력되게 됩니다.

에러 예시
hello.otl
```
0^10^1 {
    ㅆㅁㅆ 안녕
} <= ㅇㅁㅇ 변수명
```
`ㅇㅁㅇ 변수명`에서 타입에러가 발생하지만 `(hello.otl:1)`, `(0^10^1 {)`를 에러에서 출력하게 됩니다.
![](https://velog.velcdn.com/images/persestitan/post/f736dd11-4227-43cd-8de2-8584b3482845/image.png)

---

# 철학&원칙
## 기본 철학
코드가 깔끔하지 않아도 동작만 되게 하자
~~예초에 깔끔한 프로그래밍 언어는 아니다.~~

## 설계 철학
 1. **" 와 ' 도 문자이다.**
 2. **난해한 프로그래밍언어로 실용적인 동작을 구현하자**
 3. **한글로 프로그래밍을 해보자**
 
## 원칙
 1. **One Line Role Principle** - 한 줄 단위 역할 원칙
 	1줄에 1개의 역할를 가지며, 1줄당 1개의 동작을 가지게 됩니다.

 2. **String Non-Tokenization Principle** - 문자열 비토큰화 원칙
 	모든 문자는 문자이므로 " 나 ' 를 사용하지 않습니다.

 3. **Cut Off Zone Principle** - 공간 단절의 원칙
 	각 중괄호 공간은 단절 공간으로 각각 별개의 공간이 됩니다.

 4. **Replace Oriented Principle** - 치환 지향 원칙
 	치환을 하는 방식으로 값을 사용합니다.
    
 5. **Induction Deduction Principle** - 유도 도출 원칙
 원하는 결과가 발생하지 않았을때 방법을 바꾸어서 원하는 결과를 불러오는 원칙을 말합니다.
 
---
# 변수
## 파라미터
OTLanguage에서 파라미터 단위는 `[]`대괄호로 사용됩니다. 
단, 파라미터가 1개 일때는 대괄호를 생략하고 공백을 대체 할 수 있습니다.

예시
```
ㅆㅁㅆ[Hello World]
ㅆㅁㅆ Hello World
```
위 코드는 같은 동작을 합니다.

## 변수명
### 네이밍 컨벤션
OTLanguage에서는 **[케밥 케이스](https://velog.io/@persestitan/%EB%84%A4%EC%9D%B4%EB%B0%8D-%EC%BB%A8%EB%B2%A4%EC%85%98%EC%97%90-%EB%8C%80%ED%95%B4%EC%84%9C)**를 사용합니다.
ex) 변수명 ```변수명-정의```

### 명명 규칙
변수명은 **숫자, 한글, 영어, 하이픈(-)** 으로 이루어진 변수를 정의 할 수 있습니다.

변수명은 숫자로만 구현할 수 없으며, 변수명 가장 앞 글자는 문자이여야 합니다.
ex) 
```
변수1 (O) 올바른 예
1변수 (X) 틀린 예
```

### 예약어
예약어는 이미 정의된 단어로 변수명으로 사용할 수 없는 단어를 말합니다.

- 예약어 : `ㅅㅇㅅ`, `ㅇㅇ`, `ㄴㄴ`, `ㅇㄴ`, `ㄸ`, `ㄲ`, `ㅇ-ㅇ`, `ㅈㅈㅈ`, `ㅈㅉㅈ`, `ㅈㅂㅈ`, `ㅈㅁㅈ`, `ㅈㄱㅈ`, `ㅈㅅㅈ`, `ㅈㅆㅈ`
- 사용 불가 예시 : `ㅇㅅㅇ ㅅㅇㅅ:3.14`

- 참고
> 예약어는 이미 사용하고 있는 존재하는 단어나 **Map**정의 단어와 같은 경우 아이템을 추가하는 과정중 `ㅈㅁㅈ 키<<<값` 과 같은 형태가 **Map**변수를 정의하는 형태와 일치하여 사용이 불가합니다.
<br>**List** 및 **Set** 정의 단어를 사용할때도 띄어쓰기등을 주의해주어야 합니다.

### 포함 불가능 단어
계산 및 분석을 진행할때 기준을 애매하게 만들 수 있는 단어들은 변수명에서 사용할 수 없습니다.
포함 불가능한 단어 : `ㅇㅇ`, `ㅇㄴ`, `ㄴㄴ`, `ㄸ`, `ㄲ`
사용 불가 예시 : `ㅇㅅㅇ 변ㅇㄴ수:3.14`

### 변수의 유효 범위
기본적으로 생성되는 변수는 전역 변수로 생성됩니다.
크게 변수는 `전역 변수`, `클래스 변수`, `메소드 변수`로 단위가 나뉘게 됩니다.

상위 변수에  접근하기 위해서는 `~`를 앞에 붙쳐서 상위 클래스에 접근할 수 있습니다.
```
ㅇㅁㅇ 변수명:출력1
ㅁㅅㅁ 메소드[] {
	ㅇㅁㅇ 변수명:출력2
    ㅆㅁㅆ :~변수명_
    ㅆㅁㅆ :변수명_
}
메소드[]

출력
출력1
출력2
```

### <span style="color: yellow">토큰</span>
**치환 지향 원칙**에 따라 값 변경은 치환을 통해 원하는 값을 유도하게 되는데 원하는 값을 얻기 위해 원하는 값을 구분을 위해서 토큰을 사용하게 됩니다.
 - 형태 `:<반환값을 가지는 문법>_`
토큰은 사용하면 변경된 값이 고정되는데 때문에 `$ㅅ$`과 같은 반복문에서 사용하면 무한 반복문에 빠질 수 있으므로 사용할때 조심해야합니다.

버전 3.1.3
버전 3.1.3 이후 부터 일부 파라미터에서는 토큰을 생략할 수 있는데 생략하면 토큰 치환 형태보다 계산 속도가 보다 빠르며, 무한 반복문에서도 안전할 수 있습니다.

예시
```
ㅇㅂㅇ 블린:ㅇㅇ
ㅇㅈㅇ 정수:10
$ㅅ$ 블린 ㄸ 정수 ㅇ>ㅇ 11 {
   ㅆㅁㅆ 안녕
   블린:ㄴㄴ
}
```

생략가능 파라미터
생략이 가능한 파라미터 값은 `숫자형`, `블린형` 이며 파라미터 입력값이 숫자와 블린형이여야 적용됩니다. 
버전 차이로 인해서 미적용이 된 파라미터가 있을 수 있다는 점 참고 바랍니다.

### 초기값 변수
기본 타입의 변수의 초기값은 반드시 정의해주어야합니다.
 - ㅇㅁㅇ 변수명 (×)
 - ㅇㅁㅇ 변수명:값 (○)
 
### 휘발성 변수
특정 횟수많큼 사용하면 사라지는 변수를 말합니다.
변수를 생성 할때 사용할 횟수를 정의 할 수 있습니다.
출시 버전 : 3.1.0
형태 : <변수타입> [횟수]<변수명>:<초기값>
```
ㅇㅁㅇ [1]변수:안녕
ㅆㅁㅆ :변수_ :변수_

출력
안녕 :변수_
```

### 기본값
존재하지 않는 변수일 경우 그대로 출력이 되는데 기본값을 정의해주면 그대로 출력되는 것을 방지 할 수 있습니다.
출시 버전 : 3.1.0
형태 : `:<동작>_<기본값>;`
```
ㅆㅁㅆ :변수명_기본값;

출력
기본값
```

## 타입
### Primitive
출시 버전 : 1.0.0
 - ㅇㅈㅇ 정수형(Integer)
 - ㅇㅉㅇ 쩡수형(Long)
 - ㅇㅂㅇ 블린형(Boolean)
 - ㅇㅁㅇ 문자형(String)
 - ㅇㄱㅇ 글자형(Character)
 - ㅇㅅㅇ 실수형(Float)
 - ㅇㅆㅇ 씰수형(Double) 

> **데이터 표현 범위**
> 정수형: `–2,147,483,648 ~ 2,147,483,647`
> 쩡수형: `-9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807`
> 블린형: `ㅇㅇ, ㄴㄴ`
> 글자형: `\u0000 ~ \uFFFF`
> 실수형: `3.4E–38 ~ 3.4E+38`
> 씰수형: `4.94065645841246544E-324~1.79769313486231570E+308`
> 문자형: `-`
 
### Set
출시 버전 : 2.0.0
값을 Set의 형태로 가지게 됩니다.
**중복 값을 허용하지 않습니다.**

데이터 형태 : [값1, 값2]
**변수 정의**
`<타입> <변수명>`
`<타입> <변수명>:[값1, 값2]`
`<타입> <변수명><[값1, 값2]`


 - ㄴㅈㄴ 정수형(Set&lt;Integer&gt;)
 - ㄴㅉㄴ 쩡수형(Set&lt;Long&gt;)
 - ㄴㅂㄴ 블린형(Set&lt;Boolean&gt;)
 - ㄴㅁㄴ 문자형(Set&lt;String&gt;)
 - ㄴㄱㄴ 글자형(Set&lt;Character&gt;)
 - ㄴㅅㄴ 실수형(Set&lt;Float&gt;)
 - ㄴㅆㄴ 씰수형(Set&lt;Double&gt;)
 
#### ADD
출시 버전 : 2.0.0
Set에 값을 넣을 수 있습니다.
형태 : `[변수명]<[값]`
```
ㄴㅈㄴ 변수명
변수명<1
변수명<[2,3]
ㅆㅁㅆ :변수명_

출력
[1, 2, 3]
```

#### DELETE
출시 버전 : 2.0.0
Set의 값을 제거할 수 있습니다.
형태 : `<변수명>!-<인덱스>`
```
ㄴㅈㄴ 변수명:[1,2,3]
변수명!-1
ㅆㅁㅆ :변수명_

출력
[2, 3]
```

#### GET
출시 버전 : 2.0.0
Set의 값을 가져올 수 있습니다.
형태 : `:[변수명]>[인덱스]_`
```
ㄴㅈㄴ 변수명:[1,2,3]
ㅆㅁㅆ :변수명>1_

출력
1
```

#### ISEMPTY
출시 버전 : 2.0.0
Set이 비어있는지 확인합니다.
형태 : `:<변수명>?_`
```
ㄴㅈㄴ 변수명
ㅆㅁㅆ :변수명_
ㅆㅁㅆ :변수명?_
변수명<1
ㅆㅁㅆ :변수명_
ㅆㅁㅆ :변수명?_


출력
[]
ㅇㅇ
[1]
ㄴㄴ
```

#### SUM
출시 버전 : 2.0.0
Set의 총합을 구할 수 있습니다.
단, 숫자인 값을 가지는 `ㄴㅈㄴ, ㄴㅉㄴ, ㄴㅅㄴ, ㄴㅆㄴ`에서만 사용할 수 있습니다.
형태 : `:<변수명>+_`

```
ㄴㅈㄴ 변수명:[1,2,3]
ㅆㅁㅆ :변수명+_

출력
6
```
#### CLEAR
출시 버전 : 2.0.0
Set값을 전부 삭제할 수 있습니다.
형태 : `<변수명>!`
```
ㄴㅈㄴ 변수명:[1,2,3]
ㅆㅁㅆ :변수명_
변수명!
ㅆㅁㅆ :변수명_

출력
[1, 2, 3]
[]
```

#### SORT
출시 버전 : 3.1.0
Set를 순서대로 정렬합니다.
형태 : `<변수명>&`
```
ㄴㅈㄴ 변수명:[3,1,2]
변수명&
ㅆㅁㅆ :변수명_

출력
[1, 2, 3]
```


#### LENGTH
출시 버전 : 3.1.0
Set의 길이를 구하게 됩니다.
형태 : `:<변수명>'_`
```
ㄴㅈㄴ 변수명:[1,2,3]
ㅆㅁㅆ :변수명'_

출력
3
```

#### CONTAINS
출시 버전 : 3.1.0
Set에 해당 값이 존재하는지 확인합니다.
형태 : `:<변수명>?<값>_`
```
ㄴㅈㄴ 변수명:[1,2,3]
ㅆㅁㅆ :변수명?1_
ㅆㅁㅆ :변수명?5_

출력
ㅇㅇ
ㄴㄴ
```


### List
출시 버전 : 2.0.0
값을 List의 형태로 가지게 됩니다.
Set과 다르게 **중복값을 허용**합니다.

데이터 형태 : [값1, 값2]
**변수 정의**
`<타입> <변수명>`
`<타입> <변수명>:[값1, 값2]`
`<타입> <변수명><<[값1, 값2]`


 - ㄹㅈㄹ 정수형(List&lt;Integer&gt;)
 - ㄹㅉㄹ 쩡수형(List&lt;Long&gt;)
 - ㄹㅂㄹ 블린형(List&lt;Boolean&gt;)
 - ㄹㅁㄹ 문자형(List&lt;String&gt;)
 - ㄹㄱㄹ 글자형(List&lt;Character&gt;)
 - ㄹㅅㄹ 실수형(List&lt;Float&gt;)
 - ㄹㅆㄹ 씰수형(List&lt;Double&gt;)
 
 
#### ADD
출시 버전 : 2.0.0
List의 값을 추가합니다.
형태 : `[변수명]<<[값]`
```
ㄹㅈㄹ 변수명
변수명<<1
변수명<<[2, 3]
ㅆㅁㅆ :변수명_

출력
[1, 2, 3]
```

#### DELETE
출시 버전 : 2.0.0
List의 값을 제거합니다.
형태 : `<변수명>--<인덱스>`
```
ㄹㅈㄹ 변수명:[1,2,3]
변수명--1
ㅆㅁㅆ :변수명_

출력
[2, 3]
```

#### GET
출시 버전 : 2.0.0
특정 List 값을 반환합니다.
형태 : `:[변수명]>>[인덱스]_`
```
ㄹㅈㄹ 변수명:[1,2,3]
ㅆㅁㅆ :변수명>>1_

출력
1
```

#### ISEMPTY
출시 버전 : 2.0.0
List가 비어있는지 확인합니다.
형태 : `:<변수명>??_`
```
ㄹㅈㄹ 변수명
ㅆㅁㅆ :변수명??_
변수명<<1
ㅆㅁㅆ :변수명??_

출력
ㅇㅇ
ㄴㄴ
```


#### SUM
출시 버전 : 2.0.0
List의 총합을 반환합니다.
단, 숫자인 값을 가지는 `ㄹㅈㄹ, ㄹㅉㄹ, ㄹㅅㄹ, ㄹㅆㄹ`에서만 사용할 수 있습니다.
형태 : `:<변수명>++_`
```
ㄹㅈㄹ 변수명:[1,2,3]
ㅆㅁㅆ :변수명++_

출력
6
```
#### CLEAR
출시 버전 : 2.0.0
List값을 전부 삭제합니다.
형태 : `<변수명>!!`
```
ㄹㅈㄹ 변수명:[1,2,3]
ㅆㅁㅆ :변수명_
변수명!!
ㅆㅁㅆ :변수명_

출력
[1, 2, 3]
[]
```

#### SORT
출시 버전 : 3.1.0
List값을 정렬합니다.
형태 : `<변수명>&&`
```
ㄹㅈㄹ 변수명:[3,2,1]
변수명&&
ㅆㅁㅆ :변수명_

출력
[1, 2, 3]
```

#### LENGTH
출시 버전 : 3.1.0
List의 길이를 반환합니다.
형태 : `:<변수명>''_`
```
ㄹㅈㄹ 변수명:[1, 2, 3]
ㅆㅁㅆ :변수명''_

출력
3
```

#### CONTAINS
출시 버전 : 3.1.0
List에 값이 있는지 확인합니다.
형태 : `:<변수명>??<값>_`
```
ㄹㅈㄹ 변수명:[1, 2, 3]
ㅆㅁㅆ :변수명??1_
ㅆㅁㅆ :변수명??5_

출력
ㅇㅇ
ㄴㄴ
```


### Map
출시 버전 : 2.0.0
**키(Key)와 값(Value)**가 한쌍으로 이루어진 타입입니다.
**키값은 중복**으로 존재하지 않습니다.

데이터 형태 : {키1=값2, 키2=값2}
**변수 정의**
`<타입> <변수명>`
`<타입> <변수명>:{키1=값1, 키2=값2}`
`<타입> <변수명><<<{키1=값1, 키2=값2}`


- ㅈㅈㅈ 정수형(Map&lt;String, Integer&gt;)
- ㅈㅉㅈ 쩡수형(Map&lt;String, Long&gt;)
- ㅈㅂㅈ 블린형(Map&lt;String, Boolean&gt;)
- ㅈㅁㅈ 문자형(Map&lt;String, String&gt;)
- ㅈㄱㅈ 글자형(Map&lt;String, Character&gt;)
- ㅈㅅㅈ 실수형(Map&lt;String, Float&gt;)
- ㅈㅆㅈ 씰수형(Map&lt;String, Double&gt;)

#### CLEAR
출시 버전 : 2.0.0
Map값을 전부 삭제합니다.
형태 : `<변수명>!!!`
```
ㅈㅈㅈ 변수명:{a=1, b=2}
ㅆㅁㅆ :변수명_
변수명!!!
ㅆㅁㅆ :변수명_

출력
{a=1, b=2}
{}
```
#### DELETE
출시 버전 : 2.0.0
특정 Map값을 삭제합니다.
형태 : `<변수명>!---<키 값>`
```
ㅈㅈㅈ 변수명:{a=1, b=2}
ㅆㅁㅆ :변수명_
변수명!---a
ㅆㅁㅆ :변수명_

출력
{b=2}
```

#### ADD
출시 버전 : 2.0.0
Map값을 추가합니다.
형태1 : `[변수명]<<<{키=값, 키1=값1, ...}`
형태2 : `[변수명] 키<<<값`(버전 3.1.0)

```
ㅈㅈㅈ 변수명
변수명<<<{a=1}
변수명 b<<<2
ㅆㅁㅆ :변수명_

출력
{a=1, b=2}
```

#### GET
출시 버전 : 2.0.0
Map의 특정 값을 가져옵니다.
형태 : `:[변수명]>>>[키]_`
```
ㅈㅈㅈ 변수명:{a=1, b=2}
ㅆㅁㅆ :변수명>>>a_

출력
1
```

#### ISEMPTY
출시 버전 : 3.1.0
Map이 비어있는지 확인합니다.
형태 : `:<변수명>???_`
```
ㅈㅈㅈ 변수명
ㅆㅁㅆ :변수명???_
변수명 a<<<1
ㅆㅁㅆ :변수명???_

출력
ㅇㅇ
ㄴㄴ
```

#### LENGTH
출시 버전 : 3.1.0
Map의 길이를 반환합니다.
형태 : `:<변수명>'''_`
```
ㅈㅈㅈ 변수명:{a=1, b=2}
ㅆㅁㅆ :변수명'''_

출력
2
```

#### CONTAINS
출시 버전 : 3.1.0
Map에 키값을 기준으로 값이 존재하는지 확인합니다.
형태 : `:<변수명>???<키>_`
```
ㅈㅈㅈ 변수명:{a=1, b=2}
ㅆㅁㅆ :변수명???a_
ㅆㅁㅆ :변수명???c_

출력
ㅇㅇ
ㄴㄴ
```

---

# List
## 집합
### ㅎㅈㅎ
**합집합**
출시 버전 : 3.1.2
파라미터 갯수 : 2개
형태 : `<리스트>~ㅎㅈㅎ[<리스트 변수명>][<리스트>]`
목록
- ㄹㅈㄹ~ㅎㅈㅎ[<리스트 변수명>][<리스트>]
- ㄹㅉㄹ~ㅎㅈㅎ[<리스트 변수명>][<리스트>]
- ㄹㅂㄹ~ㅎㅈㅎ[<리스트 변수명>][<리스트>]
- ㄹㅁㄹ~ㅎㅈㅎ[<리스트 변수명>][<리스트>]
- ㄹㄱㄹ~ㅎㅈㅎ[<리스트 변수명>][<리스트>]
- ㄹㅅㄹ~ㅎㅈㅎ[<리스트 변수명>][<리스트>]
- ㄹㅆㄹ~ㅎㅈㅎ[<리스트 변수명>][<리스트>]
```
ㄹㅈㄹ 리스트1:[1, 2, 3]
ㄹㅈㄹ 리스트2:[4, 5]
ㄹㅈㄹ~ㅎㅈㅎ[리스트1][리스트2]
ㅆㅁㅆ :리스트1_
ㄹㅈㄹ~ㅎㅈㅎ[리스트1][[6, 7]]
ㅆㅁㅆ :리스트1_

출력
[1, 2, 3, 4, 5]
[1, 2, 3, 4, 5, 6, 7]
```

### ㄱㅈㅎ
**교집합**
출시 버전 : 3.1.2
파라미터 갯수 : 2개
형태 : `<리스트>~ㄱㅈㅎ[<리스트 변수명>][<리스트>]`
목록
- ㄹㅈㄹ~ㄱㅈㅎ[<리스트 변수명>][<리스트>]
- ㄹㅉㄹ~ㄱㅈㅎ[<리스트 변수명>][<리스트>]
- ㄹㅂㄹ~ㄱㅈㅎ[<리스트 변수명>][<리스트>]
- ㄹㅁㄹ~ㄱㅈㅎ[<리스트 변수명>][<리스트>]
- ㄹㄱㄹ~ㄱㅈㅎ[<리스트 변수명>][<리스트>]
- ㄹㅅㄹ~ㄱㅈㅎ[<리스트 변수명>][<리스트>]
- ㄹㅆㄹ~ㄱㅈㅎ[<리스트 변수명>][<리스트>]
```
ㄹㅈㄹ 리스트1:[1, 2, 3, 4]
ㄹㅈㄹ 리스트2:[4, 5]
ㄹㅈㄹ~ㄱㅈㅎ[리스트1][리스트2]
ㅆㅁㅆ :리스트1_

리스트1:[1, 2, 3, 4]
ㄹㅈㄹ~ㄱㅈㅎ[리스트1][[1, 3]]
ㅆㅁㅆ :리스트1_

출력
[4]
[1, 3]
```

### ㅊㅈㅎ
**차집합**
출시 버전 : 3.1.2
파라미터 갯수 : 2개
형태 : `<리스트>~ㅊㅈㅎ[<리스트 변수명>][<리스트>]`
목록
- ㄹㅈㄹ~ㅊㅈㅎ[<리스트 변수명>][<리스트>]
- ㄹㅉㄹ~ㅊㅈㅎ[<리스트 변수명>][<리스트>]
- ㄹㅂㄹ~ㅊㅈㅎ[<리스트 변수명>][<리스트>]
- ㄹㅁㄹ~ㅊㅈㅎ[<리스트 변수명>][<리스트>]
- ㄹㄱㄹ~ㅊㅈㅎ[<리스트 변수명>][<리스트>]
- ㄹㅅㄹ~ㅊㅈㅎ[<리스트 변수명>][<리스트>]
- ㄹㅆㄹ~ㅊㅈㅎ[<리스트 변수명>][<리스트>]
```
ㄹㅈㄹ 리스트1:[1, 2, 3, 4]
ㄹㅈㄹ 리스트2:[4, 5]
ㄹㅈㄹ~ㅊㅈㅎ[리스트1][리스트2]
ㅆㅁㅆ :리스트1_

리스트1:[1, 2, 3, 4]
ㄹㅈㄹ~ㅊㅈㅎ[리스트1][[1, 3, 6]]
ㅆㅁㅆ :리스트1_

출력
[1, 2, 3]
[2, 4]
```

### ㅂㅈㅎ
**부분집합**
출시 버전 : 3.1.2
파라미터 갯수 : 2개
형태 : `:<리스트>~ㅂㅈㅎ[<리스트>][<리스트>]_`
목록
- ㄹㅈㄹ~ㅂㅈㅎ[<리스트>][<리스트>]
- ㄹㅉㄹ~ㅂㅈㅎ[<리스트>][<리스트>]
- ㄹㅂㄹ~ㅂㅈㅎ[<리스트>][<리스트>]
- ㄹㅁㄹ~ㅂㅈㅎ[<리스트>][<리스트>]
- ㄹㄱㄹ~ㅂㅈㅎ[<리스트>][<리스트>]
- ㄹㅅㄹ~ㅂㅈㅎ[<리스트>][<리스트>]
- ㄹㅆㄹ~ㅂㅈㅎ[<리스트>][<리스트>]
```
ㄹㅈㄹ 리스트1:[1, 2, 3, 4]
ㄹㅈㄹ 리스트2:[1, 3, 4]
ㅆㅁㅆ :ㄹㅈㄹ~ㅂㅈㅎ[리스트1][리스트2]_

리스트1:[1, 2, 3, 4]
ㅆㅁㅆ :ㄹㅈㄹ~ㅂㅈㅎ[리스트1][[1, 3, 6]]_
ㅆㅁㅆ :ㄹㅈㄹ~ㅂㅈㅎ[[1, 6]][[1, 3, 6]]_
ㅆㅁㅆ :ㄹㅈㄹ~ㅂㅈㅎ[[1, 3, 5, 6]][[1, 3, 6]]_

출력
ㅇㅇ
ㄴㄴ
ㄴㄴ
ㅇㅇ
```

---
# 콘솔
## 출력
출시 버전 : 1.0.0
### ㅅㅁㅅ
형태 : `ㅅㅁㅅ <출력 내용>`
출력 내용을 출력합니다.
```
코드
ㅅㅁㅅ 안녕
ㅅㅁㅅ 하세요?

출력
안녕하세요?
```

### ㅆㅁㅆ
출시 버전 : 1.0.0
형태 : `ㅆㅁㅆ <출력 내용>`
개행 문자가 들어간 출력 내용을 출력합니다.
```
코드
ㅆㅁㅆ 안녕
ㅆㅁㅆ 하세요?

출력
안녕
하세요?
```

### ㅅㅁㅆ
출시 버전 : 3.0.0
형태 : `ㅅㅁㅆ <출력 내용>`
탭(\t)이 들어간 출력 내용을 출력합니다.
```
코드
ㅅㅁㅆ 안녕
ㅅㅁㅆ 하세요?

출력
안녕		하세요?
```


### ㅆㅁㅅ
출시 버전 : 3.0.0
형태 : `ㅆㅁㅅ <출력 내용>`
공백(" ")이 들어간 출력 내용을 출력합니다.
```
코드
ㅆㅁㅅ 안녕
ㅆㅁㅅ 하세요?

출력
안녕 하세요?
```


## 강제 출력
출력 내용을 유지하며 출력합니다.
강제 출력은 <span style="color: yellow">우선순위가 최상위</span>이기 때문에 입력한 내용에 영향없이 그대로 출력할 수 있습니다.

### !ㅅㅁㅅ!
출시 버전 : 2.0.0
형태 : `!ㅅㅁㅅ! <출력 내용>`
출력 내용을 수정 없이 출력합니다.
```
ㅇㅈㅇ 변수명:1234
!ㅅㅁㅅ! :변수명_
!ㅅㅁㅅ! :ㅅㅇㅅ_

출력
:변수명_:ㅅㅇㅅ_
```

### !ㅆㅁㅆ!
출시 버전 : 2.0.0
형태 : `!ㅆㅁㅆ! <출력 내용>`
개행 문자가 들어간 출력 내용을 수정 없이 출력합니다.
```
ㅇㅈㅇ 변수명:1234
!ㅆㅁㅆ! :변수명_
!ㅆㅁㅆ! :ㅅㅇㅅ_

출력
:변수명_
:ㅅㅇㅅ_
```

### !ㅅㅁㅆ!
출시 버전 : 3.0.0
형태 : `!ㅅㅁㅆ! <출력 내용>`
탭(\t)이 들어간 출력 내용을 수정 없이 출력합니다.
```
ㅇㅈㅇ 변수명:1234
!ㅅㅁㅆ! :변수명_
!ㅅㅁㅆ! :ㅅㅇㅅ_

출력
:변수명_		:ㅅㅇㅅ_
```

### !ㅆㅁㅅ!
출시 버전 : 3.0.0
형태 : `!ㅆㅁㅅ! <출력 내용>`
공백(" ")이 들어간 출력 내용을 수정 없이 출력합니다.
```
ㅇㅈㅇ 변수명:1234
!ㅆㅁㅅ! :변수명_
!ㅆㅁㅅ! :ㅅㅇㅅ_

출력
:변수명_ :ㅅㅇㅅ_
```

## 입력
### ㅅㅇㅅ
출시 버전 : 1.0.0
형태 : `:ㅅㅇㅅ_`
사용자로부터 입력을 받을 수 있습니다.

사용 예시
```
ㅆㅁㅆ :ㅅㅇㅅ_

입력
10
출력
10
```

---
# 논리연산
## 기호
### ㅇㅇ
출시 버전 : 1.0.0
형태 : `ㅇㅇ`
<span style="color: yellow">참(true)</span>를 의미합니다.

### ㄴㄴ
출시 버전 : 1.0.0
형태 : `ㄴㄴ`
<span style="color: yellow">거짓(false)</span>를 의미합니다.

### ㅇㄴ
출시 버전 : 1.0.0
형태 : `ㅇㄴ`
<span style="color: yellow">반전(not)</span>를 의미합니다.
 - ㅇㄴ ㅇㅇ => ㄴㄴ
 - ㅇㄴ ㄴㄴ => ㅇㅇ

### ㄸ
출시 버전 : 1.0.0
형태 : `ㄸ`
<span style="color: yellow">또는(or)</span>을 의미합니다.
 - ㅇㅇ ㄸ ㅇㅇ => ㅇㅇ
 - ㅇㅇ ㄸ ㄴㄴ => ㅇㅇ
 - ㄴㄴ ㄸ ㄴㄴ => ㄴㄴ

### ㄲ
출시 버전 : 1.0.0
형태 : `ㄲ`
<span style="color: yellow">그리고(and)</span>를 의미합니다.
 - ㅇㅇ ㄲ ㅇㅇ => ㅇㅇ
 - ㅇㅇ ㄲ ㄴㄴ => ㄴㄴ
 - ㄴㄴ ㄲ ㄴㄴ => ㄴㄴ

## 비교 연산자
### ㅇ>ㅇ
출시 버전 : 1.0.0
형태 : `ㅇ>ㅇ`
보다 클때 ㅇㅇ을 반환
 - 1ㅇ>ㅇ2 => ㄴㄴ
 - 2ㅇ>ㅇ1 => ㅇㅇ

### ㅇ<ㅇ
출시 버전 : 1.0.0
형태 : `ㅇ<ㅇ`
보다 작을때 ㅇㅇ을 반환
 - 1ㅇ<ㅇ2 => ㅇㅇ
 - 2ㅇ<ㅇ1 => ㄴㄴ

### ㅇ=ㅇ
출시 버전 : 1.0.0
형태 : `ㅇ=ㅇ`
값이 같을때 ㅇㅇ을 반환
 - 1ㅇ=ㅇ1 => ㅇㅇ
 - 1ㅇ=ㅇ0 => ㄴㄴ

### ㅇ>=ㅇ
출시 버전 : 1.0.0
형태 : `ㅇ>=ㅇ`
값이 크거나 같을때 ㅇㅇ을 반환
 - 1ㅇ>=ㅇ1 => ㅇㅇ
 - 1ㅇ>=ㅇ2 => ㄴㄴ
 - 2ㅇ>=ㅇ1 => ㅇㅇ

### ㅇ<=ㅇ
출시 버전 : 1.0.0
형태 : `ㅇ<=ㅇ`
값이 작거나 같을때 ㅇㅇ을 반환
 - 1ㅇ<=ㅇ1 => ㅇㅇ
 - 1ㅇ<=ㅇ2 => ㅇㅇ
 - 2ㅇ<=ㅇ1 => ㄴㄴ
 
# 숫자
## 연산자
### 우선 순위
`%`, `*`, `/`를 먼저 계산한 뒤에 `+`, `-`가 계산이 됩니다.
먼저 계산을 하고 싶다면`(`, `)`사이에 식을 사용하여 구할 수 있습니다.

### ㅇ+ㅇ
출시 버전 : 1.0.0
형태 : `ㅇ+ㅇ`
덧셈(+)을 의미합니다.
각 값을 <span style="color: yellow">더한 값</span>을 구하게 됩니다.
 - 1ㅇ+ㅇ1 => 2

### ㅇ-ㅇ
출시 버전 : 1.0.0
형태 : `ㅇ-ㅇ`
빼기(-)를 의미합니다.
각 값을 <span style="color: yellow">뺀 값</span>을 구하게 됩니다.
 - 2ㅇ-ㅇ1 => 1

### ㅇ\*ㅇ
출시 버전 : 1.0.0
형태 : `ㅇ*ㅇ`
곱하기(\*)를 의미합니다.
각 값을 <span style="color: yellow">곱한 값</span>을 구하게 됩니다.
 - 2ㅇ\*ㅇ1 => 2

### ㅇ/ㅇ
출시 버전 : 1.0.0
형태 : `ㅇ/ㅇ`
나누기(/)를 의미합니다.
각 값을 <span style="color: yellow">나눈 값</span>을 구하게 됩니다.
 - 10ㅇ/ㅇ2 => 5


### ㅇ%ㅇ
출시 버전 : 1.0.0
형태 : `ㅇ%ㅇ`
나머지(%)를 의미합니다.
각 값을 <span style="color: yellow">나눈 나머지값</span>을 구하게 됩니다.
 - 10ㅇ%ㅇ3 => 1

# ㅇㅁㅇ (문자열)
### ㅉㅇㅉ
출시 버전 : 3.1.0
최신 업데이트 버전 : 3.1.2
Join를 의미합니다.
형태 : `:ㅇㅁㅇ~ㅉㅇㅉ[값][리스트]_`
```
ㄹㅈㄹ 리스트:[1,2,3,4]
ㅆㅁㅆ :ㅇㅁㅇ~ㅉㅇㅉ[ ][리스트]
ㅆㅁㅆ :ㅇㅁㅇ~ㅉㅇㅉ[,][리스트]

출력
1 2 3 4
1,2,3,4
```

### ㅅㅍㅅ
출시 버전 : 3.1.0
최신 업데이트 버전 : 3.1.2
Split를 의미합니다.
문자열을 조건기준으로 나눕니다.
형태 : `:ㅇㅁㅇ~ㅅㅍㅅ[문자열][조건]_`
```
ㅆㅁㅆ :ㅇㅁㅇ~ㅅㅍㅅ[안ㅁ녕ㅁ하ㅁ세ㅁ요][ㅁ]_

출력
[안, 녕, 하, 세, 요]
```



### ㅆㅍㅆ
출시 버전 : 3.1.0
최신 업데이트 버전 : 3.1.2
Split를 의미합니다. 하지만 조건값은 정규식에 의존합니다.
형태 : `:ㅇㅁㅇ~ㅆㅍㅆ[문자열][조건]_`
```
ㅆㅁㅆ :ㅇㅁㅇ~ㅆㅍㅆ[안 녕 하 세 요][\s]_

출력
[안, 녕, 하, 세, 요]
```

### CONTAINS
출시 버전 : 3.1.0
최신 업데이트 버전 : 3.1.2
형태 : `:ㅇㅁㅇ~?[문자1][문자2]_`
문자1에 문자2가 포함되어 있으면 `ㅇㅇ`를 반환하고 포함되어있지 않으면 `ㄴㄴ`를 반환합니다.
```
ㅆㅁㅆ :ㅇㅁㅇ~?[안녕하세요.][안]_
ㅆㅁㅆ :ㅇㅁㅇ~?[안녕하세요.][ㄴ]_

출력
ㅇㅇ
ㄴㄴ
```

### EQUALS
출시 버전 : 3.1.0
최신 업데이트 버전 : 3.1.2
형태 : `:ㅇㅁㅇ~=?[문자1][문자2]_`
문자1과 문자2가 일치하면 `ㅇㅇ`를 반환하고 일치하지 않으면 `ㄴㄴ`를 반환합니다.
```
ㅆㅁㅆ :ㅇㅁㅇ~?[안][안]_
ㅆㅁㅆ :ㅇㅁㅇ~?[안][녕]_

출력
ㅇㅇ
ㄴㄴ
```

### Lower
출시 버전 : 3.2.0
최신 업데이트 버전 : 3.2.0
형태 : `ㅇㅁㅇ~ㅅㅁㅅ <값>`
문자를 모두 소문자로 만들어줍니다.
```
ㅆㅁㅆ :ㅇㅁㅇ~ㅅㅁㅅ aA_

출력
aa
```

### Upper
출시 버전 : 3.2.0
최신 업데이트 버전 : 3.2.0
형태 : `ㅇㅁㅇ~ㄷㅁㄷ <값>`
문자를 모두 대문자로 만들어줍니다.
```
ㅆㅁㅆ :ㅇㅁㅇ~ㄷㅁㄷ aA_

출력
AA
```

### Index
출시 버전 : 3.2.0
최신 업데이트 버전 : 3.2.0
형태 : `ㅇㅁㅇ~ㅇㅊㅇ[<문자열 값>][<찾을 문자>]`
문자열 값에서 찾을 문자의 위치를 정수형으로 반환합니다.
만약 존재하지 않으면 -1를 반환합니다.
```
ㅆㅁㅆ :ㅇㅁㅇ~ㅇㅊㅇ[aaa.aaa.aaa][.]_
ㅆㅁㅆ :ㅇㅁㅇ~ㅇㅊㅇ[aaa.aaa.aaa][!]_

출력
3
-1
```

### LastIndex
출시 버전 : 3.2.0
최신 업데이트 버전 : 3.2.0
형태 : `ㅇㅁㅇ~ㅇㅈㅇ[<문자열 값>][<찾을 문자>]`
문자열 값에서 찾을 문자의 위치를 뒤에서 부터 찾으며 정수형으로 반환합니다.
만약 존재하지 않으면 -1를 반환합니다.
```
ㅆㅁㅆ :ㅇㅁㅇ~ㅇㅈㅇ[aaa.aaa.aaa][.]_
ㅆㅁㅆ :ㅇㅁㅇ~ㅇㅈㅇ[aaa.aaa.aaa][!]_

출력
7
-1
```

### SubString
출시 버전 : 3.2.0
최신 업데이트 버전 : 3.2.0
형태1 : `ㅇㅁㅇ~ㅋㅌㅋ[<문자열 값>][<위치 값>]`
형태2 : `ㅇㅁㅇ~ㅋㅌㅋ[<문자열 값>][<위치 값1>][<위치 값2>]`
형태1은 `위치 값`에서 마지막까지 잘라서 출력하고, 형태2 `위치 값1`부터 `위치 값2`까지의 값까지를 잘라서 반환합니다.
```
ㅆㅁㅆ :ㅇㅁㅇ~ㅋㅌㅋ[Hello World][3]_
ㅆㅁㅆ :ㅇㅁㅇ~ㅋㅌㅋ[Hello World][3][6]_

출력
lo World
lo
```

---

# 조건문
### ?ㅅ?문
출시 버전 : 2.0.0
최신 업데이트 버전 : 3.1.2
형태 : `?ㅅ? <블린형> {...}`
if문으로 블린형이 `ㅇㅇ`이면 {...} 내용을 실행하고 `ㄴㄴ`이면 통과를 합니다.
```
0^10^1 {
		ㅆㅁㅆ :ㅁ_
}<=ㅇㅈㅇ ㅁ
```

### ?ㅈ?문
출시 버전 : 2.1.0
최신 업데이트 버전 : 3.1.2
형태 : `?ㅈ? <블린형> {...}`
else if문으로 ?ㅈ?앞에는 반드시 `?ㅅ?`를 먼저 정의 해주어야 합니다.
```

```


### ?ㅉ?문
출시 버전 : 2.1.0
최신 업데이트 버전 : 3.1.2
형태 : `?ㅉ? <블린형> {...}`
else문으로 ?ㅈ?앞에는 반드시 `?ㅈ?` 또는 `?ㅉ?`를 먼저 정의 해주어야 합니다.
```

```

---
# 반복문
### ^^문
출시 버전 : 2.0.0
최신 업데이트 버전 : 3.1.2
형태1 : `<숫자1>^<숫자2>^<숫자3> {...} <= <타입> <변수명>`
형태2 : `^<리스트>^ {...} <= <타입> <변수명>`
형태3 : `<숫자1>^<숫자2>^<숫자3> {...}`
형태4 : `^<리스트>^ {...}`
for 문으로 형태1, 형태3 에서는 `숫자1`부터 `숫자3` 만큼 증가하여 `숫자2`미만이 될때까지 루프를 돌면서 실행하게 됩니다.

마지막에 `<= <타입> <변수명>`를 넣어주게 되면 증가하는 값을 정의하여 가져 올수도 있습니다.

형태 3
```
0^10^1 {
	ㅆㅁㅆ :ㅁ_
}<=ㅇㅈㅇ ㅁ

출력
0
1
2
3
4
5
6
7
8
9
```

형태 2
```
^[1, 3, 5]^ {
	ㅆㅁㅆ :ㅁ_
}<=ㅇㅈㅇ ㅁ

출력
1
3
5
```

### \$ㅅ\$문
출시 버전 : 3.1.0
형태 : `$ㅅ$ <블린> {...}`
최신 업데이트 버전 : 3.1.2
while문으로 블린이 `ㅇㅇ`일 때 {...}를 동작하며, `ㄴㄴ`일때 루프를 빠져 나오게 됩니다.
```
ㅇㅈㅇ 포지션:0
$ㅅ$ ㅇㄴ :포지션_ ㅇ=ㅇ 10 {
	포지션: :포지션_ ㅇ+ㅇ 1
    ㅅㅁㅅ Hello
}

출력
HelloHelloHelloHelloHelloHelloHelloHelloHelloHello
```

## 반복문 제어
`cut off zone`원칙으로 `?ㅅ?`안에 반복문 제어문을 사용하여도 `?ㅅ?`존 안에서는 반복문 존에 영향이 가지 않으므로 반복문제어문이 가지고 있는 문법을 통해 조건을 맞추게 됩니다.

### ㅂㅇㅂ
출시 버전 : 3.1.0
최신 업데이트 버전 : 3.1.2
형태1 : `ㅂㅇㅂ`
형태2 : `<블린>?ㅂㅇㅂ`
break와 같은 동작으로 해당 라인이 실행 되면 루프문에서 빠져나가게 됩니다.

형태2같이 정의하게 된다면 `ㅇㅇ`일때는 해당 루프문을 빠져나가지만 `ㄴㄴ`이라면 빠져나가지 않습니다.
```
0^10^1 {
	ㄴㄴ?ㅂㅇㅂ
	ㅆㅁㅆ 패스
    ㅇㅇ?ㅂㅇㅂ
}

출력 
패스
```


### ㅋㅇㅋ
출시 버전 : 3.1.0
최신 업데이트 버전 : 3.1.2
형태1 : `ㅋㅇㅋ`
형태2 : `<블린>?ㅋㅇㅋ`
continue와 같은 동작으로 해당 라인이 실행 되면 다음 루프문으로 넘어가게 됩니다.

형태2같이 정의하게 된다면 `ㅇㅇ`일때는 해당 루프문을 빠져나가지만 `ㄴㄴ`이라면 빠져나가지 않습니다.
```
ㅇㅂㅇ ㅂ:ㄴㄴ
0^10^1 {
	ㅂ::ㅁ_ㅇ>ㅇ5
    :ㅂ_?ㅋㅇㅋ
	ㅆㅁㅆ 패스 :ㅁ_
}<=ㅇㅈㅇ ㅁ

출력
패스 0
패스 1
패스 2
패스 3
패스 4
패스 5
```

---

# 시스템
### ㄲㅌㄲ
출시 버전 : 2.1.1
형태 : `ㄲㅌㄲ`
코드를 <span style="color: yellow">강제 종료</span>합니다.
```
ㄲㅌㄲ
```

### =\_=
출시 버전 : 2.1.1
형태 : `=_= <정수>`
(정수 값 / 1000) 초 만큼 멈추게 합니다.
```
=_= 1000

(1초 정지)


```


### ㅍㅅㅍ
출시 버전 : 3.0.0
형태 : `ㅍㅅㅍ <파일 경로>`
파일 경로에 있는 코드를 실행합니다.

test/test2.otl
```
ㅆㅁㅆ :안녕_
```

main.otl
```
ㅇㅁㅇ 안녕:테스트
ㅍㅅㅍ test~test2

출력
테스트
```

---

# 메소드
## ㅁㅅㅁ
메소드를 정의합니다.
안정화 버전 : 3.1.2
형태 : `ㅁㅅㅁ <메소드명><파라미터> {...}`
```
ㅁㅅㅁ 메소드명[] {
	ㅆㅁㅆ 메소드 출력
}

메소드명[]

출력
메소드 출력
```
```
ㅁㅅㅁ 메소드명[ㅇㅁㅇ 파라미터] {
	ㅆㅁㅆ 출력 :파라미터_
}

메소드명[값]

출력
출력 값
```
```
ㅇㅁㅇ 파라미터:안녕
ㅁㅅㅁ 메소드명[ㅇㅁㅇ 파라미터] {
	ㅆㅁㅆ :~파라미터_
	ㅆㅁㅆ :파라미터_
}

메소드명[하세요.]

출력
안녕
하세요.
```

# 클래스
### ㅋㅅㅋ
출시 버전 : 3.2.0
최신 업데이트 버전 : 3.2.0
형태 : `ㅋㅅㅋ <클래스명><파라미터> {...}`
클래스 안에는 메소드를 생성할 수 있으며, 반복적인 동작을 해결할 수 있습니다.
```
ㅇㅈㅇ 정수:1
ㅋㅅㅋ 클래스명[] {
    ㅇㅈㅇ 정수:2
    ㅆㅁㅆ 클래스 생성됨
    ㅁㅅㅁ 메소드명[] {
        ㅇㅈㅇ 정수:3
        ㅆㅁㅆ :정수_
        ㅆㅁㅆ :~정수_
        ㅆㅁㅆ :~~정수_
    }
}

클래스명[]
클래스명~메소드명[]

출력
클래스 생성됨
3
2
1
```

---

# 기타 정보
## 개발 환경
1. Visual Studio Code
[VSCODE Download Link](https://code.visualstudio.com/)
[OTLanguage Marketplace](https://marketplace.visualstudio.com/items?itemName=PersesTitan.otl)
![](https://velog.velcdn.com/images/persestitan/post/858b2ba5-c4c2-4b87-83a6-57a409a95e66/image.png)

2. Vim
[Vim Download Link](https://www.vim.org/download.php)
![](https://velog.velcdn.com/images/persestitan/post/e2b081eb-0d82-40f7-b738-4f6be16b6660/image.png)

## Github 저장소
[PersesTitan Github](https://github.com/PersesTitan)
[OTLanguage Github](https://github.com/OTLanguage)

## Github 뱃지

HTML
```html 
<img src="https://raw.githubusercontent.com/OTLanguage/.github/main/image/OTLanguage-flat.svg"/>
<img src="https://raw.githubusercontent.com/OTLanguage/.github/main/image/OTLanguage-flat-square.svg"/>
<img src="https://raw.githubusercontent.com/OTLanguage/.github/main/image/OTLANGUAGE-for-the-badge.svg"/>
<img src="https://raw.githubusercontent.com/OTLanguage/.github/main/image/OTLanguage-plastic.svg"/>
<img src="https://raw.githubusercontent.com/OTLanguage/.github/main/image/OTLanguage-social.svg"/>
```

MarkDown
```md
![](https://raw.githubusercontent.com/OTLanguage/.github/main/image/OTLanguage-flat.svg)
![](https://raw.githubusercontent.com/OTLanguage/.github/main/image/OTLanguage-flat-square.svg)
![](https://raw.githubusercontent.com/OTLanguage/.github/main/image/OTLANGUAGE-for-the-badge.svg)
![](https://raw.githubusercontent.com/OTLanguage/.github/main/image/OTLanguage-plastic.svg)
![](https://raw.githubusercontent.com/OTLanguage/.github/main/image/OTLanguage-social.svg)
```

### 출력
<img src="https://raw.githubusercontent.com/OTLanguage/.github/main/image/OTLanguage-flat.svg"/>
<img src="https://raw.githubusercontent.com/OTLanguage/.github/main/image/OTLanguage-flat-square.svg"/>
<img src="https://raw.githubusercontent.com/OTLanguage/.github/main/image/OTLANGUAGE-for-the-badge.svg"/>
<img src="https://raw.githubusercontent.com/OTLanguage/.github/main/image/OTLanguage-plastic.svg"/>
<img src="https://raw.githubusercontent.com/OTLanguage/.github/main/image/OTLanguage-social.svg"/>

---

내용 수정 및 추가 예정
22/11/10 - ver 3.1.1
- ~~poison 동작 문제 확인~~
- ~~확장자 에러 메세지 표시 문제~~
- ~~\$ㅅ\$ 동작 문제 확인~~

22/11/14 - ver 3.1.2
- poison 동작 문제 해결
- 확장자 에러 메세지 표시 문제 해결
- \$ㅅ\$ 동작 문제 확인 해결
- 메소드 문제 해결
- 연산 속도 상향과 문법 간편화

22/11/23 - ver 3.2.0
- install 버전 업
- ㅇㅁㅇ index 추가
- ㅇㅁㅇ lastIndex 추가
- ㅇㅁㅇ subString 추가
- 숫자 Abs 추가
- 숫자 Min, Max 추가
- 클래스 문법 추가
- LCS (Line Cleanup System) 최적화

22/12/07 - ver x.x.x
- 윈도우 프로토타입 버전 업로드
