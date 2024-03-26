<template>
    <h1> {{ props.readValue }} </h1>
    자식의 ReadValue: <input v-model="props.readValue"/>
</template>
<script setup>

    import { defineProps } from 'vue'
    const props = defineProps({
        readValue: {
            type: String
        }
    })

</script>