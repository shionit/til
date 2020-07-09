<template>
  <div class="edit-form">
    <h3>バインドとイベントを使った場合</h3>
    <input type="text" :value="message" @input="doUpdate">
    <h3>v-model を使った場合</h3>
    <input v-model="message2">
  </div>
</template>

<script>
export default {
  name: "EditForm",
  computed: {
    message() {
      return this.$store.getters.message
    },
    message2: {
      get() { return this.$store.getters.message },
      set(value) { this.$store.dispatch('doUpdate', value) } 
    }
  },
  methods: {
    doUpdate(event) {
      // inpute の値を持ってディスパッチ
      this.$store.dispatch('doUpdate', event.target.value)
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
