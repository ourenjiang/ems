<script setup>
import Versions from './components/Versions.vue'
import AcDataDisplay from './components/AcDataDisplay.vue';

// const ipcHandle = () => window.electron.ipcRenderer.send('ping')
</script>

<template>
  <!-- <div class="actions">
    <div class="action">
      <a href="https://electron-vite.org/" target="_blank" rel="noreferrer">Documentation</a>
    </div>
    <div class="action">
      <a target="_blank" rel="noreferrer" @click="ipcHandle">Send IPC</a>
    </div>
  </div> -->
  <!-- <Versions /> -->
  <AcDataDisplay />
</template>
