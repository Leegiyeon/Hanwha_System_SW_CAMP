<template>
    <h3>전달 받은 props: {{ props.message }}</h3>
</template>

<script setup>
    // import { defineProps } from 'vue';

    // defineProps 함수를 활용해 String 타입의 message props를 받아 Props 변수에 담는다.
    const props = defineProps({
        message: String
    })
</script>


