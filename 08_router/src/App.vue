<script setup>
  import {RouterLink, RouterView} from 'vue-router';
</script>

<!-- npm install vue-router@next

  RouterLink
  사용자가 다른 라우터에 접속할 수 있도록하는 링크를 생성해준다.
  RouterLink의 속성
  1. to: 이동할 라우터 경로(uri)
  2. acive-class: 현재 라우터와 일치할 때 적용할 css 클래스 지정

  RouterView
  현재 라우터에 해당하는 컴포넌트를 랜더링하는 지점을 정하기위해 사용된다.
  vue-router가 현재 uri에 따라 매칭되는 컴포넌트를 찾으면, 해당 컴포넌트를 RouterView내부에 랜더링하여 이를통해 페이지 간의 전환을 구현할 수 있다.

  일반적으로 RouterLink와 RouterView를 함께 사용한다.
-->

<template>
  <header>
    <h1>Router 사용하기</h1>
    <hr>
    <div class="wrapper">
      <h2>basic router</h2>
      <nav>
        <RouterLink to="/" active-class="active" replace>Home</RouterLink>
        <RouterLink to="/pathvariable/1" active-class="active" replace>PathVariable</RouterLink>
        <RouterLink to="/querystring?name=홍길동&age=20" active-class="active">QueryString</RouterLink>
      </nav>
    </div>
  </header>

  <main>
    <RouterView/>
  </main>
</template>

<style scoped>
  nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
  font-size: 30px;
}

a {
  margin-left: 10px;
}

.active {
  color: red;
}

main {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

header {
  text-align: center;
}
</style>

