<template>
  <div id="app">
    <h3>{{ message }}</h3>
    <EditForm/>
  </div>
</template>

<script>
import EditForm from "./components/EditForm";

export default {
  name: "app",
  components: {
    EditForm
  },
  computed: {
    // ローカルの message とストアの messageを同期
    message() { return this.$store.getters.message }
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
