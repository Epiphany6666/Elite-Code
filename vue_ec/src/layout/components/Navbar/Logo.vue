<script setup lang="ts" name="Logo">
</script>

<template>
  <div class="navbar-logo-container">
    <img class="navbar-logo" src="/favicon.ico" />
    <span class="navbar-title">易扣</span>
  </div>
</template>

<style scoped>
.navbar-logo-container {
  line-height: 50px;
  overflow: hidden;

  .navbar-logo {
    height: 22px;
    vertical-align: middle;
  }

  .navbar-title {
    font-size: 16px;
    display: inline-block;
    margin-left: 5px;
  }
}
</style>
